package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;
import org.cactoos.iterable.IterableOf;

public class GlShaderProgram implements ShaderProgram {

    private final Iterable<Shader> shaders;

    public GlShaderProgram(final Shader... shaders) {
        this.shaders = new IterableOf<>(shaders);
    }

    @Override
    public int link() {
        final int link = GLES20.glCreateProgram();

        for (final Shader shader : shaders) {
            GLES20.glAttachShader(link, shader.link());
        }

        GLES20.glLinkProgram(link);
        GLES20.glUseProgram(link);

        return link;
    }
}
