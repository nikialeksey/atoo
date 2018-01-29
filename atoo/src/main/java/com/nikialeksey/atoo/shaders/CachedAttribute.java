package com.nikialeksey.atoo.shaders;

import java.io.IOException;

public final class CachedAttribute implements GlAttribute {

    private final CachedHandler cache;

    public CachedAttribute(final GlAttribute origin) {
        this(new CachedHandler(origin));
    }

    private CachedAttribute(final CachedHandler cache) {
        this.cache = cache;
    }

    @Override
    public int link() throws IOException {
        return cache.link();
    }
}
