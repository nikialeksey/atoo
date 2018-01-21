package com.nikialeksey.atoo.matrix;

public class Ortho implements GlMatrixOperation {

    private final GlMatrixFactory factory;
    private final int width;
    private final int height;

    public Ortho(
        final GlMatrixFactory factory,
        final int width,
        final int height
    ) {
        this.factory = factory;
        this.width = width;
        this.height = height;
    }

    @Override
    public GlMatrix result() {
        final GlMatrix result = factory.matrix();
        final float[] resultData = result.asFloatArray();
        android.opengl.Matrix.orthoM(resultData, 0, 0f, width, 0.0f, height, 0, 1);
        result.update(resultData);
        return result;
    }
}
