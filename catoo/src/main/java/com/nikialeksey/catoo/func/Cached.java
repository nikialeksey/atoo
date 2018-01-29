package com.nikialeksey.catoo.func;

import android.util.SparseArray;
import org.cactoos.Func;

public final class Cached<T> implements Func<Integer, T> {

    private final SparseArray<T> cache;
    private final Func<Integer, T> origin;

    public Cached(final Func<Integer, T> origin) {
        this(new SparseArray<>(), origin);
    }

    private Cached(final SparseArray<T> cache, final Func<Integer, T> origin) {
        this.cache = cache;
        this.origin = origin;
    }

    @Override
    public T apply(final Integer input) throws Exception {
        if (cache.size() == 1) {
            final T data = cache.get(input);
            if (data == null) {
                cache.clear();
                cache.put(input, origin.apply(input));
            }
        } else {
            cache.put(input, origin.apply(input));
        }
        return cache.get(input);
    }
}
