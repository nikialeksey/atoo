package com.nikialeksey.atoo.matrix;

import org.cactoos.Scalar;
import org.cactoos.scalar.UncheckedScalar;

public class Multiply implements GlMatrixOperation {

    private final GlMatrixFactory factory;
    private final UncheckedScalar<? extends GlMatrix> left;
    private final UncheckedScalar<? extends GlMatrix> right;

    public Multiply(
        final GlMatrixFactory factory,
        final GlMatrixOperation left,
        final GlMatrixOperation right
    ) {
        this(factory, new OperationMatrix(left), new OperationMatrix(right));
    }

    public Multiply(
        final GlMatrixFactory factory,
        final GlMatrix left,
        final GlMatrix right
    ) {
        this(factory, () -> left, (Scalar<GlMatrix>) () -> right);
    }

    public Multiply(
        final GlMatrixFactory factory,
        final Scalar<? extends GlMatrix> left,
        final Scalar<? extends GlMatrix> right
    ) {
        this(factory, new UncheckedScalar<>(left), new UncheckedScalar<>(right));
    }


    private Multiply(
        final GlMatrixFactory factory,
        final UncheckedScalar<? extends GlMatrix> left,
        final UncheckedScalar<? extends GlMatrix> right
    ) {
        this.factory = factory;
        this.left = left;
        this.right = right;
    }

    @Override
    public GlMatrix result() {
        final GlMatrix result = factory.matrix();
        final float[] resultData = result.asFloatArray();
        final float[] lhs = left.value().asFloatArray();
        final float[] rhs = right.value().asFloatArray();
        android.opengl.Matrix.multiplyMM(resultData, 0, lhs, 0, rhs, 0);
        result.update(resultData);
        return result;
    }
}
