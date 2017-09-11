package com.nikialeksey.freetype2.glyph;

import com.nikialeksey.freetype2.face.Face;

public class NativeGlyph implements Glyph {
    private final long faceAddress;

    public NativeGlyph(Face face, char c) {
        faceAddress = face.address();
        // @todo #3:30m set charSize and loadChar
        // @todo #4:30m get char bitmap
        final Bitmap dBitmap = loadChar(faceAddress, 'D');
        System.out.println(dBitmap);
    }

    private native void charSize(long faceAddress, long width, long height, long hResolution,
                                 long vResolution);

    private native Bitmap loadChar(long faceAddress, char character);

    static {
        System.loadLibrary("Freetype2Glyph");
    }
}
