package com.github.kotvertolet.youtubejextractor.exception;

public class ExtractionException extends Exception {

    private final static String ERROR_MESSAGE = "Extraction failed. Please, report here: https://github.com/kotvertolet/youtube-jextractor/issues. Error details: ";

    public ExtractionException(String message) {
        super(ERROR_MESSAGE + message);
    }

    public ExtractionException(String message, Throwable cause) {
        super(ERROR_MESSAGE + message, cause);
    }

    public ExtractionException(Throwable cause) {
        super(cause);
    }
}
