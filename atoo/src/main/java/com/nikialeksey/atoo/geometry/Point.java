package com.nikialeksey.atoo.geometry;

import org.cactoos.Scalar;

public final class Point implements GlPoint {

    private final Scalar<Float> x;
    private final Scalar<Float> y;
    private final Scalar<Float> z;

    public Point(final GlPoint origin) {
        this(origin::x, origin::y, origin::z);
    }

    public Point(final float x, final float y) {
        this(x, y, 0);
    }

    public Point(final float x, final float y, final float z) {
        this(() -> x, () -> y, () -> z);
    }

    public Point(final Scalar<Float> x, final Scalar<Float> y) {
        this(x, y, () -> 0f);
    }

    public Point(final Scalar<Float> x, final Scalar<Float> y, final Scalar<Float> z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public float x() throws Exception {
        return x.value();
    }

    @Override
    public float y() throws Exception {
        return y.value();
    }

    @Override
    public float z() throws Exception {
        return z.value();
    }
}
