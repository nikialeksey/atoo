package com.nikialeksey.atoo.geometry;

import com.nikialeksey.atoo.View;

public class Shape implements View {

    private final PointShader pointShader;
    private final Points points;

    public Shape(final PointShader pointShader, final Points points) {
        this.pointShader = pointShader;
        this.points = points;
    }

    @Override
    public void draw() {
        pointShader.draw(points);
    }
}
