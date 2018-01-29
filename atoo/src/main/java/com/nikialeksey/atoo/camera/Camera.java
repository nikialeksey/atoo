package com.nikialeksey.atoo.camera;

import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.geometry.GlPointShader;
import com.nikialeksey.atoo.geometry.Point;
import com.nikialeksey.atoo.matrix.GlMatrix;
import com.nikialeksey.atoo.matrix.GlMatrixFactory;
import com.nikialeksey.atoo.matrix.LookAt;
import com.nikialeksey.atoo.matrix.Multiply;
import com.nikialeksey.atoo.matrix.OperationMatrix;
import com.nikialeksey.atoo.matrix.Ortho;
import org.cactoos.BiFunc;
import org.cactoos.func.UncheckedBiFunc;

public final class Camera implements GlCamera {

    private final GlPointShader pointShader;
    private final UncheckedBiFunc<Integer, Integer, GlMatrix> projectionView;

    public Camera(final GlMatrixFactory matrixFactory, final GlPointShader pointShader) {
        this(
            pointShader,
            (width, height) -> new OperationMatrix(
                new Multiply(
                    matrixFactory,
                    new Ortho(
                        matrixFactory,
                        width,
                        height
                    ),
                    new LookAt(
                        matrixFactory,
                        new Point(0, 0, 1), // eye
                        new Point(0, 0, 0), // center
                        new Point(0, 1, 0)  // up
                    )
                )
            )
        );
    }

    public Camera(
        final GlPointShader pointShader,
        final BiFunc<Integer, Integer, GlMatrix> projectionView
    ) {
        this(pointShader, new UncheckedBiFunc<>(projectionView));
    }

    public Camera(
        final GlPointShader pointShader,
        final UncheckedBiFunc<Integer, Integer, GlMatrix> projectionView
    ) {
        this.pointShader = pointShader;
        this.projectionView = projectionView;
    }

    @Override
    public void update(final int screenWidth, final int screenHeight) throws GlException {
        pointShader.updateCamera(projectionView.apply(screenWidth, screenHeight));
    }
}
