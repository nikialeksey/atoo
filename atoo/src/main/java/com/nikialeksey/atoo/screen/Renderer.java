package com.nikialeksey.atoo.screen;

import android.opengl.GLES20;
import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.camera.GlCamera;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Renderer implements GlRenderer {

    private final View view;
    private final GlCamera camera;

    public Renderer(final View view, final GlCamera camera) {
        this.view = view;
        this.camera = camera;
    }

    @Override
    public void onSurfaceCreated(final GL10 gl, final EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void onSurfaceChanged(final GL10 gl, final int width, final int height) {
        GLES20.glViewport(0, 0, width, height);
        camera.update(width, height);
    }

    @Override
    public void onDrawFrame(final GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        view.draw();
    }
}
