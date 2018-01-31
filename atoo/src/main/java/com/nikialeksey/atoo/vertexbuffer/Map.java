package com.nikialeksey.atoo.vertexbuffer;

import java.nio.Buffer;
import org.cactoos.Proc;

public final class Map<BT extends Buffer> implements GlBuffer<BT> {

    private final GlBuffer<BT> origin;
    private final Proc<BT> mapProc;

    public Map(
        final GlBuffer<BT> origin,
        final Proc<BT> mapProc
    ) {
        this.origin = origin;
        this.mapProc = mapProc;
    }

    @Override
    public BT asNative() throws Exception {
        final BT buffer = origin.asNative();
        mapProc.exec(buffer);
        return buffer;
    }
}
