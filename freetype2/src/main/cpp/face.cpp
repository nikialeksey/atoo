#include "commons/freetype2errors.h"

extern "C" {

jint throwInitialize(JNIEnv *env, FT_Error error) {
    const char *className = "com/nikialeksey/freetype2/face/exceptions/Initialize";
    return throwException(env, error, className);
}

jint throwRelease(JNIEnv *env, FT_Error error) {
    const char *className = "com/nikialeksey/freetype2/face/exceptions/Release";
    return throwException(env, error, className);
}

JNIEXPORT jlong JNICALL
Java_com_nikialeksey_freetype2_face_NativeFace_init(JNIEnv *env, jclass cls, jlong library, jstring filename) {
    FT_Face  face;

    const char *nativeFilename = env->GetStringUTFChars(filename, 0);
    FT_Error error = FT_New_Face((FT_Library) library, nativeFilename, 0, &face);
    env->ReleaseStringUTFChars(filename, nativeFilename);

    if (error) {
        return throwInitialize(env, error);
    }
    return (jlong) face;
}

JNIEXPORT void JNICALL
Java_com_nikialeksey_freetype2_face_NativeFace_release(JNIEnv *env, jclass cls, jlong face) {
    FT_Error error = FT_Done_Face((FT_Face) face);
    if (error) {
        throwRelease(env, error);
    }
}

JNIEXPORT void JNICALL
Java_com_nikialeksey_freetype2_face_NativeFace_charSize(JNIEnv *env, jclass cls, jlong face,
                                                   jlong width, jlong height,
                                                   jint hResolution, jint vResolution) {
    FT_Error error = FT_Set_Char_Size((FT_Face) face, (FT_F26Dot6) width, (FT_F26Dot6) height,
                                      (FT_UInt) hResolution, (FT_UInt) vResolution);
    if (error) {
        throwInitialize(env, error);
    }
}

}