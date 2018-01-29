package com.nikialeksey.atoo.matrix;

public final class MatrixFactory implements GlMatrixFactory {
    @Override
    public GlMatrix matrix() {
        return new Matrix();
    }
}
