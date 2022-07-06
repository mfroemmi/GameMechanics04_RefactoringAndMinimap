package com.example.gamemechanics04_refactoring_and_minimap.draw;

import com.example.gamemechanics04_refactoring_and_minimap.gui.Gui;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Image_Loader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import com.example.gamemechanics04_refactoring_and_minimap.var.Lager;

public class DrawNavi {
    
    public static void navi(GraphicsContext g){
        
        g.setFill(Color.rgb(134, 89, 45, 0.6));
        g.fillRect(0, 0, Gui.width, 70);
        g.setStroke(Color.DIMGREY);
        g.setLineWidth(3);
        g.strokeLine(0, 70, Gui.width, 70);
        
        g.drawImage(Image_Loader.naviMenu, Gui.width-60, 20, 30, 30);
        g.drawImage(Image_Loader.naviRaster, 20, 20, 30, 30);
        
        // Holz
        g.drawImage(Image_Loader.holz, 100, 20, 30, 30);
        g.setFill(Color.WHITE);
        g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", 15));
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("x" + Integer.parseInt(Lager.lagerArray[0][1]), 150, 40);
        
        // Stein
        g.drawImage(Image_Loader.stein, 200, 20, 30, 30);
        g.setFill(Color.WHITE);
        g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", 15));
        g.setTextAlign(TextAlignment.CENTER);
        g.fillText("x" + Integer.parseInt(Lager.lagerArray[1][1]), 250, 40);
    }
    
}
