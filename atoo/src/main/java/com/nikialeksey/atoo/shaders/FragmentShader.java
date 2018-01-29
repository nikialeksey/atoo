package com.nikialeksey.atoo.shaders;

import android.content.res.AssetManager;
import java.io.IOException;

public final class FragmentShader implements GlShader {

    private final GlHandler origin;

    public FragmentShader(final AssetManager manager, final String assetName) {
        this.origin = new CachedHandler(new Shader(new FragmentType(), manager, assetName));
    }

    @Override
    public int link() throws IOException {
        return origin.link();
    }
}
