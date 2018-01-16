package com.nikialeksey.atoo.sample;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.geometry.GlPointShader;
import com.nikialeksey.atoo.geometry.Point;
import com.nikialeksey.atoo.geometry.PointShader;
import com.nikialeksey.atoo.geometry.Shape;
import com.nikialeksey.atoo.geometry.SimplePoints;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Renderer implements GLSurfaceView.Renderer {

    private final AssetManager assetManager;

    public Renderer(final AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    // Our matrices
    private final float[] mtrxProjection = new float[16];
    private final float[] mtrxView = new float[16];
    private final float[] mtrxProjectionAndView = new float[16];

    // Our screenresolution
    float   mScreenWidth = 1280;
    float   mScreenHeight = 768;

    PointShader pointShader;
    View view;

    @Override
    public void onSurfaceCreated(final GL10 gl, final EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        pointShader = new GlPointShader(assetManager);
        view = new Shape(
            pointShader,
            new SimplePoints(
                new Point(10, 200, 0),
                new Point(10, 100, 0),
                new Point(100, 100, 0),
                new Point(0, 0, 0)
            )
        );
    }

    @Override
    public void onSurfaceChanged(final GL10 gl, final int width, final int height) {
        // We need to know the current width and height.
        mScreenWidth = width;
        mScreenHeight = height;

        // Redo the Viewport, making it fullscreen.
        GLES20.glViewport(0, 0, (int)mScreenWidth, (int)mScreenHeight);

        // Clear our matrices
        for(int i=0;i<16;i++)
        {
            mtrxProjection[i] = 0.0f;
            mtrxView[i] = 0.0f;
            mtrxProjectionAndView[i] = 0.0f;
        }

        // Setup our screen width and height for normal sprite translation.
        Matrix.orthoM(mtrxProjection, 0, 0f, mScreenWidth, 0.0f, mScreenHeight, 0, 50);

        // Set the camera position (View matrix)
        Matrix.setLookAtM(mtrxView, 0, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

        // Calculate the projection and view transformation
        Matrix.multiplyMM(mtrxProjectionAndView, 0, mtrxProjection, 0, mtrxView, 0);
    }

    @Override
    public void onDrawFrame(final GL10 gl) {
        Render(mtrxProjectionAndView);
    }

    private void Render(float[] m) {

        // clear Screen and Depth Buffer, we have set the clear color as black.
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        pointShader.camera(m);
        view.draw();
    }
}
