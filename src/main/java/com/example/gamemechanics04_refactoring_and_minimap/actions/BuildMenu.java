package com.example.gamemechanics04_refactoring_and_minimap.actions;

import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateBuildings;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateCross;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateLab;
import com.example.gamemechanics04_refactoring_and_minimap.clock.MouseTimer;
import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawBuildMenu;
import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawMain;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate_e;
import com.example.gamemechanics04_refactoring_and_minimap.var.Lager;

import static com.example.gamemechanics04_refactoring_and_minimap.actions.Collision.rectangleCollision;

public class BuildMenu {

    private static int x, y, position;
    private static String chooseBuilding;
    private static boolean buildMenu = false;
    private static boolean hoverBuild = false;

    // Speichert bei Rechtsklick die letzte Position
    public static void setPosition(int xMain, int yMain) {
        if (!buildMenu) {
            x = xMain + DrawMain.getxOffset();
            y = yMain + DrawMain.getyOffset();
        }
        buildMenu = true;
    }

    // Bauphase I
    public static void hoverBuild() {
        if (Buildstate.state == Buildstate_e.buildMenu) {
            if (rectangleCollision(MouseMoved.getX(), MouseMoved.getY(), 1, 1,
                    x + 30, y + 30, 60, 60)) {
                hoverBuild = true;
                chooseBuilding = "lumberjack";
            } else if (rectangleCollision(MouseMoved.getX(), MouseMoved.getY(), 1, 1,
                    x + 120, y + 30, 60, 60)) {
                hoverBuild = true;
                chooseBuilding = "stonepit";
            } else {
                hoverBuild = false;
            }
        }
    }

    // Bauphase II
    public static void chooseBuild() {
        if (Buildstate.state == Buildstate_e.buildMenu) {
            // Baue die Holzfällerhütte
            if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    x + 30, y + 30, 60, 60)) {
                Buildstate.state = Buildstate_e.chooseBuild;
                MouseTimer.setBuildTimer();
            } else if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    x + 120, y + 30, 60, 60)) {
                Buildstate.state = Buildstate_e.chooseBuild;
                MouseTimer.setBuildTimer();
            } else {
                Buildstate.state = Buildstate_e.none;
            }
        }
    }

    // Bauphase III
    public static void build() {
        if (Buildstate.state == Buildstate_e.setBuild) {
            if (CreateLab.borderArray[CreateCross.getiPosition()][CreateCross.getjPosition()] != true) {
                CreateBuildings.insertList(BuildMenu.chooseBuilding, CreateCross.getiPosition(), CreateCross.getjPosition());
                Buildstate.state = Buildstate_e.none;
            }
        }
    }

    public static void checkResources(String res, int val) {
        for (int i = 0; i < Lager.lagerArray.length; i++) {
            if (Lager.lagerArray[i][0] == res) {
                if (Integer.parseInt(Lager.lagerArray[i][1]) >= val) {
                    DrawBuildMenu.colorText = "WHITE";
                } else {
                    DrawBuildMenu.colorText = "RED";
                }
            }
        }
    }

    public static void allFalse() {
        buildMenu = false;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        BuildMenu.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        BuildMenu.y = y;
    }

    public static int getPosition() {
        return position;
    }

    public static void setPosition(int position) {
        BuildMenu.position = position;
    }

    public static String getChooseBuilding() {
        return chooseBuilding;
    }

    public static void setChooseBuilding(String chooseBuilding) {
        BuildMenu.chooseBuilding = chooseBuilding;
    }

    public static boolean isBuildMenu() {
        return buildMenu;
    }

    public static void setBuildMenu(boolean buildMenu) {
        BuildMenu.buildMenu = buildMenu;
    }

    public static boolean isHoverBuild() {
        return hoverBuild;
    }

    public static void setHoverBuild(boolean hoverBuild) {
        BuildMenu.hoverBuild = hoverBuild;
    }

}
