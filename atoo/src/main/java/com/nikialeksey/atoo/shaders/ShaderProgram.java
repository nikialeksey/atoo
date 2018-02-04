package com.nikialeksey.atoo.shaders;

import android.opengl.GLES31;
import java.io.IOException;
import org.cactoos.iterable.IterableOf;

public final class ShaderProgram implements GlShaderProgram {

    private final Iterable<GlShader> shaders;

    public ShaderProgram(final GlShader... shaders) {
        this.shaders = new IterableOf<>(shaders);
    }

    @Override
    public int link() throws IOException {
        final int link = GLES31.glCreateProgram();

        for (final GlShader shader : shaders) {
            GLES31.glAttachShader(link, shader.link());
        }

        GLES31.glLinkProgram(link);
        GLES31.glUseProgram(link);

        return link;
    }
}
