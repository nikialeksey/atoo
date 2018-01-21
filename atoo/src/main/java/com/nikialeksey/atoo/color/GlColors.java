package com.nikialeksey.atoo.color;

import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import java.nio.FloatBuffer;

public interface GlColors {
    int count();
    GlBuffer<FloatBuffer> buffer();
}
