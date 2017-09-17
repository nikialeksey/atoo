package com.nikialeksey.freetype2.glyph;

import com.nikialeksey.freetype2.face.Face;

public class NativeGlyph implements Glyph {

    private final Face face;
    private final char c;
    private final long pt;
    private final long xDpi;
    private final long yDpi;

    public NativeGlyph(final Face face, final long pt, final long xDpi, final long yDpi,
                       final char c) {
        this.face = face;
        this.pt = pt;
        this.xDpi = xDpi;
        this.yDpi = yDpi;
        this.c = c;
    }

    @Override
    public Bitmap charBitmap() {
        charSize(face.address(), 0, pt*64, xDpi, yDpi);
        return loadChar(face.address(), c);
    }

    private native void charSize(long faceAddress, long width, long height, long hResolution,
                                 long vResolution);

    private native Bitmap loadChar(long faceAddress, char character);

    static {
        System.loadLibrary("Freetype2Glyph");
    }
}
