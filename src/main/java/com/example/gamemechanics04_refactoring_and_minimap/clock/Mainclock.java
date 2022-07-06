package com.example.gamemechanics04_refactoring_and_minimap.clock;

import com.example.gamemechanics04_refactoring_and_minimap.actions.BuildMenu;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateCross;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate_e;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Gui;
import javafx.animation.AnimationTimer;

public class Mainclock {

    public static AnimationTimer maintimer;
    public static boolean areaTimer = true, collectTimer = true, pathfindingTimer = true;

    public static void Timer() {

        maintimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    Gui.gc_main.clearRect(0, 0, Gui.width, Gui.height);
                    Gui.dm.draw(Gui.gc_main);

                    CreateCross.checkCollision();
                    BuildMenu.hoverBuild();
                    if (Gamestate.state.equals(Gamestate_e.ingame)) {
                        if (areaTimer) {
                            BuildingAreaTimer.checkLumberjack();
                        }
                        if (pathfindingTimer) {
                            PathfindingTimer.setPathfindingTimer();
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Main timer error:" + e);
                }
            }
        };
        maintimer.start();

    }
}
