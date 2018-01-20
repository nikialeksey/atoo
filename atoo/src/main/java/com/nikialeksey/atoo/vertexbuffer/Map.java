package com.nikialeksey.atoo.vertexbuffer;

import java.nio.Buffer;
import org.cactoos.Proc;
import org.cactoos.func.UncheckedProc;

public class Map<BT extends Buffer> implements GlBuffer<BT> {

    private final GlBuffer<BT> origin;
    private final UncheckedProc<BT> mapProc;

    public Map(final GlBuffer<BT> origin, final Proc<BT> mapProc) {
        this(origin, new UncheckedProc<>(mapProc));
    }

    public Map(
        final GlBuffer<BT> origin,
        final UncheckedProc<BT> mapProc
    ) {
        this.origin = origin;
        this.mapProc = mapProc;
    }

    @Override
    public BT asNative() {
        final BT buffer = origin.asNative();
        mapProc.exec(buffer);
        return buffer;
    }
}
