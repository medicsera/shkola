package geometry3d;

import Exceptions.InvalidHeightException;
import geometry2d.Figure;

class Cylinder {
    private Figure base;
    private double height;

    public Cylinder(Figure base, double height) {
        if (height <= 0) {
            throw new InvalidHeightException("Высота цилиндра должна быть положительным числом.");
        }
        this.base = base;
        this.height = height;
    }

    public double volume() {
        return base.area() * height;
    }
}
