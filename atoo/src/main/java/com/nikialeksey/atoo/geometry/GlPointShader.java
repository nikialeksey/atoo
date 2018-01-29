package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.matrix.GlMatrix;
import com.nikialeksey.atoo.shaders.GlShaderProgram;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import java.nio.FloatBuffer;

public interface GlPointShader extends GlShaderProgram {
    void updatePosition(final GlBuffer<FloatBuffer> points, final int strip) throws GlException;
    void updateColor(final GlBuffer<FloatBuffer> colors, final int strip) throws GlException;
    void updateCamera(final GlMatrix camera) throws GlException;
}
