package com.nikialeksey.atoo.vertexbuffer;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public final class Cached<BT extends Buffer> implements GlBuffer<BT> {

    private final List<BT> cache = new ArrayList<>();
    private final GlBuffer<BT> origin;

    public Cached(final GlBuffer<BT> origin) {
        this.origin = origin;
    }

    @Override
    public BT asNative() {
        if (cache.isEmpty()) {
            cache.add(origin.asNative());
        }
        return cache.get(0);
    }
}
