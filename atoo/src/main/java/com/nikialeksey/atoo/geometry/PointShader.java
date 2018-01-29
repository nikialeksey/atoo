package com.nikialeksey.atoo.geometry;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.matrix.GlMatrix;
import com.nikialeksey.atoo.shaders.CachedAttribute;
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
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import org.cactoos.scalar.UncheckedScalar;

public final class PointShader implements GlPointShader {

    private final GlShaderProgram shaderProgram;
    private final GlUniform camera;
    private final GlAttribute position;
    private final GlAttribute color;

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
            new CachedAttribute(new Attribute(shaderProgram, "position")),
            new CachedAttribute(new Attribute(shaderProgram, "color"))
        );
    }

    private PointShader(
        final GlShaderProgram shaderProgram,
        final GlUniform camera,
        final GlAttribute position,
        final GlAttribute color
    ) {
        this.shaderProgram = shaderProgram;
        this.camera = camera;
        this.position = position;
        this.color = color;
    }

    @Override
    public int link() throws IOException {
        return shaderProgram.link();
    }

    @Override
    public void updatePosition(
        final GlBuffer<FloatBuffer> points,
        final int strip
    ) throws GlException {
        try {
            GLES20.glEnableVertexAttribArray(position.link());
            GLES20.glVertexAttribPointer(
                position.link(),
                3,
                GLES20.GL_FLOAT,
                false,
                strip * Float.BYTES,
                points.asNative()
            );
        } catch (IOException e) {
            throw new GlException("Can't update position in vertex attribute array", e);
        }
    }

    @Override
    public void updateColor(
        final GlBuffer<FloatBuffer> colors,
        final int strip
    ) throws GlException {
        try {
            GLES20.glEnableVertexAttribArray(color.link());
            GLES20.glVertexAttribPointer(
                color.link(),
                4,
                GLES20.GL_FLOAT,
                false,
                strip * Float.BYTES,
                colors.asNative()
            );
        } catch (IOException e) {
            throw new GlException("Can't update color in vertex attribute array", e);
        }
    }

    @Override
    public void updateCamera(final GlMatrix camera) throws GlException {
        try {
            GLES20.glUniformMatrix4fv(this.camera.link(), 1, false, camera.asFloatArray(), 0);
        } catch (IOException e) {
            throw new GlException("Can't update camera in uniform", e);
        }
    }
}
