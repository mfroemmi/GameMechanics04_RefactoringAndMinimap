package com.example.gamemechanics04_refactoring_and_minimap.draw;

import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateBuildings;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateRaster;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateTreesStorage;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Image_Loader;
import javafx.scene.canvas.GraphicsContext;

public class DrawBuildings extends DrawMain {

    public static void buildings(GraphicsContext g) {
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                
                //Gebäude
                if (CreateTreesStorage.treesArray[i][j] == "storage") {
                    g.drawImage(Image_Loader.storage, CreateRaster.factorRaster + (CreateRaster.factorRaster * i)-30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j)-30 + getyOffset(), 60, 60);
                }
                if (CreateBuildings.getBuildingsArray()[i][j] == "lumberjack") {
                    g.drawImage(Image_Loader.lumberjack, CreateRaster.factorRaster + (CreateRaster.factorRaster * i)-30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j)-30 + getyOffset(), 60, 60);
                }
                if (CreateBuildings.getBuildingsArray()[i][j] == "stonepit") {
                    g.drawImage(Image_Loader.stonepit, CreateRaster.factorRaster + (CreateRaster.factorRaster * i)-30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j)-30 + getyOffset(), 60, 60);
                }
                
                //Umgebung
                if (CreateTreesStorage.treesArray[i][j] == "tree") {
                    g.drawImage(Image_Loader.tree, CreateRaster.factorRaster + (CreateRaster.factorRaster * i)-30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j)-30 + getyOffset(), 60, 60);
                }
                /*
                if (CreateLab.lab[i][j] == true) {
                    g.drawImage(Image_Loader.zone, CreateRaster.factorRaster + (CreateRaster.factorRaster * i)-30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j)-30 + getyOffset(), 60, 60);
                }
                */
 
            }
        }
    }

}
