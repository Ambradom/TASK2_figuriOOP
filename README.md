---

## JavaFX Example: Drawing Shapes on a Canvas

This example demonstrates how to use the JavaFX library to draw various shapes on a canvas in an application. The controller class handles the drawing of different shapes such as rectangles, lines, triangles, and ovals when corresponding buttons are clicked. Each shape is drawn using specific methods provided by the GraphicsContext class.

#### Class Overview

The main class for this example is `ShapeDrawer.java`, which contains methods for each type of shape to be drawn. These methods include:

- `drawRectangleButton`: Draws a rounded rectangle.
- `drawTriangleButton`: Draws a triangle.
- `drawCircleButton`: Draws an circle.

Each method clears the canvas before drawing the new shape with specified colors and thicknesses.

### Example Code

```java
package org.example.demo9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ShapeDrawer extends Application {
    private Canvas canvas;
    private ColorPicker colorPicker;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(400, 400);
        colorPicker = new ColorPicker(Color.BLUE);

        // Создаем кнопки для рисования фигур
        Button drawRectangleButton = new Button("Прямоугольник");
        drawRectangleButton.setOnAction(e -> canvas.setOnMouseClicked(this::handleMouseClickRectangle));

        Button drawCircleButton = new Button("Круг");
        drawCircleButton.setOnAction(e -> canvas.setOnMouseClicked(this::handleMouseClickCircle));

        Button drawTriangleButton = new Button("Треугольник");
        drawTriangleButton.setOnAction(e -> canvas.setOnMouseClicked(this::handleMouseClickTriangle));

        // Создаем HBox для кнопок
        HBox buttonBox = new HBox(10, drawRectangleButton, drawCircleButton, drawTriangleButton);
        buttonBox.setStyle("-fx-padding: 10;"); // Отступы для кнопок
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER); // Выравнивание по центру

        // Создаем VBox для цветового выбора и кнопок
        VBox layout = new VBox();
        layout.getChildren().addAll(canvas, colorPicker, buttonBox);
        layout.setStyle("-fx-padding: 10;"); // Отступы для основного макета

        // Создаем сцену и устанавливаем ее в окно
        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shape Drawer");
        primaryStage.show();
    }

    private void handleMouseClickRectangle(MouseEvent event) {
        drawShape(new Rectangle(colorPicker.getValue(), 100, 50), event.getX(), event.getY());
    }

    private void handleMouseClickCircle(MouseEvent event) {
        drawShape(new Circle(colorPicker.getValue(), 30), event.getX(), event.getY());
    }

    private void handleMouseClickTriangle(MouseEvent event) {
        drawShape(new Triangle(colorPicker.getValue(), 60, 40), event.getX(), event.getY());
    }

    private void drawShape(Shape shape, double x, double y) {
        // Центрируем фигуру
        shape.x = x - (shape instanceof Circle ? 30 : (shape instanceof Triangle ? 0 : 50)); // Центрируем фигуру
        shape.y = y - (shape instanceof Circle ? 30 : (shape instanceof Triangle ? -25 : 25)); // Центрируем фигуру

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        shape.draw(graphicsContext);
        System.out.println(shape.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
