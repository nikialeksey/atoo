package com.nikialeksey.catoo.scalar;

import android.content.Context;
import org.cactoos.Scalar;
import org.cactoos.scalar.StickyScalar;

public final class Density implements Scalar<Float> {

    private final StickyScalar<Float> density;

    public Density(final Context context) {
        this(new StickyScalar<>(() -> context.getResources().getDisplayMetrics().density));
    }

    private Density(final StickyScalar<Float> density) {
        this.density = density;
    }

    @Override
    public Float value() throws Exception {
        return density.value();
    }
}
