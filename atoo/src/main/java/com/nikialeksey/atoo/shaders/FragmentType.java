package com.nikialeksey.atoo.shaders;

import android.opengl.GLES20;

public class FragmentType implements ShaderType {
    @Override
    public int value() {
        return GLES20.GL_FRAGMENT_SHADER;
    }
}
