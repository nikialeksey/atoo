package com.nikialeksey.atoo.shaders;

import android.content.res.AssetManager;
import android.opengl.GLES20;
import com.nikialeksey.catoo.assets.AssetText;
import org.cactoos.Text;
import org.cactoos.text.UncheckedText;

public class Shader implements GlShader {

    private final UncheckedText source;
    private final GlShaderType type;

    public Shader(final GlShaderType type, final AssetManager manager, final String assetName) {
        this(
            type,
            new AssetText(manager, assetName)
        );
    }

    public Shader(final GlShaderType type, final Text source) {
        this.type = type;
        this.source = new UncheckedText(source);
    }

    @Override
    public int link() {
        final int link = GLES20.glCreateShader(type.value());
        GLES20.glShaderSource(link, source.asString());
        GLES20.glCompileShader(link);
        return link;
    }
}
