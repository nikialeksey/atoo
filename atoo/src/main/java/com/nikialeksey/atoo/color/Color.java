package com.nikialeksey.atoo.color;

import org.cactoos.Scalar;
import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.UncheckedScalar;

public class Color implements GlColor {

    private static final int MAX_COLOR_INT = 255;

    private final UncheckedScalar<Float> r;
    private final UncheckedScalar<Float> g;
    private final UncheckedScalar<Float> b;
    private final UncheckedScalar<Float> a;

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
        this(
            new UncheckedScalar<>(r),
            new UncheckedScalar<>(g),
            new UncheckedScalar<>(b),
            new UncheckedScalar<>(a)
        );
    }

    public Color(
        final UncheckedScalar<Float> r,
        final UncheckedScalar<Float> g,
        final UncheckedScalar<Float> b,
        final UncheckedScalar<Float> a
    ) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    @Override
    public float r() {
        return r.value();
    }

    @Override
    public float g() {
        return g.value();
    }

    @Override
    public float b() {
        return b.value();
    }

    @Override
    public float a() {
        return a.value();
    }
}
