package com.nikialeksey.freetype2.exceptions;

public class Initialize extends RuntimeException implements Freetype2Exception {

    private final String message;

    public Initialize(final String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
