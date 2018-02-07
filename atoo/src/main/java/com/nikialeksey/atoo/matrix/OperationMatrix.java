package com.nikialeksey.atoo.matrix;

import com.nikialeksey.atoo.exception.GlException;

public final class OperationMatrix implements GlMatrix {

    private final GlMatrixOperation operation;

    public OperationMatrix(final GlMatrixOperation operation) {
        this.operation = operation;
    }

    @Override
    public float[] asFloatArray() throws GlException {
        return operation.result().asFloatArray();
    }

    @Override
    public void update(final float[] inside) {
        // ignored
    }
}
