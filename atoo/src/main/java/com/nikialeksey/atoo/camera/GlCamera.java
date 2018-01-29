package com.nikialeksey.atoo.camera;

import com.nikialeksey.atoo.exception.GlException;

public interface GlCamera {
    void update(int screenWidth, int screenHeight) throws GlException;
}
