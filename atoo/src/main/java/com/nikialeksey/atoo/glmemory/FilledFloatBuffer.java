package com.nikialeksey.atoo.glmemory;

import java.nio.FloatBuffer;
import org.cactoos.Proc;
import org.cactoos.func.UncheckedProc;

public class FilledFloatBuffer implements GlFloatBuffer {

    private final GlFloatBuffer origin;
    private final UncheckedProc<FloatBuffer> fillProc;

    public FilledFloatBuffer(final GlFloatBuffer origin, final Proc<FloatBuffer> fillProc) {
        this(origin, new UncheckedProc<>(fillProc));
    }

    public FilledFloatBuffer(
        final GlFloatBuffer origin,
        final UncheckedProc<FloatBuffer> fillProc
    ) {
        this.origin = origin;
        this.fillProc = fillProc;
    }

    @Override
    public FloatBuffer asFloatBuffer() {
        final FloatBuffer floatBuffer = origin.asFloatBuffer();
        fillProc.exec(floatBuffer);
        return floatBuffer;
    }
}
