package com.github.kotvertolet.youtubejextractor.exception;

public class SignatureDecryptException extends Exception {

    public SignatureDecryptException(String message) {
        super(message);
    }

    public SignatureDecryptException(String message, Throwable cause) {
        super(message, cause);
    }
}
