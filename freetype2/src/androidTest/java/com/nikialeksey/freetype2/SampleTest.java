package com.nikialeksey.freetype2;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import com.nikialeksey.freetype2.face.NativeFace;
import com.nikialeksey.freetype2.glyph.NativeGlyph;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class SampleTest {

    @Test
    public void someTest() {
        final NativeGlyph glyph = new NativeGlyph(new NativeFace(new NativeFreetype2(), "font/Roboto-Regular.ttf"), 'D');
    }
}
