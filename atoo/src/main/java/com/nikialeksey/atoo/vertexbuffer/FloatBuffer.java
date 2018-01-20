package com.nikialeksey.atoo.vertexbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FloatBuffer implements GlFloatBuffer {

    private final int size;

    public FloatBuffer(final int size) {
        this.size = size;
    }

    @Override
    public java.nio.FloatBuffer asFloatBuffer() {
        final java.nio.FloatBuffer floatBuffer = ByteBuffer.allocateDirect(size * Float.BYTES)
            .order(ByteOrder.nativeOrder())
            .asFloatBuffer();
        floatBuffer.position(0);
        return floatBuffer;
    }
}
