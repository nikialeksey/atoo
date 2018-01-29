package com.nikialeksey.atoo.sample;

import android.os.Bundle;
import com.nikialeksey.atoo.Atoo;
import com.nikialeksey.atoo.background.Solid;
import com.nikialeksey.atoo.camera.Camera;
import com.nikialeksey.atoo.color.Color;
import com.nikialeksey.atoo.geometry.GlPointShader;
import com.nikialeksey.atoo.geometry.Point;
import com.nikialeksey.atoo.geometry.PointShader;
import com.nikialeksey.atoo.geometry.Points;
import com.nikialeksey.atoo.geometry.Shape;
import com.nikialeksey.atoo.matrix.MatrixFactory;
import com.nikialeksey.atoo.screen.Screen;

public final class Sample extends Atoo {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final GlPointShader pointShader = new PointShader(getAssets());
        setContentView(
            new Screen(
                this,
                new Shape(
                    pointShader,
                    new Points(
                        new Point(100, 300),
                        new Point(100, 100),
                        new Point(300, 100),
                        new Point(400, 150),
                        new Point(300, 300)
                    ),
                    new Solid(new Color(1f, 1f, 0f, 1f))
                ),
                new Camera(new MatrixFactory(), pointShader)
            )
        );
    }
}
