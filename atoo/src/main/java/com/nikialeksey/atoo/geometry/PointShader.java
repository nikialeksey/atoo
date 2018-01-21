package com.nikialeksey.atoo.geometry;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import com.nikialeksey.atoo.matrix.GlMatrix;
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
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import org.cactoos.scalar.UncheckedScalar;

public class PointShader implements GlPointShader {

    private final GlShaderProgram shaderProgram;
    private final GlUniform camera;
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
        final GlUniform camera,
        final GlAttribute position
    ) {
        this.shaderProgram = shaderProgram;
        this.camera = camera;
        this.position = position;
    }

    @Override
    public int link() {
        return shaderProgram.link();
    }

    @Override
    public void updatePosition(final GlBuffer<FloatBuffer> points, final int strip) {
        final int link = position.link();
        GLES20.glEnableVertexAttribArray(link);
        GLES20.glVertexAttribPointer(
            link,
            3,
            GLES20.GL_FLOAT,
            false,
            strip * Float.BYTES,
            points.asNative()
        );
    }

    @Override
    public void updateCamera(final GlMatrix camera) {
        GLES20.glUniformMatrix4fv(this.camera.link(), 1, false, camera.asFloatArray(), 0);
    }
}
