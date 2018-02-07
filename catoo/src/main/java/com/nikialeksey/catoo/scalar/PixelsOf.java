package com.nikialeksey.catoo.scalar;

import org.cactoos.Scalar;

public final class PixelsOf implements Scalar<Float> {

    private final Scalar<Float> value;

    public PixelsOf(final Density density, final float dip) {
        this(() -> density.value() * dip);
    }

    private PixelsOf(final Scalar<Float> value) {
        this.value = value;
    }

    @Override
    public Float value() throws Exception {
        return value.value();
    }
}
