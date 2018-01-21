package com.nikialeksey.atoo.shaders;

public class CachedAttribute implements GlAttribute {

    private final CachedHandler cache;

    public CachedAttribute(final GlAttribute origin) {
        this(new CachedHandler(origin));
    }

    private CachedAttribute(final CachedHandler cache) {
        this.cache = cache;
    }

    @Override
    public int link() {
        return cache.link();
    }
}
