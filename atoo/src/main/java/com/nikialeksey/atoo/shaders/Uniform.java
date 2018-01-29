package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;
import java.io.IOException;

public final class Uniform implements GlUniform {

    private final GlShaderProgram shaderProgram;
    private final String name;

    public Uniform(final GlShaderProgram shaderProgram, final String name) {
        this.shaderProgram = shaderProgram;
        this.name = name;
    }

    @Override
    public int link() throws IOException {
        return GLES20.glGetUniformLocation(shaderProgram.link(), name);
    }
}
