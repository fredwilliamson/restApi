package com.fme.exception;

public class RestApiRunTimeException extends RuntimeException {

    public RestApiRunTimeException() {
        super();
    }

    public RestApiRunTimeException(String message) {
        super(message);
    }

    public RestApiRunTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestApiRunTimeException(Throwable cause) {
        super(cause);
    }
}
