package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;

public class VertexType implements ShaderType {
    @Override
    public int value() {
        return GLES20.GL_VERTEX_SHADER;
    }
}
