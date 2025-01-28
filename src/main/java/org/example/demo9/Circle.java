package org.example.demo9;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(Color color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    void draw(GraphicsContext gr) {
        gr.setFill(color);
        gr.fillRect(x, y, length, width);
        gr.setStroke(Color.BLACK);
        gr.strokeRect(x, y, length, width);
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.color + " and area is: " + area();
    }
}