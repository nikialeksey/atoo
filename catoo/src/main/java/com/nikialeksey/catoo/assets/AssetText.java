package com.nikialeksey.catoo.assets;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStreamReader;
import org.cactoos.Text;
import org.cactoos.text.TextOf;
import org.cactoos.text.UncheckedText;

public class AssetText implements Text {

    private final AssetManager manager;
    private final String assetName;

    public AssetText(final AssetManager manager, final String assetName) {
        this.manager = manager;
        this.assetName = assetName;
    }

    @Override
    public String asString() throws IOException {
        return new TextOf(new InputStreamReader(manager.open(assetName))).asString();
    }

    @Override
    public int compareTo(final Text text) {
        return new UncheckedText(this).compareTo(text);
    }
}
