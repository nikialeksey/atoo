package com.nikialeksey.atoo.shaders;

public class CachedShaderProgram implements ShaderProgram {

    private final Handler originHandler;

    public CachedShaderProgram(final ShaderProgram origin) {
        this.originHandler = new CachedHandler(origin);
    }

    @Override
    public int link() {
        return originHandler.link();
    }
}
