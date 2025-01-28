package org.example.demo9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Shape {
    protected Color color;
    protected double x, y;

    public Shape(Color color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    abstract double area();
    abstract void draw(GraphicsContext gr);

    public void setColor(Color color) {
        this.color = color;
    }
}