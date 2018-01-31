package com.nikialeksey.atoo.vertexbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

public final class Short implements GlBuffer<ShortBuffer> {

    private final UncheckedScalar<Integer> size;

    public Short(final int size) {
        this(() -> size);
    }

    public Short(final Scalar<Integer> size) {
        this(new UncheckedScalar<>(size));
    }

    public Short(final UncheckedScalar<Integer> size) {
        this.size = size;
    }

    @Override
    public ShortBuffer asNative() {
        final ShortBuffer floatBuffer = ByteBuffer
            .allocateDirect(
                size.value() * java.lang.Short.BYTES
            )
            .order(ByteOrder.nativeOrder())
            .asShortBuffer();
        floatBuffer.position(0);
        return floatBuffer;
    }
}
