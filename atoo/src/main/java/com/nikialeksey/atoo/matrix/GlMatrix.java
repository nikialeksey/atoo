package com.nikialeksey.atoo.matrix;

import com.nikialeksey.atoo.exception.GlException;

public interface GlMatrix {
    float[] asFloatArray() throws GlException;
    void update(float[] inside);
}
