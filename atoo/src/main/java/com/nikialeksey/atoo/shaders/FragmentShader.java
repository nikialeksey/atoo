package com.nikialeksey.atoo.shaders;

import android.content.res.AssetManager;

public class FragmentShader implements Shader {

    private final Handler origin;

    public FragmentShader(final AssetManager manager, final String assetName) {
        this.origin = new CachedHandler(new GlShader(new FragmentType(), manager, assetName));
    }

    @Override
    public int link() {
        return origin.link();
    }
}
