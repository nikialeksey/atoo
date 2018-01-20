package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;
import org.cactoos.iterable.IterableOf;

public class ShaderProgram implements GlShaderProgram {

    private final Iterable<GlShader> shaders;

    public ShaderProgram(final GlShader... shaders) {
        this.shaders = new IterableOf<>(shaders);
    }

    @Override
    public int link() {
        final int link = GLES20.glCreateProgram();

        for (final GlShader shader : shaders) {
            GLES20.glAttachShader(link, shader.link());
        }

        GLES20.glLinkProgram(link);
        GLES20.glUseProgram(link);

        return link;
    }
}
