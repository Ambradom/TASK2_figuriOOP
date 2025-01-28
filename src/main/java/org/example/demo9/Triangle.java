package org.example.demo9;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Circle extends Shape {
    double radius;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    void draw(GraphicsContext gr) {
        gr.setFill(color);
        gr.fillOval(x, y, radius * 2, radius * 2);
        gr.setStroke(Color.BLACK);
        gr.strokeOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public String toString() {
        return "Circle color is " + super.color + " and area is: " + area();
    }
}