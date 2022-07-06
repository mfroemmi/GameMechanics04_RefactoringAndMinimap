package com.example.gamemechanics04_refactoring_and_minimap.draw;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import com.example.gamemechanics04_refactoring_and_minimap.json.ListAllFiles;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DrawLadenSpeichern {

    public static int xMain = DrawMenu.xB + 300, yMain = 150, mainWidth = 600, mainHeight = 400;
    public static int xLaden = xMain + mainWidth - 100, yLaden = yMain + mainHeight - 30, widthLaden = 100, heightLaden = 30;
    public static int xSpeichern = xMain + mainWidth - 100, ySpeichern = yMain + mainHeight - 30, widthSpeichern = 100, heightSpeichern = 30;
    public static String stringLaden = "";
    public static int fontSize = 20;

    public static void ladenSpeichern(GraphicsContext g) {
        // Spielstände-Hintergund
        g.setFill(Color.rgb(255, 255, 255, 0.8));
        g.fillRect(xMain, yMain, mainWidth, mainHeight);
        g.setStroke(Color.DIMGREY);
        g.setLineWidth(1);
        g.strokeRect(xMain, yMain, mainWidth, mainHeight);

        // Liste der Spielstände
        g.setFill(Color.BLACK);
        g.setTextAlign(TextAlignment.LEFT);
        g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", fontSize));
        int offset = 0;
        for (File file : ListAllFiles.fList) {
            String content = null;
            try {
                content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
            } catch (IOException ex) {
                Logger.getLogger(DrawLadenSpeichern.class.getName()).log(Level.SEVERE, null, ex);
            }
            JSONObject json = new JSONObject(content);
            String datum = json.getString("datum");
            g.fillText(datum, xMain + 30, 200 + offset);
            
            g.fillText(file.getName(), xMain + 200, 200 + offset);
            offset += 30;
        }

        // Laden-Leiste
        g.setStroke(Color.DIMGREY);
        g.setLineWidth(1);
        g.strokeRect(xMain, yMain + mainHeight - 30, mainWidth - 100, 30);

        g.setFill(Color.rgb(200, 200, 200, 0.8));
        g.fillRect(xMain + mainWidth - widthLaden, yMain + mainHeight - 30, widthLaden, heightLaden);
        g.setStroke(Color.DIMGREY);
        g.setLineWidth(1);
        g.strokeRect(xMain + mainWidth - widthLaden, yMain + mainHeight - 30, widthLaden, heightLaden);
    }
    
    public static void laden(GraphicsContext g) {       
        // Text der Ladenleiste
        g.setFill(Color.BLACK);
        g.fillText(stringLaden, xMain + 30, yMain + mainHeight - 30 + fontSize * 1.125);
        
        // Laden-Button
        g.setFill(Color.BLACK);
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("Laden", xLaden + widthLaden / 2, yLaden + fontSize * 1.125);
    }
    
    public static void speichern(GraphicsContext g) {
        // Speichern-Button 
        g.setFill(Color.BLACK);
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("Speichern", xSpeichern + widthSpeichern / 2, ySpeichern + fontSize * 1.125);

    }
}
