package com.nikialeksey.atoo.geometry;

import android.opengl.GLES20;
import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.background.GlBackground;
import com.nikialeksey.atoo.exception.GlException;
import com.nikialeksey.atoo.vertexbuffer.Triangulation;

public final class Shape implements View {

    private final GlPointShader pointShader;
    private final GlPoints points;
    private final GlBackground background;

    public Shape(
        final GlPointShader pointShader,
        final GlPoints points,
        final GlBackground background
    ) {
        this.pointShader = pointShader;
        this.points = points;
        this.background = background;
    }

    @Override
    public void draw() throws GlException {
        pointShader.updatePosition(points);
        pointShader.updateColor(background.colors(points));
        try {
            GLES20.glDrawElements(
                GLES20.GL_TRIANGLES,
                new Triangulation.PointsCount(points.count()).value(),
                GLES20.GL_UNSIGNED_SHORT,
                points.triangulation().asNative()
            );
        } catch (Exception e) {
            throw new GlException("Can't draw shape", e);
        }
    }
}
