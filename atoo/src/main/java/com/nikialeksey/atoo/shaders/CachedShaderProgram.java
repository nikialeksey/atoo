package com.nikialeksey.atoo.shaders;

import java.io.IOException;

public final class CachedShaderProgram implements GlShaderProgram {

    private final GlHandler originGlHandler;

    public CachedShaderProgram(final GlShaderProgram origin) {
        this.originGlHandler = new CachedHandler(origin);
    }

    @Override
    public int link() throws IOException {
        return originGlHandler.link();
    }
}
