package com.example.gamemechanics04_refactoring_and_minimap.gui;

import com.example.gamemechanics04_refactoring_and_minimap.actions.MouseDragged;
import com.example.gamemechanics04_refactoring_and_minimap.actions.MouseMoved;
import com.example.gamemechanics04_refactoring_and_minimap.actions.MousePressed;
import com.example.gamemechanics04_refactoring_and_minimap.actions.MouseReleased;
import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawLadenSpeichern;
import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawMain;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Gui {

    public static DrawMain dm;
    public static int width = 1280, height = 720;
    public static GraphicsContext gc_main;
    public static TextField speichern = new TextField();

    public void init() {
        dm = new DrawMain();
    }

    public void create(Stage stage) {
        Canvas canvas_main;
        Group root = new Group();
        int cWidth = width - 10, cHeight = height - 10;
        canvas_main = new Canvas(width, height);
        gc_main = canvas_main.getGraphicsContext2D();
        dm.draw(gc_main);

        // Eingabefeld auf der Speichern-Seite 
        speichern.setMinWidth(DrawLadenSpeichern.mainWidth - 102);
        speichern.setMinHeight(28);
        speichern.setAlignment(Pos.TOP_LEFT);
        speichern.setTranslateX(DrawLadenSpeichern.xMain+1);
        speichern.setTranslateY(DrawLadenSpeichern.yMain + DrawLadenSpeichern.mainHeight - 29);
        speichern.setStyle("-fx-background-color: -fx-control-inner-background;");

        root.getChildren().add(canvas_main);
        root.getChildren().add(speichern);
        Scene scene = new Scene(root, cWidth, cHeight);

        scene.setOnMouseReleased(new MouseReleased());
        scene.setOnMouseMoved(new MouseMoved());
        scene.setOnMouseDragged(new MouseDragged());
        scene.setOnMousePressed(new MousePressed());

        stage.setTitle("GameMechanics04");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

}
