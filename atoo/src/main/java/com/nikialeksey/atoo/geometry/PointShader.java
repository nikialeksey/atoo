package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.shaders.GlShaderProgram;

public interface PointShader extends GlShaderProgram {
    void draw(final Points points);
    void camera(final float[] m);
}
