package com.example.gamemechanics04_refactoring_and_minimap.chars;

import java.util.Random;

public class CreateTreesStorage {

    public static String[][] treesArray = new String[CreateRaster.xNumRaster][CreateRaster.yNumRaster];

    public static int randomAnzahl, randomX, randomY;
    public static Random random = new Random();

    public static void insertList() {
        randomAnzahl = 25 + random.nextInt(30 - 25 + 1);

        for (int i = 0; i < randomAnzahl; i++) {
            randomX = random.nextInt(CreateRaster.xNumRaster);
            randomY = random.nextInt(CreateRaster.yNumRaster);
            if (i < randomAnzahl - 1) {
                treesArray[randomX][randomY] = "tree";
            }
            if (i == randomAnzahl - 1) {
                treesArray[CreateRaster.xNumRaster/2][CreateRaster.yNumRaster/2] = "storage";
            }
        }

    }

    public static void clearList() {
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                treesArray[i][j] = "";
            }
        }
    }

    public static void setStorage() {
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                if (treesArray[i][j] == "storage") {
                    CreateWorker.setX(i);
                    CreateWorker.setY(j);
                }
                if (treesArray[i][j] == "tree") {
                    CreateLab.borderArray[i][j] = true;
                }
            }
        }
    }

}
