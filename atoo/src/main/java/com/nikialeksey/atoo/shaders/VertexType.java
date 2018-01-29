package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;

public final class VertexType implements GlShaderType {
    @Override
    public int value() {
        return GLES20.GL_VERTEX_SHADER;
    }
}
