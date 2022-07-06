package com.example.gamemechanics04_refactoring_and_minimap.draw;

import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateCollectResources;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateRaster;
import com.example.gamemechanics04_refactoring_and_minimap.clock.BuildingAreaTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class DrawCollectResources extends DrawMain {

    public static void drawCollectOne(GraphicsContext g) {
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {

                if (CreateCollectResources.getCollectArray()[i][j] == "One") {
                    g.setFill(Color.WHITE);
                    g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", 15));
                    g.setTextAlign(TextAlignment.CENTER);
                    g.fillText("+1", CreateRaster.factorRaster + (CreateRaster.factorRaster * i) + 25 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j) - BuildingAreaTimer.tick + getyOffset());
                }

            }
        }
    }
}
