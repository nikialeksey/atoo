#include "freetype2errors.h"
#include "errors.h"

const char *getErrorMessage(FT_Error err) {
#undef __FTERRORS_H__
#define FT_ERRORDEF(e, v, s)  case e: return s;
#define FT_ERROR_START_LIST     switch (err) {
#define FT_ERROR_END_LIST       }

#include FT_ERRORS_H

    return "(Unknown error)";
}

jint throwException(JNIEnv *env, FT_Error error) {
    jclass exClass;
    const char *className = "com/nikialeksey/freetype2/exceptions/Freetype2Exception";
    exClass = env->FindClass(className);
    if (exClass == NULL) {
        return throwNoClassDefError(env, className);
    }

    return env->ThrowNew(exClass, getErrorMessage(error));
}