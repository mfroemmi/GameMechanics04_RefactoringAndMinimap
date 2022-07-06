package com.example.gamemechanics04_refactoring_and_minimap.actions;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseMoved implements EventHandler<MouseEvent> {

    private static int x, y;

    @Override
    public void handle(MouseEvent e) {
        x = (int) e.getX();
        y = (int) e.getY();
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        MouseMoved.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        MouseMoved.y = y;
    }

}
