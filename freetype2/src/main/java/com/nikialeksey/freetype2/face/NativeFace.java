package com.nikialeksey.freetype2.face;

import com.nikialeksey.freetype2.Freetype2;
import java.io.IOException;

public class NativeFace implements Face {

    private boolean isInitialized;
    private long address;

    private final Freetype2 freetype2;
    private final byte[] faceBytes;

    public NativeFace(final Freetype2 freetype2, final byte[] faceBytes) throws IOException {
        this.isInitialized = false;
        this.freetype2 = freetype2;
        this.faceBytes = faceBytes;
    }

    @Override
    public long address() {
        if (!isInitialized) {
            address = init(freetype2.address(), faceBytes);
            isInitialized = true;
        }
        return address;
    }

    @Override
    public native void release();

    private native long init(long library, byte[] faceBytes);

    static {
        System.loadLibrary("Freetype2Face");
    }
}
