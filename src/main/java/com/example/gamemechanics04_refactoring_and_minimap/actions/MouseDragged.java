package com.example.gamemechanics04_refactoring_and_minimap.actions;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseDragged implements EventHandler<MouseEvent> {

    private static int x, y;

    @Override
    public void handle(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            x = (int) e.getX();
            y = (int) e.getY();
            Offset.Offset();
        }
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        MouseDragged.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        MouseDragged.y = y;
    }

}
