package com.nikialeksey.atoo.sample;

import android.os.Bundle;
import com.nikialeksey.atoo.Atoo;
import com.nikialeksey.atoo.background.Solid;
import com.nikialeksey.atoo.camera.Camera;
import com.nikialeksey.atoo.color.Color;
import com.nikialeksey.atoo.geometry.GlPointShader;
import com.nikialeksey.atoo.geometry.Point;
import com.nikialeksey.atoo.geometry.PointShader;
import com.nikialeksey.atoo.geometry.Rectangle;
import com.nikialeksey.atoo.geometry.RectanglePoints;
import com.nikialeksey.atoo.matrix.MatrixFactory;
import com.nikialeksey.atoo.screen.ClearColor;
import com.nikialeksey.atoo.screen.Screen;
import com.nikialeksey.catoo.scalar.Density;
import com.nikialeksey.catoo.scalar.PixelsOf;
import java.util.Random;

public final class Sample extends Atoo {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Random random = new Random();

        final Density density = new Density(getApplicationContext());
        final GlPointShader pointShader = new PointShader(getAssets());
        setContentView(
            new Screen(
                this,
                new ClearColor(
                    new Rectangle(
                        pointShader,
                        new Solid(new Color(1f, 1f, 0f, 1f)),
                        new RectanglePoints(
                            new Point(50f, 100f),
                            new PixelsOf(density, 320),
                            new PixelsOf(density, 100)
                        )
                    )
                ),
                new Camera(new MatrixFactory(), pointShader)
            )
        );

        /**
         * StatusBar
         * Toolbar
         * Centered Text: 'Hello'
         */

        /**
         * new Screen(
         *      context,
         *      new Composite(
         *          new StatusBar(
         *              new Solid("green")
         *          ),
         *          new Toolbar(
         *              new Solid("green")
         *          ),
         *          new CenteredCircle(
         *              new Solid("green")
         *          ),
         *          new Solid("white")
         *      )
         *      camera
         * )
         *
         *
         *
         *
         *
         */
    }
}
