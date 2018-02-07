package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.background.GlBackground;
import com.nikialeksey.atoo.exception.GlException;

public final class Rectangle implements View {

    private final Shape shape;

    public Rectangle(
        final GlPointShader pointShader,
        final GlBackground background,
        final GlPoint start,
        final float width, final float height
    ) {
        this(
            pointShader,
            new RectanglePoints(start, width, height),
            background
        );
    }

    public Rectangle(
        final GlPointShader pointShader,
        final GlBackground background,
        final RectanglePoints points
    ) {
        this(pointShader, points, background);
    }

    private Rectangle(
        final GlPointShader pointShader,
        final GlPoints points,
        final GlBackground background
    ) {
        this(new Shape(pointShader, points, background));
    }

    private Rectangle(final Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() throws GlException {
        shape.draw();
    }

}
