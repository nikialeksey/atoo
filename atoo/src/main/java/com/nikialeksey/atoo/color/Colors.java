package com.nikialeksey.atoo.color;

import android.opengl.GLES31;
import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.vertexbuffer.Cached;
import com.nikialeksey.atoo.vertexbuffer.Float;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import com.nikialeksey.atoo.vertexbuffer.Map;
import java.nio.FloatBuffer;
import java.util.List;
import org.cactoos.iterable.Repeated;
import org.cactoos.list.ListOf;

public final class Colors implements GlColors {

    private static final int FLOAT_PER_COLOR = 4;
    private static final int COLOR_STRIP = 4 * java.lang.Float.BYTES;

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
                new Cached<>(new Float(colors.size() * FLOAT_PER_COLOR)),
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
    public void updateAttribute(final int link) throws GlException {
        try {
            GLES31.glVertexAttribPointer(
                link,
                FLOAT_PER_COLOR,
                GLES31.GL_FLOAT,
                false,
                COLOR_STRIP,
                buffer.asNative()
            );
        } catch (Exception e) {
            throw new GlException("Can't update color attribute data", e);
        }
    }

    @Override
    public GlBuffer<FloatBuffer> buffer() {
        return buffer;
    }
}
