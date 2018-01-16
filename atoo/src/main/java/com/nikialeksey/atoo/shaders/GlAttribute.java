package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;

public class GlAttribute implements Attribute {

    private final ShaderProgram shaderProgram;
    private final String name;

    public GlAttribute(final ShaderProgram shaderProgram, final String name) {
        this.shaderProgram = shaderProgram;
        this.name = name;
    }

    @Override
    public int link() {
        return GLES20.glGetAttribLocation(shaderProgram.link(), name);
    }
}
