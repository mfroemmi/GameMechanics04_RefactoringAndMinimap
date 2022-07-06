package com.example.gamemechanics04_refactoring_and_minimap.chars;

import com.example.gamemechanics04_refactoring_and_minimap.actions.MouseMoved;
import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawMain;

import static com.example.gamemechanics04_refactoring_and_minimap.actions.Collision.rectangleCollision;

public class CreateCross {

    private static int xCross = -10, yCross = -10, iPosition, jPosition;

    // Fügt das Fadenkreuz (Punkt) an der Mausposition ein.
    public static void checkCollision() {
        for (int i = 0; i < CreateRaster.xNumRaster; i++) {
            for (int j = 0; j < CreateRaster.yNumRaster; j++) {
                if (rectangleCollision(MouseMoved.getX(), MouseMoved.getY(), 1, 1,
                        CreateRaster.factorRaster + (CreateRaster.factorRaster * i) - (CreateRaster.factorRaster / 2) + DrawMain.getxOffset(),
                        (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j) - (CreateRaster.factorRaster / 2) + DrawMain.getyOffset(),
                        CreateRaster.factorRaster, CreateRaster.factorRaster)) {
                    xCross = CreateRaster.factorRaster + (CreateRaster.factorRaster * i);
                    yCross = (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * j);
                    iPosition = i;
                    jPosition = j;
                }
            }
        }
    }

    public static int getxCross() {
        return xCross;
    }

    public static void setxCross(int xCross) {
        CreateCross.xCross = xCross;
    }

    public static int getyCross() {
        return yCross;
    }

    public static void setyCross(int yCross) {
        CreateCross.yCross = yCross;
    }

    public static int getiPosition() {
        return iPosition;
    }

    public static void setiPosition(int iPosition) {
        CreateCross.iPosition = iPosition;
    }

    public static int getjPosition() {
        return jPosition;
    }

    public static void setjPosition(int jPosition) {
        CreateCross.jPosition = jPosition;
    }

}
