package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.View;

public class Shape implements View {

    private final GlPointShader pointShader;
    private final GlPoints points;

    public Shape(final GlPointShader pointShader, final GlPoints points) {
        this.pointShader = pointShader;
        this.points = points;
    }

    @Override
    public void draw() {
        pointShader.draw(points);
    }
}
