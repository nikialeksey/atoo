package com.nikialeksey.freetype2.exceptions;

public class Freetype2Exception extends RuntimeException {
    private final String message;

    public Freetype2Exception(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}

