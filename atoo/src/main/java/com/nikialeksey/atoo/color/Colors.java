package com.nikialeksey.atoo.color;

import com.nikialeksey.atoo.vertexbuffer.Cached;
import com.nikialeksey.atoo.vertexbuffer.Float;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import com.nikialeksey.atoo.vertexbuffer.Map;
import java.nio.FloatBuffer;
import java.util.List;
import org.cactoos.iterable.Repeated;
import org.cactoos.list.ListOf;

public class Colors implements GlColors {

    private final List<GlColor> colors;
    private final GlBuffer<FloatBuffer> buffer;

    public Colors(final GlColor color, final int size) {
        this(new ListOf<>(new Repeated<GlColor>(size, color)));
    }

    public Colors(final GlColor... colors) {
        this(new ListOf<>(colors));
    }

    public Colors(final List<GlColor> colors) {
        this(
            colors,
            new Map<>(
                new Cached<>(new Float(colors.size() * 4)),
                (buffer) -> {
                    buffer.position(0);
                    for (final GlColor color : colors) {
                        buffer.put(color.r());
                        buffer.put(color.g());
                        buffer.put(color.b());
                        buffer.put(color.a());

                    }
                    buffer.position(0);
                }
            )
        );
    }

    public Colors(final List<GlColor> colors, final GlBuffer<FloatBuffer> buffer) {
        this.colors = colors;
        this.buffer = buffer;
    }

    @Override
    public int count() {
        return colors.size();
    }

    @Override
    public GlBuffer<FloatBuffer> buffer() {
        return buffer;
    }
}
