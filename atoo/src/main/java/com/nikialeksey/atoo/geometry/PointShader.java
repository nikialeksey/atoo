package com.nikialeksey.atoo.geometry;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import com.nikialeksey.atoo.vertexbuffer.GlBuffer;
import com.nikialeksey.atoo.shaders.GlAttribute;
import com.nikialeksey.atoo.shaders.CachedShaderProgram;
import com.nikialeksey.atoo.shaders.FragmentShader;
import com.nikialeksey.atoo.shaders.Attribute;
import com.nikialeksey.atoo.shaders.ShaderProgram;
import com.nikialeksey.atoo.shaders.Uniform;
import com.nikialeksey.atoo.shaders.GlShaderProgram;
import com.nikialeksey.atoo.shaders.GlUniform;
import com.nikialeksey.atoo.shaders.VertexShader;
import com.nikialeksey.atoo.vertexbuffer.Triangulation;
import org.cactoos.scalar.UncheckedScalar;

public class PointShader implements GlPointShader {

    private final GlShaderProgram shaderProgram;
    private final GlUniform matrix;
    private final GlAttribute position;

    public PointShader(final AssetManager assetManager) {
        this(
            new CachedShaderProgram(
                new ShaderProgram(
                    new VertexShader(assetManager, "Point.vert"),
                    new FragmentShader(assetManager, "Point.frag")
                )
            )
        );
    }

    private PointShader(final GlShaderProgram shaderProgram) {
        this(
            shaderProgram,
            new Uniform(shaderProgram, "camera"),
            new Attribute(shaderProgram, "position")
        );
    }

    private PointShader(
        final GlShaderProgram shaderProgram,
        final GlUniform matrix,
        final GlAttribute position
    ) {
        this.shaderProgram = shaderProgram;
        this.matrix = matrix;
        this.position = position;
    }

    @Override
    public int link() {
        return shaderProgram.link();
    }

    @Override
    public void draw(final GlPoints points) {
        final GlBuffer glFloatBuffer = points.points();

        final int link = position.link();
        GLES20.glEnableVertexAttribArray(link);
        GLES20.glVertexAttribPointer(
            link,
            3,
            GLES20.GL_FLOAT,
            false,
            3 * Float.BYTES,
            glFloatBuffer.asNative()
        );
        GLES20.glDrawElements(
            GLES20.GL_TRIANGLES,
            new UncheckedScalar<>(new Triangulation.PointsCount(points.count())).value(),
            GLES20.GL_UNSIGNED_SHORT,
            points.triangulation().asNative()
        );
        GLES20.glDisableVertexAttribArray(link);
    }

    @Override
    public void camera(final float[] m) {
        GLES20.glUniformMatrix4fv(matrix.link(), 1, false, m, 0);
    }
}