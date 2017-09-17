package com.nikialeksey.freetype2;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import com.nikialeksey.freetype2.face.NativeFace;
import com.nikialeksey.freetype2.glyph.Bitmap;
import com.nikialeksey.freetype2.glyph.NativeGlyph;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class SampleTest {

    @Test
    public void someTest() throws IOException {
        final Context context = InstrumentationRegistry.getContext();
        final InputStream fontStream = context.getAssets().open("fonts/Roboto-Regular.ttf");
        final byte[] fontBytes = new byte[fontStream.available()];
        fontStream.read(fontBytes);
        fontStream.close();

        final NativeGlyph glyph = new NativeGlyph(new NativeFace(new NativeFreetype2(), fontBytes),
            16, 300, 300, 'D');
        final Bitmap bitmap = glyph.charBitmap();
        System.out.println(bitmap);
    }
}
