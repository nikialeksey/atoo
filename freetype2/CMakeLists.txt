cmake_minimum_required(VERSION 3.6)

add_library( # Specifies the name of the library.
             freetype2

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/freetype2.cpp )

include_directories(jni/include/)