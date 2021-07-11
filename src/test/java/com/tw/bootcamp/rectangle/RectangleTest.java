package com.tw.bootcamp.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
    @Test
    void areaOfRectangleShouldBeSixWhenLengthIsThreeAndWidthIsTwo() {
        Rectangle rectangle = new Rectangle(3,2);
        assertEquals(6,rectangle.area());
    }

    @Test
    void perimeterOfRectangleShouldBeSixWhenLengthIsFourAndWidthIsThree() {
        Rectangle rectangle = new Rectangle(4,3);
        assertEquals(14,rectangle.perimeter());
    }

    @Test
    void areaOfSquareShouldBeNineWhenLengthIsThree() {
        Rectangle rectangle = new Rectangle(3);
        assertEquals(9,rectangle.area());
    }

    @Test
    void perimeterOfSquareShouldBeTwelveWhenLengthIsThree() {
        Rectangle rectangle = new Rectangle(3);
        assertEquals(12,rectangle.perimeter());
    }

}
