package com.nikialeksey.atoo.shaders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CachedHandler implements GlHandler {

    private final GlHandler origin;
    private final List<Integer> cache;

    public CachedHandler(final GlHandler origin) {
        this.origin = origin;
        cache = new ArrayList<>();
    }

    @Override
    public int link() throws IOException {
        if (cache.isEmpty()) {
            cache.add(origin.link());
        }
        return cache.get(0);
    }
}
