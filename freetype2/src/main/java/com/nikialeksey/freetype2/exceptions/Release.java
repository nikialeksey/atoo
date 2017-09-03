package com.nikialeksey.freetype2.exceptions;

public class Release extends RuntimeException implements Freetype2Exception {

    private final String message;

    public Release(final String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
