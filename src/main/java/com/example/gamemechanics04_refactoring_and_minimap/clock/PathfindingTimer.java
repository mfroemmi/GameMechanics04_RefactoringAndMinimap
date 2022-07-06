package com.example.gamemechanics04_refactoring_and_minimap.clock;

import com.example.gamemechanics04_refactoring_and_minimap.chars.UpdateWorker;

import java.util.Timer;
import java.util.TimerTask;

public class PathfindingTimer {
    public static void setPathfindingTimer() {
        Mainclock.pathfindingTimer = false;
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException ex) {

                }
                Mainclock.pathfindingTimer = true;
                UpdateWorker.updateWorker();
                timer.cancel();
            }
        }, 10, 30);
    }
}
