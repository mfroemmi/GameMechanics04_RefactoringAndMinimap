package com.example.gamemechanics04_refactoring_and_minimap.actions;

import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateBuildings;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateCollectResources;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateRaster;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateTreesStorage;
import com.example.gamemechanics04_refactoring_and_minimap.var.Lager;

public class BuildingArea {

    //Durchsuche das Array nach Holzfällerhütten
    public static void lumberjack() {       
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                if (CreateBuildings.getBuildingsArray()[i][j] == "lumberjack") {

                    //For-Schleifen zum prüfen der Area
                    for (int k = -1; k < 2; k++) {
                        for (int l = -1; l < 2; l++) {
                            checkTrees(i + k, j + l);
                        }
                    }

                }
            }
        }       
    }

    public static void checkTrees(int i, int j) {        
        if (CreateTreesStorage.treesArray[i][j] == "tree") {
            Lager.setHolz(Lager.getHolz() + 1);
            CreateCollectResources.insertOne(i, j);
        }
    }
}
