package com.example.tokio.excepion;

public class FeeException extends Exception {
    public FeeException() {
        super();
    }

    public FeeException(String message) {
        super(message);
    }

    public FeeException(String message, Throwable cause) {
        super(message, cause);
    }
}
