package com.nikialeksey.freetype2.glyph;

import java.util.Arrays;

public class Bitmap {
    private final byte[] buffer;
    private final int width;
    private final int height;

    public Bitmap(final byte[] buffer, final int width, final int height) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Bitmap{"
            + ", width="
            + width
            + ", height="
            + height
            + '}';
    }
}
