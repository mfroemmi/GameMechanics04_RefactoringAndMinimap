package com.example.gamemechanics04_refactoring_and_minimap.chars;

public class CreateBuildings {

    private static String[][] buildingsArray = new String[CreateRaster.xNumRaster][CreateRaster.yNumRaster];
    private static boolean build = false;

    // Fügt der Liste buildingsArray ein Gebäude mit Position und Typ hinzu.
    public static void insertList(String building, int i, int j) {
        buildingsArray[i][j] = building;
        build = true;
    }

    public static void clearList() {
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                buildingsArray[i][j] = "";
            }
        }
    }

    public static String[][] getBuildingsArray() {
        return buildingsArray;
    }

    public static void setBuildingsArray(String[][] buildingsArray) {
        CreateBuildings.buildingsArray = buildingsArray;
    }

    public static boolean isBuild() {
        return build;
    }

    public static void setBuild(boolean build) {
        CreateBuildings.build = build;
    }

}
