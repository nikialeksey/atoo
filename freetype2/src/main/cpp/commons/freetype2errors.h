#pragma once
#include <jni.h>
#include <ft2build.h>
#include "freetype/freetype.h" FT_FREETYPE_H

jint throwException(JNIEnv *env, FT_Error error, const char *className);