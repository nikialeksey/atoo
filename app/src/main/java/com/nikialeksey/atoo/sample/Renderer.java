package com.nikialeksey.atoo.sample;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.geometry.PointShader;
import com.nikialeksey.atoo.geometry.Point;
import com.nikialeksey.atoo.geometry.GlPointShader;
import com.nikialeksey.atoo.geometry.Shape;
import com.nikialeksey.atoo.geometry.Points;
import com.nikialeksey.atoo.matrix.GlMatrixFactory;
import com.nikialeksey.atoo.matrix.LookAt;
import com.nikialeksey.atoo.matrix.MatrixFactory;
import com.nikialeksey.atoo.matrix.Multiply;
import com.nikialeksey.atoo.matrix.Ortho;
import com.nikialeksey.atoo.screen.Screen;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class Renderer implements GLSurfaceView.Renderer {

    private final AssetManager assetManager;

    public Renderer(final AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    // Our matrices
    private float[] mtrxProjectionAndView = new float[16];

    GlPointShader pointShader;
    View view;

    @Override
    public void onSurfaceCreated(final GL10 gl, final EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        pointShader = new PointShader(assetManager);
        view = new Shape(
            pointShader,
            new Points(
                new Point(100, 300, 0),
                new Point(100, 100, 0),
                new Point(300, 100, 0),
                new Point(400, 150, 0),
                new Point(300, 300, 0)
            )
        );
    }

    @Override
    public void onSurfaceChanged(final GL10 gl, final int width, final int height) {
        GLES20.glViewport(0, 0, width, height);

        final GlMatrixFactory matrixFactory = new MatrixFactory();
        mtrxProjectionAndView = new Multiply(
            matrixFactory,
            new Ortho(
                matrixFactory,
                new Screen(width, height),
                1
            ),
            new LookAt(
                matrixFactory,
                new Point(0, 0, 1),
                new Point(0, 0, 0),
                new Point(0, 1, 0)
            )
        )
            .result()
            .asFloatArray();
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
