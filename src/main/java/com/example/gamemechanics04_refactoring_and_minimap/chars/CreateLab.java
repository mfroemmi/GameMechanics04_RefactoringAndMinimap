package com.example.gamemechanics04_refactoring_and_minimap.chars;

public class CreateLab {

    public static boolean[][] borderArray = new boolean[CreateRaster.xNumRaster][CreateRaster.yNumRaster];

    public static void insertBorder() {
        //Obere-Reihe
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            borderArray[i][0] = true;
        }
        //Untere-Reihe
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            borderArray[i][CreateRaster.yNumRaster-1] = true;
        }
        //Linke-Reihe
        for (int j = 0; j < CreateRaster.yNumRaster; j++) {
            borderArray[0][j] = true;
        }
        //Rechte-Reihe
        for (int j = 0; j < CreateRaster.yNumRaster; j++) {
            borderArray[CreateRaster.xNumRaster-1][j] = true;
        }
        
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                if (CreateTreesStorage.treesArray[i][j] == "tree" || CreateTreesStorage.treesArray[i][j] == "storage") {
                    borderArray[i][j] = true;
                }
            }
        }
    }

    public static void clearList() {
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                CreateLab.borderArray[i][j] = false;
            }
        }
    }

}
