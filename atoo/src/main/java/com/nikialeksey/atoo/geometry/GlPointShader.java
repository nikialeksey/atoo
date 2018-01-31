package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.color.GlColors;
import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.matrix.GlMatrix;
import com.nikialeksey.atoo.shaders.GlShaderProgram;

public interface GlPointShader extends GlShaderProgram {
    void updatePosition(final GlPoints points) throws GlException;
    void updateColor(final GlColors colors) throws GlException;
    void updateCamera(final GlMatrix camera) throws GlException;
}
