package com.nikialeksey.atoo.vertexbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class Float implements GlBuffer<FloatBuffer> {

    private final int size;

    public Float(final int size) {
        this.size = size;
    }

    @Override
    public FloatBuffer asNative() {
        final FloatBuffer floatBuffer = ByteBuffer.allocateDirect(size * java.lang.Float.BYTES)
            .order(ByteOrder.nativeOrder())
            .asFloatBuffer();
        floatBuffer.position(0);
        return floatBuffer;
    }
}
