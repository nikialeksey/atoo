package com.nikialeksey.atoo.screen;

import android.opengl.GLES31;
import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.exception.GlException;

public class ClearColor implements View {

    private final View origin;

    public ClearColor(final View origin) {
        this.origin = origin;
    }

    @Override
    public void draw() throws GlException {
        GLES31.glClear(GLES31.GL_COLOR_BUFFER_BIT | GLES31.GL_DEPTH_BUFFER_BIT);
        origin.draw();
    }
}
