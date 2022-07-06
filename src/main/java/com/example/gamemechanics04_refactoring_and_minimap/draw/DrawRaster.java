package com.example.gamemechanics04_refactoring_and_minimap.draw;

import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateCross;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateRaster;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawRaster extends DrawMain {

    public static boolean notRaster = true;

    public static void raster(GraphicsContext g) {

        if (notRaster == false) {
            for (int i = 0; i < CreateRaster.xNumRaster; i++) {
                for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                    g.setFill(Color.rgb(255, 255, 255, 0.4));
                    g.fillOval(CreateRaster.factorRaster + (CreateRaster.factorRaster * i) + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j) + getyOffset(), 5, 5);
                }
            }
        }
        g.setFill(Color.ORANGE);
        g.fillOval(CreateCross.getxCross() - 2.5 + getxOffset(), CreateCross.getyCross() - 2.5 + getyOffset(), 10, 10);

    }

}
