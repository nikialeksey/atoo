cmake_minimum_required(VERSION 3.6)

add_library(freetype STATIC IMPORTED)
set_target_properties(freetype PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libfreetype.so)

add_library(Freetype2Commons SHARED src/main/cpp/commons/freetype2errors.cpp src/main/cpp/commons/errors.cpp)
target_link_libraries(Freetype2Commons freetype)

add_library(Freetype2 SHARED src/main/cpp/freetype2.cpp)
target_link_libraries(Freetype2 Freetype2Commons)

add_library(Freetype2Face SHARED src/main/cpp/face.cpp)
target_link_libraries(Freetype2Face Freetype2Commons)

add_library(Freetype2Glyph SHARED src/main/cpp/glyph.cpp)
target_link_libraries(Freetype2Glyph Freetype2Commons)

include_directories(jni/include/)