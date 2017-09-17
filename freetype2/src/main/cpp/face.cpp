#include "commons/freetype2errors.h"

extern "C" {

// @todo #5:30m Create jni helpers module with same methods
unsigned char* as_unsigned_char_array(JNIEnv* &env,jbyteArray array) {
    int len = env->GetArrayLength (array);
    unsigned char* buf = new unsigned char[len];
    env->GetByteArrayRegion (array, 0, len, reinterpret_cast<jbyte*>(buf));
    return buf;
}

JNIEXPORT jlong JNICALL
Java_com_nikialeksey_freetype2_face_NativeFace_init(JNIEnv *env, jclass cls, jlong library, jbyteArray faceBytes) {
    FT_Face  face;

    const FT_Byte* faceFtBytes = as_unsigned_char_array(env, faceBytes);
    FT_Long  faceBytesLength = env->GetArrayLength(faceBytes);
    FT_Error error = FT_New_Memory_Face((FT_Library) library, faceFtBytes, faceBytesLength, 0, &face);

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