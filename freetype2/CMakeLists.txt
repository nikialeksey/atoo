cmake_minimum_required(VERSION 3.6)

add_library(Freetype2Commons SHARED src/main/cpp/commons/freetype2errors.cpp src/main/cpp/commons/errors.cpp)

add_library(Freetype2 SHARED src/main/cpp/freetype2.cpp)

add_library(Freetype2Face SHARED src/main/cpp/face.cpp)

include_directories(jni/include/)