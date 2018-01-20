package com.nikialeksey.atoo.vertexbuffer;

import java.nio.ShortBuffer;
import org.cactoos.Scalar;

public class Triangulation implements GlBuffer<ShortBuffer> {

    private static final int MINIMUM = 3;

    private final GlBuffer<ShortBuffer> buffer;

    public Triangulation(final int size) {
        this(
            new Map<>(
                new Cached<>(new Short(new PointsCount(size))),
                buffer -> {
                    if (size < MINIMUM) {
                        throw new IllegalArgumentException(
                            "Points count must be more than " + MINIMUM + " for triangulation"
                        );
                    }
                    buffer.position(0);
                    for (short i = 1; i < size - 1; i++) {
                        buffer.put((short) 0);
                        buffer.put(i);
                        buffer.put((short) (i + 1));
                    }
                    buffer.position(0);
                }
            )
        );
    }

    private Triangulation(final GlBuffer<ShortBuffer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public ShortBuffer asNative() {
        return buffer.asNative();
    }

    public static class PointsCount implements Scalar<Integer> {

        private final int size;

        public PointsCount(final int size) {
            this.size = size;
        }

        @Override
        public Integer value() throws Exception {
            return (size - 2) * 3;
        }
    }
}
