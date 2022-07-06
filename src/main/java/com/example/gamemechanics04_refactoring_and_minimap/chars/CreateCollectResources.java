package com.example.gamemechanics04_refactoring_and_minimap.chars;

public class CreateCollectResources {

    private static String[][] collectArray = new String[CreateRaster.xNumRaster][CreateRaster.yNumRaster];

    public static void insertOne(int i, int j) {
        collectArray[i][j] = "One";
    }

    public static void clearList() {
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                collectArray[i][j] = "";
            }
        }
    }

    public static String[][] getCollectArray() {
        return collectArray;
    }

    public static void setCollectArray(String[][] collectArray) {
        CreateCollectResources.collectArray = collectArray;
    }
    
}
