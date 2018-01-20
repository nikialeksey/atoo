uniform mat4 camera;
attribute vec4 position;
attribute vec4 color;
varying vec4 fragmentColor;
void main() {
    fragmentColor = color;
    gl_Position = camera * position;
}