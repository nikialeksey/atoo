package com.nikialeksey.atoo.geometry;

import android.opengl.GLES20;
import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.background.GlBackground;
import com.nikialeksey.atoo.vertexbuffer.Triangulation;
import org.cactoos.scalar.UncheckedScalar;

public class Shape implements View {

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
    public void draw() {
        pointShader.updatePosition(points.buffer(), 3);
        pointShader.updateColor(background.colors(points).buffer(), 4);
        GLES20.glDrawElements(
            GLES20.GL_TRIANGLES,
            new UncheckedScalar<>(new Triangulation.PointsCount(points.count())).value(),
            GLES20.GL_UNSIGNED_SHORT,
            points.triangulation().asNative()
        );
    }
}
