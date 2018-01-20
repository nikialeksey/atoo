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
import com.nikialeksey.atoo.matrix.GlMatrixFactory;
import com.nikialeksey.atoo.matrix.LookAtOperation;
import com.nikialeksey.atoo.matrix.MatrixFactory;
import com.nikialeksey.atoo.matrix.MultiplyOperation;
import com.nikialeksey.atoo.matrix.OrthoOperation;
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
        GLES20.glViewport(0, 0, width, height);

        final GlMatrixFactory matrixFactory = new MatrixFactory();
        mtrxProjectionAndView = new MultiplyOperation(
            matrixFactory,
            new OrthoOperation(
                matrixFactory,
                new Screen(width, height),
                50
            ),
            new LookAtOperation(
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
