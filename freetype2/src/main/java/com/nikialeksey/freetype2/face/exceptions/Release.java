package com.nikialeksey.freetype2.face.exceptions;

import com.nikialeksey.freetype2.exceptions.Freetype2Exception;

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
