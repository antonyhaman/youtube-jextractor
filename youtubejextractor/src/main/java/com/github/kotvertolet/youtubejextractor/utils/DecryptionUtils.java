package com.github.kotvertolet.youtubejextractor.utils;

import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.google.code.regexp.Matcher;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.github.kotvertolet.youtubejextractor.utils.CommonUtils.getMatcher;

public class DecryptionUtils {

    // Includes function declaration and it's assignment
    private String jsDecryptFunction;
    // Includes only function body
    private String jsDecryptFunctionBody;
    private ArrayList<String> jsObjects;
    private String playerJsCode;
    private Context jsContext;
    private Scriptable scope;

    public DecryptionUtils(String playerJsCode, String functionNameToExtract) throws SignatureDecryptionException {
        this.playerJsCode = playerJsCode;
        Matcher rawExtractedFunction = extractJsFunction(functionNameToExtract);
        jsDecryptFunction = extractFunctionWithAssignment(rawExtractedFunction);
        jsDecryptFunctionBody = extractFunctionBody(rawExtractedFunction);
        List<String> jsDecryptFunctionArgumentsNames = extractFunctionArgs(rawExtractedFunction);
        jsObjects = extractJsObjectsIfAny(jsDecryptFunctionBody, jsDecryptFunctionArgumentsNames);
        jsContext = prepareJsContext(jsObjects);
    }

    public String decryptSignature(String encryptedSignature) throws SignatureDecryptionException {
        Object result = jsContext.evaluateString(scope, String.format("%s('%s')", jsDecryptFunction, encryptedSignature), "", 0, null);
        if (result instanceof String) {
            return result.toString();
        } else {
            throw new SignatureDecryptionException("Decryption function returned no result, function was: \n"
                    + jsDecryptFunction + "\n parameter was: " + encryptedSignature + "\n"
                    + "js objects were: " + jsObjects.toString());
        }
    }

    /**
     * Creates JS context with all objects and functions to execute decryption function in future
     *
     * @param jsObjects js objects that are referenced in a decryption function
     * @return JS context with all objects and functions to execute decryption function
     */
    private Context prepareJsContext(List<String> jsObjects) {
        Context jsContext = Context.enter();
        jsContext.setOptimizationLevel(-1);
        scope = jsContext.initStandardObjects();
        for (String jsObject : jsObjects) {
            jsContext.evaluateString(scope, jsObject, "", 0, null);
        }
        return jsContext;
    }

    /**
     * Extracts decryption js function from youtube player code, later it is used to extract
     * it's arguments names, function body, etc
     *
     * @param funcName name of the function to extract
     * @return matcher that points to the required function
     */
    private Matcher extractJsFunction(String funcName) throws SignatureDecryptionException {
        String escapedFuncName = StringUtils.escapeRegExSpecialCharacters(funcName);
        String stringPattern = String.format("(?x)(?:function\\s+%s|[{;,]\\s*%s\\s*=\\s*function|var" +
                        "\\s+%s\\s*=\\s*function)\\s*\\((?<args>[^)]*)\\)\\s*\\{(?<code>[^}]+)\\}",
                escapedFuncName, escapedFuncName, escapedFuncName);
        Matcher matcher = getMatcher(stringPattern, playerJsCode);
        if (!matcher.find()) {
            throw new SignatureDecryptionException("Could not find JS function with name " + funcName);
        } else {
            return matcher;
        }
    }

    /**
     * Extracts whole function, including it's assignment and body
     *
     * @param matcher matcher that point to the function
     * @return returns function with it's assignment, for example: var a = function(b) {...}
     */
    private String extractFunctionWithAssignment(Matcher matcher) {
        String extractedFunction = matcher.group();
        if (extractedFunction.startsWith(";\n")) {
            extractedFunction = extractedFunction.replace(";\n", "");
        }
        return extractedFunction;
    }

    /**
     * Extracts arguments names from the function
     *
     * @param matcher matcher that point to the function
     * @return returns list with args names
     */
    private List<String> extractFunctionArgs(Matcher matcher) {
        return Arrays.asList(matcher.group("args").split(","));
    }

    /**
     * Extracts function body (everything inside of {})
     *
     * @param matcher matcher that point to the function
     * @return function body
     */
    private String extractFunctionBody(Matcher matcher) {
        return matcher.group("code");
    }

    /**
     * Js decryption function contains method calls from other objects inside of the player code,
     * this method is meant to extract them in order to use decryption function
     *
     * @param functionCode Decrypt function extracted from player code
     * @param argNames     Decrypt function args names
     * @return List of extracted objects
     */
    private ArrayList<String> extractJsObjectsIfAny(String functionCode, List<String> argNames) throws SignatureDecryptionException {
        Matcher matcher;
        String[] expressionsArr = functionCode.split(";");

        HashMap<String, String> objectFieldsAndStatements = new HashMap<>();
        String charsAndDigitsMask = "[a-zA-Z_$][a-zA-Z_$0-9]*";
        String stringPattern = String.format("(?<var>%s)(?:\\.(?<member>[^(]+)|" +
                "\\[(?<member2>[^]]+)\\])\\s*", charsAndDigitsMask);
        for (String expression : expressionsArr) {
            matcher = getMatcher(stringPattern, expression);
            if (matcher.find()) {
                String variable = matcher.group("var");
                String member = matcher.group("member");
                if (member == null) {
                    member = matcher.group("member2");
                }
                if (argNames.contains(variable)) {
                    continue;
                } else {
                    if (!objectFieldsAndStatements.containsKey(member)) {
                        objectFieldsAndStatements.putAll(extractJsObject(variable));
                    }
                }
            }
        }
        return jsObjects;
    }

    /**
     * Extracts js object by it's name from player code
     *
     * @param objectName name of the object to extract
     * @return map where key is object's field name and value is field's value
     */
    private HashMap<String, String> extractJsObject(String objectName) throws SignatureDecryptionException {
        HashMap<String, String> obj = new HashMap<>();
        jsObjects = new ArrayList<>();
        String funcNamePattern = "(?:[a-zA-Z$0-9]+|\"[a-zA-Z$0-9]+\"|'[a-zA-Z$0-9]+')";
        String stringPattern = String.format("(?x)(?<!this\\.)%s\\s*=\\s*\\{\\s*" +
                        "(?<fields>(%s\\s*:\\s*function\\s*(.*?)\\s*\\{.*?\\}(?:,\\s*)?)*)\\}\\s*;",
                StringUtils.escapeRegExSpecialCharacters(objectName), funcNamePattern);
        Matcher matcher = getMatcher(stringPattern, playerJsCode);
        if (matcher.find()) {
            jsObjects.add(matcher.group());
            String fields = matcher.group("fields");
            stringPattern = String.format("(?x)(?<key>%s)\\s*:\\s*function\\s*" +
                    "\\((?<args>[a-z,]+)\\)\\{(?<code>[^}]+)\\}", funcNamePattern);
            matcher = getMatcher(stringPattern, fields);
            while (matcher.find()) {
                obj.put(matcher.group("key"), matcher.group("code"));
            }
            return obj;
        } else {
            throw new SignatureDecryptionException(String.format("Js object with name '%s' wasn't found", objectName));
        }
    }
}
