package com.nikialeksey.atoo.geometry;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import com.nikialeksey.atoo.glmemory.GlFloatBuffer;
import com.nikialeksey.atoo.shaders.Attribute;
import com.nikialeksey.atoo.shaders.CachedShaderProgram;
import com.nikialeksey.atoo.shaders.FragmentShader;
import com.nikialeksey.atoo.shaders.GlAttribute;
import com.nikialeksey.atoo.shaders.GlShaderProgram;
import com.nikialeksey.atoo.shaders.GlUniform;
import com.nikialeksey.atoo.shaders.ShaderProgram;
import com.nikialeksey.atoo.shaders.Uniform;
import com.nikialeksey.atoo.shaders.VertexShader;

public class GlPointShader implements PointShader {

    private final ShaderProgram shaderProgram;
    private final Uniform matrix;
    private final Attribute position;

    public GlPointShader(final AssetManager assetManager) {
        this(
            new CachedShaderProgram(
                new GlShaderProgram(
                    new VertexShader(assetManager, "Point.vert"),
                    new FragmentShader(assetManager, "Point.frag")
                )
            )
        );
    }

    private GlPointShader(final ShaderProgram shaderProgram) {
        this(
            shaderProgram,
            new GlUniform(shaderProgram, "matrix"),
            new GlAttribute(shaderProgram, "position")
        );
    }

    private GlPointShader(
        final ShaderProgram shaderProgram,
        final Uniform matrix,
        final Attribute position
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
    public void draw(final Points points) {
        final GlFloatBuffer glFloatBuffer = points.asFloatBuffer();

        final int link = position.link();
        GLES20.glEnableVertexAttribArray(link);
        GLES20.glVertexAttribPointer(
            link,
            3,
            GLES20.GL_FLOAT,
            false,
            3 * Float.BYTES,
            glFloatBuffer.asFloatBuffer()
        );
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 3);
        GLES20.glDisableVertexAttribArray(link);
    }

    @Override
    public void camera(final float[] m) {
        GLES20.glUniformMatrix4fv(matrix.link(), 1, false, m, 0);
    }
}
