package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;

public class GlUniform implements Uniform {

    private final ShaderProgram shaderProgram;
    private final String name;

    public GlUniform(final ShaderProgram shaderProgram, final String name) {
        this.shaderProgram = shaderProgram;
        this.name = name;
    }

    @Override
    public int link() {
        return GLES20.glGetUniformLocation(shaderProgram.link(), name);
    }
}
