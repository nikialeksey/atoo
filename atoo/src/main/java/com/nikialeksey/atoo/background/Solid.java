package com.nikialeksey.atoo.background;

import com.nikialeksey.atoo.color.Colors;
import com.nikialeksey.atoo.color.GlColor;
import com.nikialeksey.atoo.color.GlColors;
import com.nikialeksey.atoo.geometry.GlPoints;
import com.nikialeksey.catoo.func.Cached;
import org.cactoos.Func;
import org.cactoos.func.UncheckedFunc;

public final class Solid implements GlBackground {

    private final UncheckedFunc<Integer, GlColors> toColors;

    public Solid(final GlColor color) {
        this((count) -> new Colors(color, count));
    }

    private Solid(final Func<Integer, GlColors> toColors) {
        this(new UncheckedFunc<>(new Cached<>(toColors)));
    }

    private Solid(final UncheckedFunc<Integer, GlColors> toColors) {
        this.toColors = toColors;
    }

    @Override
    public GlColors colors(final GlPoints points) {
        return toColors.apply(points.count());
    }
}
