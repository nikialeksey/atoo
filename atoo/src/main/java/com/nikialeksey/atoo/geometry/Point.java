package com.nikialeksey.atoo.geometry;

public final class Point implements GlPoint {

    private final float x;
    private final float y;
    private final float z;

    public Point(final float x, final float y) {
        this(x, y, 0);
    }

    public Point(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public float x() {
        return x;
    }

    @Override
    public float y() {
        return y;
    }

    @Override
    public float z() {
        return z;
    }
}
