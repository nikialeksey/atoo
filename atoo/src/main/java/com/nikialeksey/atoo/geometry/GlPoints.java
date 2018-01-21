package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public interface GlPoints {
    int count();
    GlBuffer<FloatBuffer> buffer();
    GlBuffer<ShortBuffer> triangulation();
}
