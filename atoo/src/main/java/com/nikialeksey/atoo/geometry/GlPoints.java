package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import java.nio.ShortBuffer;

public interface GlPoints {
    int count();
    void updateAttribute(final int link) throws GlException;
    GlBuffer<ShortBuffer> triangulation();
}
