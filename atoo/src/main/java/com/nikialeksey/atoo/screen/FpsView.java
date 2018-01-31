package com.nikialeksey.atoo.screen;

import android.os.SystemClock;
import com.nikialeksey.atoo.View;
import com.nikialeksey.atoo.exception.GlException;
import java.util.concurrent.TimeUnit;

public final class FpsView implements View {

    private static final int DEFAULT_FPS = 30;

    private final View origin;
    private final int fps;

    private long last = 0;

    public FpsView(final View origin) {
        this(origin, DEFAULT_FPS);
    }

    public FpsView(final View origin, final int fps) {
        this.origin = origin;
        this.fps = fps;
    }

    @Override
    public void draw() throws GlException {
        final long between = SystemClock.uptimeMillis() - last;
        if (between * fps > TimeUnit.SECONDS.toMillis(1)) {
            origin.draw();
            last = SystemClock.uptimeMillis();
        }
    }
}
