package com.nikialeksey.freetype2;

public class NativeFreetype2 implements Freetype2 {

    private final long address;

    public NativeFreetype2() {
        address = init();
    }

    @Override
    public native void release();

    @Override
    public long address() {
        return address;
    }

    private native long init();

    static {
        System.loadLibrary("Freetype2");
    }
}