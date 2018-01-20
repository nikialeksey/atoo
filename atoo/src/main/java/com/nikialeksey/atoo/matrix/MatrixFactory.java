package com.nikialeksey.atoo.matrix;

public class MatrixFactory implements GlMatrixFactory {
    @Override
    public GlMatrix matrix() {
        return new Matrix();
    }
}
