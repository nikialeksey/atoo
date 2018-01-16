package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.shaders.ShaderProgram;

public interface PointShader extends ShaderProgram {
    void draw(final Points points);
    void camera(final float[] m);
}
