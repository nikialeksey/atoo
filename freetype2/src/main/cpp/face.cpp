#include "commons/freetype2errors.h"

extern "C" {

JNIEXPORT jlong JNICALL
Java_com_nikialeksey_freetype2_face_NativeFace_init(JNIEnv *env, jclass cls, jlong library, jstring filename) {
    FT_Face  face;

    const char *nativeFilename = env->GetStringUTFChars(filename, 0);
    FT_Error error = FT_New_Face((FT_Library) library, nativeFilename, 0, &face);
    env->ReleaseStringUTFChars(filename, nativeFilename);

    if (error) {
        return throwException(env, error);
    }
    return (jlong) face;
}

JNIEXPORT void JNICALL
Java_com_nikialeksey_freetype2_face_NativeFace_release(JNIEnv *env, jclass cls, jlong face) {
    FT_Error error = FT_Done_Face((FT_Face) face);
    if (error) {
        throwException(env, error);
    }
}

}