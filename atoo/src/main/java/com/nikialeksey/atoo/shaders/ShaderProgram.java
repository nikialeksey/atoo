package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;
import java.io.IOException;
import org.cactoos.iterable.IterableOf;

public final class ShaderProgram implements GlShaderProgram {

    private final Iterable<GlShader> shaders;

    public ShaderProgram(final GlShader... shaders) {
        this.shaders = new IterableOf<>(shaders);
    }

    @Override
    public int link() throws IOException {
        final int link = GLES20.glCreateProgram();

        for (final GlShader shader : shaders) {
            GLES20.glAttachShader(link, shader.link());
        }

        GLES20.glLinkProgram(link);
        GLES20.glUseProgram(link);

        return link;
    }
}
