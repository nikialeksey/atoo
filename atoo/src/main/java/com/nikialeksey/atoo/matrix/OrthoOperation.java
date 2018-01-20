package com.nikialeksey.atoo.matrix;

import com.nikialeksey.atoo.screen.GlScreen;

public class OrthoOperation implements GlMatrixOperation {

    private final GlMatrixFactory factory;
    private final GlScreen screen;
    private final int far;

    public OrthoOperation(
        final GlMatrixFactory factory,
        final GlScreen screen,
        final int far
    ) {
        this.factory = factory;
        this.screen = screen;
        this.far = far;
    }

    @Override
    public GlMatrix result() {
        final GlMatrix result = factory.matrix();
        final float[] resultData = result.asFloatArray();
        final int width = screen.width();
        final int height = screen.height();
        android.opengl.Matrix.orthoM(resultData, 0, 0f, width, 0.0f, height, 0, far);
        result.update(resultData);
        return result;
    }
}
