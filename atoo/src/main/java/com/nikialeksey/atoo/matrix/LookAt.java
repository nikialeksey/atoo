package com.nikialeksey.atoo.matrix;

import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.geometry.GlPoint;

public final class LookAt implements GlMatrixOperation {

    private final GlMatrixFactory factory;
    private final GlPoint eye;
    private final GlPoint center;
    private final GlPoint up;

    public LookAt(
        final GlMatrixFactory factory,
        final GlPoint eye,
        final GlPoint center,
        final GlPoint up
    ) {
        this.factory = factory;
        this.eye = eye;
        this.center = center;
        this.up = up;
    }

    @Override
    public GlMatrix result() throws GlException {
        final GlMatrix matrix = factory.matrix();
        final float[] matrixData = matrix.asFloatArray();
        try {
            android.opengl.Matrix.setLookAtM(
                matrixData, 0,
                eye.x(), eye.y(), eye.z(),
                center.x(), center.y(), center.z(),
                up.x(), up.y(), up.z()
            );
        } catch (Exception e) {
            throw new GlException("Can't look at me", e);
        }
        matrix.update(matrixData);
        return matrix;
    }
}
