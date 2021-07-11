package com.tw.bootcamp.rectangle;

public class Rectangle {

    private final  int length;
    private final int width;

    public Rectangle (int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle (int side){
        this.length = side;
        this.width = side;
    }

    public int area() {
        return length * width;
    }

    public int perimeter() {
        return 2 * (length + width);
    }

}
