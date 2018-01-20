package com.nikialeksey.atoo.screen;

public class Screen implements GlScreen {

    private final int width;
    private final int height;

    public Screen(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }
}
