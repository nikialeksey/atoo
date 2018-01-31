package com.nikialeksey.atoo.color;

import org.cactoos.Scalar;
import org.cactoos.scalar.StickyScalar;

public final class Color implements GlColor {

    private static final int MAX_COLOR_INT = 255;

    private final Scalar<Float> r;
    private final Scalar<Float> g;
    private final Scalar<Float> b;
    private final Scalar<Float> a;

    public Color(final float r, final float g, final float b, final float a) {
        this(
            () -> r,
            () -> g,
            () -> b,
            () -> a
        );
    }

    public Color(final int r, final int g, final int b, final int a) {
        this(
            new StickyScalar<>(() -> r / (float) MAX_COLOR_INT),
            new StickyScalar<>(() -> g / (float) MAX_COLOR_INT),
            new StickyScalar<>(() -> b / (float) MAX_COLOR_INT),
            new StickyScalar<>(() -> a / (float) MAX_COLOR_INT)
        );
    }

    public Color(
        final Scalar<Float> r,
        final Scalar<Float> g,
        final Scalar<Float> b,
        final Scalar<Float> a
    ) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    @Override
    public float r() throws Exception {
        return r.value();
    }

    @Override
    public float g() throws Exception {
        return g.value();
    }

    @Override
    public float b() throws Exception {
        return b.value();
    }

    @Override
    public float a() throws Exception {
        return a.value();
    }
}
