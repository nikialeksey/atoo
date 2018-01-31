package com.nikialeksey.atoo.vertexbuffer;

import java.nio.Buffer;

public interface GlBuffer<BT extends Buffer> {
    BT asNative() throws Exception;
}
