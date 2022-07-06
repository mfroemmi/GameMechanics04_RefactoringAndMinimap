package com.example.gamemechanics04_refactoring_and_minimap.actions;

import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawRaster;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate_e;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Gui;

import static com.example.gamemechanics04_refactoring_and_minimap.actions.Collision.rectangleCollision;

public class Navi extends Menu {

    public static void navi() {

        if (Gamestate.state == Gamestate_e.ingame) {
            // Klick Menü-Button
            if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    Gui.width - 60, 20, 30, 30)) {
                Gamestate.state = Gamestate_e.menu;
            }

            // Klick Raster-Button
            if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    20, 20, 30, 30)) {
                if (DrawRaster.notRaster) {
                    DrawRaster.notRaster = false;
                } else {
                    DrawRaster.notRaster = true;
                }
            }
        }
    }

}
