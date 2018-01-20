package com.nikialeksey.atoo.shaders;

public class CachedShaderProgram implements GlShaderProgram {

    private final GlHandler originGlHandler;

    public CachedShaderProgram(final GlShaderProgram origin) {
        this.originGlHandler = new CachedHandler(origin);
    }

    @Override
    public int link() {
        return originGlHandler.link();
    }
}
