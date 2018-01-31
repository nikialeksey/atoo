package com.nikialeksey.atoo.color;

import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import java.nio.FloatBuffer;

public interface GlColors {
    int count();
    void updateAttribute(final int link) throws GlException;
    GlBuffer<FloatBuffer> buffer();
}
