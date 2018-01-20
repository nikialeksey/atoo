package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.shaders.GlShaderProgram;

public interface GlPointShader extends GlShaderProgram {
    void draw(final GlPoints points);
    void camera(final float[] m);
}
