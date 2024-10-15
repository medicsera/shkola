package org.example;

import Exceptions.InvalidDimensionException;
import Exceptions.InvalidRadiusException;
import geometry2d.Circle;
import geometry2d.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {

    @Test
    public void testCircleArea() {
        Circle circle = new Circle(5.0);
        assertEquals(78.53981633974483, circle.area(), 0.00001);
    }

    @Test
    public void testCirclePerimeter() {
        Circle circle = new Circle(5.0);
        assertEquals(31.41592653589793, circle.perimeter(), 0.00001);
    }

    @Test
    public void testCircleToString() {
        Circle circle = new Circle(5.0);
        assertEquals("Круг с радиусом 5.0", circle.toString());
    }

    @Test
    public void testCircleInvalidRadius() {
        assertThrows(InvalidRadiusException.class, () -> new Circle(-5.0));
    }

    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle((int) 4.0, (int) 3.0);
        assertEquals(12.0, rectangle.area(), 0.00001);
    }

    @Test
    public void testRectanglePerimeter() {
        Rectangle rectangle = new Rectangle((int) 4.0, (int) 3.0);
        assertEquals(14.0, rectangle.perimeter(), 0.00001);
    }

    @Test
    public void testRectangleToString() {
        Rectangle rectangle = new Rectangle((int) 4.0, (int) 3.0);
        assertEquals("Прямоугольник с шириной 4.0 и высотой 3.0", rectangle.toString());
    }

    @Test
    public void testRectangleInvalidDimension() {
        assertThrows(InvalidDimensionException.class, () -> new Rectangle((int) -4.0, (int) 3.0));
        assertThrows(InvalidDimensionException.class, () -> new Rectangle((int) 4.0, (int) -3.0));
    }
}

