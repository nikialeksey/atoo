#include "commons/freetype2errors.h"

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

JNIEXPORT void JNICALL
Java_com_nikialeksey_freetype2_glyph_NativeGlyph_loadChar(JNIEnv *env, jclass cls, jlong face, jchar character) {
    FT_Error error = FT_Load_Char((FT_Face) face, (FT_ULong) character, FT_LOAD_RENDER);
    if (error) {
        throwException(env, error);
    }
}

}