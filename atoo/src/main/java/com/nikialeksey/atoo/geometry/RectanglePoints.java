package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import java.nio.ShortBuffer;
import org.cactoos.Scalar;

public final class RectanglePoints implements GlPoints {

    private final GlPoints origin;

    public RectanglePoints(final GlPoint start, final float width, final float height) {
        this(start, () -> width, () -> height);
    }

    public RectanglePoints(
        final GlPoint start,
        final Scalar<Float> width,
        final Scalar<Float> height
    ) {
        this(
            new Points(
                start,
                new Point(start::x, () -> start.y() + height.value()),
                new Point(() -> start.x() + width.value(), () -> start.y() + height.value()),
                new Point(() -> start.x() + width.value(), start::y)
            )
        );
    }

    private RectanglePoints(final GlPoints origin) {
        this.origin = origin;
    }

    @Override
    public int count() {
        return origin.count();
    }

    @Override
    public void updateAttribute(final int link) throws GlException {
        origin.updateAttribute(link);
    }

    @Override
    public GlBuffer<ShortBuffer> triangulation() {
        return origin.triangulation();
    }
}
