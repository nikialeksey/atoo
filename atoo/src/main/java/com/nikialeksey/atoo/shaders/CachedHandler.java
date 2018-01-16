package com.nikialeksey.atoo.shaders;

import java.util.ArrayList;
import java.util.List;

public class CachedHandler implements Handler {

    private final Handler origin;
    private final List<Integer> cache;

    public CachedHandler(final Handler origin) {
        this.origin = origin;
        cache = new ArrayList<>();
    }

    @Override
    public int link() {
        if (cache.isEmpty()) {
            cache.add(origin.link());
        }
        return cache.get(0);
    }
}
