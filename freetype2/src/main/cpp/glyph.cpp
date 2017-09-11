#include "commons/freetype2errors.h"
#include "commons/errors.h"

extern "C" {

JNIEXPORT void JNICALL
Java_com_nikialeksey_freetype2_glyph_NativeGlyph_charSize(JNIEnv *env, jclass cls, jlong face,
                                                          jlong width, jlong height,
                                                          jint hResolution, jint vResolution) {
    FT_Error error = FT_Set_Char_Size((FT_Face) face, (FT_F26Dot6) width, (FT_F26Dot6) height,
                                      (FT_UInt) hResolution, (FT_UInt) vResolution);
    if (error) {
        throwException(env, error);
    }
}

JNIEXPORT jobject JNICALL
Java_com_nikialeksey_freetype2_glyph_NativeGlyph_loadChar(JNIEnv *env, jclass cls, jlong face, jchar character) {
    FT_Error error = FT_Load_Char((FT_Face) face, (FT_ULong) character, FT_LOAD_RENDER);
    if (error) {
        throwException(env, error);
    }
    FT_GlyphSlot glyphSlot = ((FT_Face) face)->glyph;
    jint bitmapHeight = glyphSlot->bitmap.rows;
    jint bitmapWidth = glyphSlot->bitmap.width;
    jint bitmapBufferSize = bitmapHeight * bitmapWidth;
    jbyteArray bitmapBuffer = env->NewByteArray(bitmapBufferSize);
    env->SetByteArrayRegion(bitmapBuffer, 0, bitmapBufferSize, (jbyte *) glyphSlot->bitmap.buffer);

    const char *bitmapClassName = "com/nikialeksey/freetype2/glyph/Bitmap";
    jclass bitmapClass = env->FindClass(bitmapClassName);
    if (bitmapClass == NULL) {
        throwNoClassDefError(env, bitmapClassName);
        return NULL;
    }
    jmethodID bitmapConstructor = env->GetMethodID(bitmapClass, "<init>", "([BII)V");
    return env->NewObject(bitmapClass, bitmapConstructor, bitmapBuffer, bitmapWidth, bitmapHeight);
}

}