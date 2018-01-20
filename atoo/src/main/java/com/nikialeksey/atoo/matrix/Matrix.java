package com.nikialeksey.atoo.matrix;

public class Matrix implements GlMatrix {

    private static final int SIZE = 16;

    private final float[] data;

    public Matrix() {
        this(new float[SIZE]);
    }

    public Matrix(final float[] data) {
        this.data = data;
    }

    @Override
    public float[] asFloatArray() {
        return data;
    }

    @Override
    public void update(final float[] inside) {
        System.arraycopy(inside, 0, data, 0, SIZE);
    }
}
