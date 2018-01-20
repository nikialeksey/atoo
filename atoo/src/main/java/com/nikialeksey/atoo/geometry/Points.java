package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.vertexbuffer.Cached;
import com.nikialeksey.atoo.vertexbuffer.Float;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import com.nikialeksey.atoo.vertexbuffer.Map;
import com.nikialeksey.atoo.vertexbuffer.Triangulation;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;
import org.cactoos.list.ListOf;

public class Points implements GlPoints {

    private final List<GlPoint> glPoints;
    private final GlBuffer<FloatBuffer> buffer;
    private final GlBuffer<ShortBuffer> triangulation;

    public Points(final GlPoint... glPoints) {
        this(
            new ListOf<>(glPoints),
            new Map<>(
                new Cached<>(new Float(glPoints.length * 3)),
                buffer -> {
                    buffer.position(0);
                    for (final GlPoint glPoint : glPoints) {
                        buffer.put(glPoint.x());
                        buffer.put(glPoint.y());
                        buffer.put(glPoint.z());
                    }
                    buffer.position(0);
                }
            ),
            new Triangulation(glPoints.length)
        );
    }

    public Points(
        final List<GlPoint> glPoints,
        final GlBuffer<FloatBuffer> buffer,
        final GlBuffer<ShortBuffer> triangulation
    ) {
        this.glPoints = glPoints;
        this.buffer = buffer;
        this.triangulation = triangulation;
    }

    @Override
    public int count() {
        return glPoints.size();
    }

    @Override
    public GlBuffer<FloatBuffer> points() {
        return buffer;
    }

    @Override
    public GlBuffer<ShortBuffer> triangulation() {
        return triangulation;
    }
}
