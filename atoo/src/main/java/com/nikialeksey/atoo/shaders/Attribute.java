package com.nikialeksey.atoo.shaders;

import android.opengl.GLES31;
import java.io.IOException;

public final class Attribute implements GlAttribute {

    private final GlShaderProgram shaderProgram;
    private final String name;

    public Attribute(final GlShaderProgram shaderProgram, final String name) {
        this.shaderProgram = shaderProgram;
        this.name = name;
    }

    @Override
    public int link() throws IOException {
        return GLES31.glGetAttribLocation(shaderProgram.link(), name);
    }
}
