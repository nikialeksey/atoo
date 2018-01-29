package com.nikialeksey.atoo.screen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.camera.GlCamera;

@SuppressLint("ViewConstructor")
public final class Screen extends GLSurfaceView implements GlScreen {

    public Screen(final Context context, final View view, final GlCamera camera) {
        this(context, new com.nikialeksey.atoo.screen.Renderer(view, camera));
    }

    public Screen(final Context context, final GlRenderer renderer) {
        super(context);
        setEGLContextClientVersion(2); // OpenGl ES 2.0
        setRenderer(renderer);
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }
}
