package com.nikialeksey.atoo.shaders;

import android.content.res.AssetManager;
import java.io.IOException;

public final class VertexShader implements GlShader {

    private final GlHandler origin;

    public VertexShader(final AssetManager manager, final String assetName) {
        this.origin = new CachedHandler(new Shader(new VertexType(), manager, assetName));
    }

    @Override
    public int link() throws IOException {
        return origin.link();
    }
}
