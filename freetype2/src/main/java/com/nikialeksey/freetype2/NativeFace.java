package com.nikialeksey.freetype2;

public class NativeFace implements Face {

    private final long address;

    public NativeFace() {
        address = init();
    }

    @Override
    public long address() {
        return address;
    }

    @Override
    public native void release();

    private native long init();

    static {
        System.loadLibrary("Freetype2Face");
    }
}
