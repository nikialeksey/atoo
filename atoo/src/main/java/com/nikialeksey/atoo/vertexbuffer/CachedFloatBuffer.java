package com.nikialeksey.atoo.vertexbuffer;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class CachedFloatBuffer implements GlFloatBuffer {

    private final List<FloatBuffer> cache = new ArrayList<>();
    private final GlFloatBuffer origin;

    public CachedFloatBuffer(final GlFloatBuffer origin) {
        this.origin = origin;
    }

    @Override
    public FloatBuffer asFloatBuffer() {
        if (cache.isEmpty()) {
            cache.add(origin.asFloatBuffer());
        }
        return cache.get(0);
    }
}
