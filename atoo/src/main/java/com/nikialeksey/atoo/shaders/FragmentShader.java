package com.nikialeksey.atoo.shaders;

import android.content.res.AssetManager;

public class FragmentShader implements GlShader {

    private final GlHandler origin;

    public FragmentShader(final AssetManager manager, final String assetName) {
        this.origin = new CachedHandler(new Shader(new FragmentType(), manager, assetName));
    }

    @Override
    public int link() {
        return origin.link();
    }
}
