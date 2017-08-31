#include <jni.h>
#include <ft2build.h>
#include FT_FREETYPE_H

extern "C" {
    FT_Library  ftLibrary;

    JNIEXPORT void JNICALL
    Java_com_nikialeksey_freetype2_Freetype_init(JNIEnv *env, jclass cls) {
        FT_Error error = FT_Init_FreeType(&ftLibrary);
        // @todo #2:30m Throw java exception if error
    }
}