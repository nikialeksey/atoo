package com.nikialeksey.freetype2;

public class NativeFace implements Face {

    private final long address;

    public NativeFace(Freetype2 freetype2, String filename) {
        address = init(freetype2.address(), filename);
    }

    @Override
    public long address() {
        return address;
    }

    @Override
    public native void release();

    private native long init(long library, String filename);

    static {
        System.loadLibrary("Freetype2Face");
    }
}
