package com.nikialeksey.atoo.shaders;

import android.opengl.GLES31;

public final class FragmentType implements GlShaderType {
    @Override
    public int value() {
        return GLES31.GL_FRAGMENT_SHADER;
    }
}
