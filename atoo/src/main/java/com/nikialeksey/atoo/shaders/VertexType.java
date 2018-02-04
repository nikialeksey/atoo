package com.nikialeksey.atoo.shaders;

import android.opengl.GLES31;

public final class VertexType implements GlShaderType {
    @Override
    public int value() {
        return GLES31.GL_VERTEX_SHADER;
    }
}
