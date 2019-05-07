package com.github.kotvertolet.utils;

import com.google.code.regexp.Matcher;
import com.google.code.regexp.Pattern;

import org.liquidplayer.javascript.JSContext;
import org.liquidplayer.javascript.JSValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DecryptionUtils {

    // Includes function declaration and it's assignment
    private String jsDecryptFunction;
    // Includes only function body
    private String jsDecryptFunctionBody;
    private ArrayList<String> jsObjects;
    private String playerJsCode;
    private JSContext jsContext;

    public DecryptionUtils(String playerJsCode, String functionNameToExtract) {
        this.playerJsCode = playerJsCode;
        Matcher rawExtractedFunction = extractJsFunction(functionNameToExtract);
        jsDecryptFunction = extractFunctionWithAssignment(rawExtractedFunction);
        jsDecryptFunctionBody = extractFunctionBody(rawExtractedFunction);
        List<String> jsDecryptFunctionArgumentsNames = extractFunctionArgs(rawExtractedFunction);
        jsObjects = extractJsObjectsIfAny(jsDecryptFunctionBody, jsDecryptFunctionArgumentsNames);
        jsContext = prepareJsContex(jsObjects, jsDecryptFunction);
    }

    public String decryptSignature(String encryptedSignature) {
        JSValue jsValue = jsContext.evaluateScript(String.format("%s('%s')", jsDecryptFunction, encryptedSignature));
        if (jsValue != null && jsValue.isString()) {
            return jsValue.toString();
        } else {
            throw new IllegalStateException("Js function returned no result, function was: \n"
                    + jsDecryptFunction + "\n parameter was: " + encryptedSignature + "\n"
                    + "js objects were: " + jsObjects.toString());
        }
    }

    private JSContext prepareJsContex(List<String> jsObjects, String jsDecryptFunction) {
        JSContext context = new JSContext();
        for (String jsObject : jsObjects) {
            context.evaluateScript(jsObject);
        }
        context.evaluateScript(jsDecryptFunction);
        return context;
    }

    private Matcher extractJsFunction(String funcName) {
        String escapedFuncName = StringUtils.escapeRegExSpecialCharacters(funcName);
        String regex = String.format("(?x)(?:function\\s+%s|[{;,]\\s*%s\\s*=\\s*function|var" +
                        "\\s+%s\\s*=\\s*function)\\s*\\((?<args>[^)]*)\\)\\s*\\{(?<code>[^}]+)\\}",
                escapedFuncName, escapedFuncName, escapedFuncName);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(playerJsCode);
        if (!matcher.find()) {
            throw new IllegalStateException("Could not find JS function " + funcName);
        } else {
            return matcher;
        }
    }

    private String extractFunctionWithAssignment(Matcher matcher) {
        String extractedFunction = matcher.group();
        if (extractedFunction.startsWith(";\n")) {
            extractedFunction = extractedFunction.replace(";\n", "");
        }
        return extractedFunction;
    }

    private List<String> extractFunctionArgs(Matcher matcher) {
        return Arrays.asList(matcher.group("args").split(","));
    }

    private String extractFunctionBody(Matcher matcher) {
        return matcher.group("code");
    }

    /**
     * Js decryption function contains method calls from other objects inside of the player code,
     * this method is meant to extract them in order to use decryption function
     *
     * @param functionCode Decrypt function extracted from player code
     * @param argNames     Decrypt function args names
     * @return List of extracted object
     */
    private ArrayList<String> extractJsObjectsIfAny(String functionCode, List<String> argNames) {
        Pattern pattern;
        Matcher matcher;
        String[] expressionsArr = functionCode.split(";");

        HashMap<String, String> objectFieldsAndStatements = new HashMap<>();
        String charsAndDigitsMask = "[a-zA-Z_$][a-zA-Z_$0-9]*";
        pattern = Pattern.compile(String.format("(?<var>%s)(?:\\.(?<member>[^(]+)|" +
                "\\[(?<member2>[^]]+)\\])\\s*", charsAndDigitsMask));
        for (String expression : expressionsArr) {
            matcher = pattern.matcher(expression);
            if (matcher.find()) {
                String variable = matcher.group("var");
                String member = matcher.group("member");
                if (member == null) {
                    member = matcher.group("member2");
                }
                if (argNames.contains(variable)) {
                    continue;
                } else {
                    if (!objectFieldsAndStatements.keySet().contains(member)) {
                        objectFieldsAndStatements.putAll(extractJsObject(variable));
                    }
                }
            }
        }
        return jsObjects;
    }

    /**
     * Extracts js object by it's name from player code
     * @param objectName name of the object to extract
     * @return map where key is object's field name and value is field's value
     */
    private HashMap<String, String> extractJsObject(String objectName) {
        HashMap<String, String> obj = new HashMap<>();
        jsObjects = new ArrayList<>();
        String funcNamePattern = "(?:[a-zA-Z$0-9]+|\"[a-zA-Z$0-9]+\"|'[a-zA-Z$0-9]+')";
        Pattern pattern = Pattern.compile(String.format("(?x)(?<!this\\.)%s\\s*=\\s*\\{\\s*" +
                        "(?<fields>(%s\\s*:\\s*function\\s*(.*?)\\s*\\{.*?\\}(?:,\\s*)?)*)\\}\\s*;",
                StringUtils.escapeRegExSpecialCharacters(objectName), funcNamePattern));
        Matcher matcher = pattern.matcher(playerJsCode);
        if (matcher.find()) {
            jsObjects.add(matcher.group());
            String fields = matcher.group("fields");
            pattern = Pattern.compile(String.format("(?x)(?<key>%s)\\s*:\\s*function\\s*" +
                    "\\((?<args>[a-z,]+)\\)\\{(?<code>[^}]+)\\}", funcNamePattern));
            matcher = pattern.matcher(fields);
            while (matcher.find()) {
                obj.put(matcher.group("key"), matcher.group("code"));
            }
            return obj;
        } else {
            throw new IllegalStateException(String.format("Js object with name '%s' wasn't found", objectName));
        }
    }
}
