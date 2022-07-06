package com.example.gamemechanics04_refactoring_and_minimap.chars;

public class CreateRaster {
    
    private static int heightWorld = 1500, widthWorld = 2500;
    
    public static int factorRaster = 60;
    public static int xNumRaster = widthWorld/factorRaster-1;
    public static int yNumRaster = heightWorld/factorRaster-2;

    public static int getHeightWorld() {
        return heightWorld;
    }

    public static void setHeightWorld(int heightWorld) {
        CreateRaster.heightWorld = heightWorld;
    }

    public static int getWidthWorld() {
        return widthWorld;
    }

    public static void setWidthWorld(int widthWorld) {
        CreateRaster.widthWorld = widthWorld;
    }
    
    
    
}
