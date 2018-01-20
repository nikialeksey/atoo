package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;

public class FragmentType implements GlShaderType {
    @Override
    public int value() {
        return GLES20.GL_FRAGMENT_SHADER;
    }
}
