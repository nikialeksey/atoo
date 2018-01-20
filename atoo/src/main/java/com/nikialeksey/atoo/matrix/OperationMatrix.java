package com.nikialeksey.atoo.matrix;

public class OperationMatrix implements GlMatrix {

    private final GlMatrixOperation operation;

    public OperationMatrix(final GlMatrixOperation operation) {
        this.operation = operation;
    }

    @Override
    public float[] asFloatArray() {
        return operation.result().asFloatArray();
    }

    @Override
    public void update(final float[] inside) {
        // ignored
    }
}
