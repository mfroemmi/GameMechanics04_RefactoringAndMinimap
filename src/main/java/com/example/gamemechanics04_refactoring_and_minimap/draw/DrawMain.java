package com.example.gamemechanics04_refactoring_and_minimap.draw;

import com.example.gamemechanics04_refactoring_and_minimap.actions.BuildMenu;
import com.example.gamemechanics04_refactoring_and_minimap.actions.Menu;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateRaster;
import com.example.gamemechanics04_refactoring_and_minimap.clock.Mainclock;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate_e;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate_e;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Gui;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class DrawMain {

    public static String colorB = "WHITE";
    public static String colorBorder = "DIMGREY";
    public static int fontSize = 40;
    private static int xOffset = -CreateRaster.getWidthWorld()/4, yOffset = -CreateRaster.getHeightWorld()/4;

    public void draw(GraphicsContext g) {

        // Hintergund des Spiels
        Image bg01 = new Image("com/example/gamemechanics04_refactoring_and_minimap/images/bg01.png");
        ImagePattern pattern = new ImagePattern(bg01, 20, 20, 40, 40, false);
        g.setFill(pattern);
        g.fillRect(0, 0, Gui.width, Gui.height);

        // Im Spiel
        if (Gamestate.state == Gamestate_e.ingame) {
            DrawRaster.raster(g);
            DrawBuildings.buildings(g);
            DrawWorker.moveResource(g);

            // Navi-Leiste
            if (Menu.isResume() == true) {
                DrawNavi.navi(g);
            }

            if (Mainclock.collectTimer) {
                DrawCollectResources.drawCollectOne(g);
            }

            if (Buildstate.state == Buildstate_e.buildMenu) {
                DrawBuildMenu.buildMenu(g);
                if (BuildMenu.isHoverBuild() == true) {
                    DrawBuildMenu.hoverBuild(g);
                }
            }

            if (Buildstate.state == Buildstate_e.chooseBuild || Buildstate.state == Buildstate_e.setBuild) {
                DrawBuildMenu.chooseBuilding(g);
            }
        }

        // Im Menü
        if (Gamestate.state == Gamestate_e.menu || Gamestate.state == Gamestate_e.laden || Gamestate.state == Gamestate_e.speichern) {
            DrawMenu.menu(g);
            
            // Navi-Leiste
            if (Menu.isResume() == true) {
                DrawNavi.navi(g);
            }
            
            if (Menu.isResume() == true) {
                DrawMenu.resume(g);
            }
        }

        // Spielstand laden
        if (Gamestate.state == Gamestate_e.laden) {
            DrawLadenSpeichern.ladenSpeichern(g);
            DrawLadenSpeichern.laden(g);
        }

        // Spielstand speichern
        if (Gamestate.state == Gamestate_e.speichern) {
            DrawLadenSpeichern.ladenSpeichern(g);
            DrawLadenSpeichern.speichern(g);
            Gui.speichern.setVisible(true);
        } else {
            Gui.speichern.setVisible(false);
        }

    }

    public static int getxOffset() {
        return xOffset;
    }

    public static void setxOffset(int xOffset) {
        DrawMain.xOffset = xOffset;
    }

    public static int getyOffset() {
        return yOffset;
    }

    public static void setyOffset(int yOffset) {
        DrawMain.yOffset = yOffset;
    }

}
