package org.example.demo9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class ShapeDrawer extends Application {
    private Canvas canvas;
    private ColorPicker colorPicker;
    private double lastX = 50; // начальная позиция
    private double lastY = 50; // начальная позиция
    private int shapeCount = 0; // счетчик фигур

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(400, 400);
        colorPicker = new ColorPicker();

        Button drawRectangleButton = new Button("Draw Rectangle");
        drawRectangleButton.setOnAction(e -> onDrawRectangle());

        VBox layout = new VBox(colorPicker, drawRectangleButton, canvas);
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shape Drawer");
        primaryStage.show();
    }

    private void onDrawRectangle() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        javafx.scene.paint.Color color = colorPicker.getValue();
        Rectangle rectangle = new Rectangle(color, 100, 50);
        rectangle.draw(graphicsContext);

        lastX += 10; // смещаем координаты для следующей фигуры
        lastY += 10; // смещаем координаты для следующей фигуры
        rectangle.x = lastX; // задаем координаты
        rectangle.y = lastY; // задаем координаты
        shapeCount++; // увеличиваем счетчик фигур

        System.out.println(rectangle.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}