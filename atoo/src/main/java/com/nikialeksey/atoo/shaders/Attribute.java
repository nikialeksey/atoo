package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;

public class Attribute implements GlAttribute {

    private final GlShaderProgram shaderProgram;
    private final String name;

    public Attribute(final GlShaderProgram shaderProgram, final String name) {
        this.shaderProgram = shaderProgram;
        this.name = name;
    }

    @Override
    public int link() {
        return GLES20.glGetAttribLocation(shaderProgram.link(), name);
    }
}
