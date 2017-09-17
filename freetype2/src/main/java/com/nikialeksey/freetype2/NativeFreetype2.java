package com.nikialeksey.freetype2;

public class NativeFreetype2 implements Freetype2 {

    private boolean isInitialized;
    private long address;

    public NativeFreetype2() {
        this.isInitialized = false;
    }

    @Override
    public native void release();

    @Override
    public long address() {
        if (!isInitialized) {
            address = init();
            isInitialized = false;
        }
        return address;
    }

    private native long init();

    static {
        System.loadLibrary("Freetype2");
    }
}
