package com.example.gamemechanics04_refactoring_and_minimap.draw;

import com.example.gamemechanics04_refactoring_and_minimap.gui.Gui;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class DrawMenu extends DrawMain {

    public static int xB = 175, widthB = 250, heightB = 60;
    public static int yB1 = 260, yB2 = yB1 + 100, yB3 = yB2 + 100, yB4 = yB3 + 120;

    public static void menu(GraphicsContext g) {
        // Menü-Hintergund
        g.setFill(Color.rgb(134, 89, 45, 0.6));
        g.fillRect(100, 100, Gui.width - 200, Gui.height - 200);
        g.setStroke(Color.valueOf(colorBorder));
        g.setLineWidth(3);
        g.strokeRect(100, 100, Gui.width - 200, Gui.height - 200);

        // Linienstärke wird zurückgesetzt
        g.setLineWidth(1);

        // Button Neues Spiel
        g.setStroke(Color.valueOf(colorB));
        g.strokeRect(xB, yB1, widthB, heightB);
        g.setFill(Color.valueOf(colorB));
        g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", fontSize));
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("Neues Spiel", xB + widthB / 2, yB1 + fontSize * 1.125);

        // Button Spiel laden
        g.setStroke(Color.valueOf(colorB));
        g.strokeRect(xB, yB2, widthB, heightB);
        g.setFill(Color.valueOf(colorB));
        g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", fontSize));
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("Laden", xB + widthB / 2, yB2 + fontSize * 1.125);

        // Button Spiel speichern
        g.setStroke(Color.valueOf(colorB));
        g.strokeRect(xB, yB3, widthB, heightB);
        g.setFill(Color.valueOf(colorB));
        g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", fontSize));
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("Speichern", xB + widthB / 2, yB3 + fontSize * 1.125);
        
    }
    
    public static void resume(GraphicsContext g) {
        // Button Resume
        g.setStroke(Color.valueOf(colorB));
        g.strokeRect(xB, yB1-100, widthB, heightB);
        g.setFill(Color.valueOf(colorB));
        g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", fontSize));
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("Resume", xB + widthB / 2, yB1-100 + fontSize * 1.125);
    }

}
