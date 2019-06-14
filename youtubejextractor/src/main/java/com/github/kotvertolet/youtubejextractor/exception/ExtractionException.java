package com.github.kotvertolet.youtubejextractor.exception;

public class ExtractionException extends Exception {

    public ExtractionException(String message) {
        super(message);
    }

    public ExtractionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExtractionException(Throwable cause) {
        super(cause);
    }
}
