#include "freetype2errors.h"

extern "C" {

JNIEXPORT jlong JNICALL
Java_com_nikialeksey_freetype2_NativeFreetype2_init(JNIEnv *env, jclass cls) {
    FT_Library library;
    FT_Error error = FT_Init_FreeType(&library);
    if (error) {
        return throwInitialize(env, error);
    }
    return (jlong) library;
}

JNIEXPORT void JNICALL
Java_com_nikialeksey_freetype2_NativeFreetype2_release(JNIEnv *env, jclass cls, jlong library) {
    FT_Error error = FT_Done_FreeType((FT_Library) library);
    if (error) {
        throwRelease(env, error);
    }
}

}