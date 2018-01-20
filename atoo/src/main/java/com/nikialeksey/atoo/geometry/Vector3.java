package com.nikialeksey.atoo.geometry;

public class Vector3 implements GlVector3 {

    private final GlPoint first;
    private final GlPoint second;
    private final GlPoint third;

    public Vector3(final GlPoint first, final GlPoint second, final GlPoint third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public GlPoint first() {
        return first;
    }

    @Override
    public GlPoint second() {
        return second;
    }

    @Override
    public GlPoint third() {
        return third;
    }
}