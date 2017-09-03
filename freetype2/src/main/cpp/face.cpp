#include "commons/freetype2errors.h"

extern "C" {

JNIEXPORT jlong JNICALL
Java_com_nikialeksey_freetype2_NativeFace_init(JNIEnv *env, jclass cls, jlong library, jstring filename) {
    FT_Face  face;
    FT_Error error = FT_New_Face((FT_Library) library, , 0, &face);
    if (error) {
        return throwInitialize(env, error);
    }
    return (jlong) face;
}

JNIEXPORT jlong JNICALL
Java_com_nikialeksey_freetype2_NativeFace_release(JNIEnv *env, jclass cls, jlong face) {
    FT_Error error = FT_Done_Face((FT_Face) face);
    if (error) {
        return throwRelease(env, error);
    }
    return (jlong) face;
}

}