package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.matrix.GlMatrix;
import com.nikialeksey.atoo.shaders.GlShaderProgram;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import java.nio.FloatBuffer;

public interface GlPointShader extends GlShaderProgram {
    void updatePosition(final GlBuffer<FloatBuffer> points, final int strip);
    void updateColor(final GlBuffer<FloatBuffer> colors, final int strip);
    void updateCamera(final GlMatrix camera);
}
