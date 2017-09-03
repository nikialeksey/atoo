#include "errors.h"

jint throwNoClassDefError(JNIEnv *env, const char *message) {
    jclass exClass;
    const char *className = "java/lang/NoClassDefFoundError";

    exClass = env->FindClass(className);
    if (exClass == NULL) {
        return throwNoClassDefError(env, className);
    }

    return env->ThrowNew(exClass, message);
}