#pragma once
#include <jni.h>
#include <ft2build.h>
#include "freetype/freetype.h" FT_FREETYPE_H

jint throwInitialize(JNIEnv *env, FT_Error error);

jint throwRelease(JNIEnv *env, FT_Error error);