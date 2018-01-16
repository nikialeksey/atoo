package com.nikialeksey.atoo.shaders;

import android.content.res.AssetManager;

public class VertexShader implements Shader {

    private final Handler origin;

    public VertexShader(final AssetManager manager, final String assetName) {
        this.origin = new CachedHandler(new GlShader(new VertexType(), manager, assetName));
    }

    @Override
    public int link() {
        return origin.link();
    }
}
