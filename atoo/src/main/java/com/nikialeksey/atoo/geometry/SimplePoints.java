package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.glmemory.CachedFloatBuffer;
import com.nikialeksey.atoo.glmemory.FilledFloatBuffer;
import com.nikialeksey.atoo.glmemory.FloatBuffer;
import com.nikialeksey.atoo.glmemory.GlFloatBuffer;
import java.util.List;
import org.cactoos.list.ListOf;

public class SimplePoints implements Points {

    private final List<GlPoint> glPoints;
    private final GlFloatBuffer buffer;

    public SimplePoints(final GlPoint... glPoints) {
        this(
            new ListOf<>(glPoints),
            new FilledFloatBuffer(
                new CachedFloatBuffer(new FloatBuffer(glPoints.length * 3)),
                buffer -> {
                    buffer.position(0);
                    for (final GlPoint glPoint : glPoints) {
                        buffer.put(glPoint.x());
                        buffer.put(glPoint.y());
                        buffer.put(glPoint.z());
                    }
                    buffer.position(0);
                }
            )
        );
    }

    public SimplePoints(final List<GlPoint> glPoints, final GlFloatBuffer buffer) {
        this.glPoints = glPoints;
        this.buffer = buffer;
    }

    @Override
    public GlFloatBuffer asFloatBuffer() {
        return buffer;
    }
}
