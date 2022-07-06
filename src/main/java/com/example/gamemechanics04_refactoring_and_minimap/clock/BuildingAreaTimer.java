package com.example.gamemechanics04_refactoring_and_minimap.clock;

import com.example.gamemechanics04_refactoring_and_minimap.actions.BuildingArea;

import java.util.Timer;
import java.util.TimerTask;

public class BuildingAreaTimer {
    
    public static int tick = 0;

    public static void checkLumberjack() {
        Mainclock.areaTimer = false;
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ex) {

                }
                Mainclock.areaTimer = true;
                BuildingArea.lumberjack();
                collectResources();
                animationResources();
                timer.cancel();
            }
        }, 30, 30);
    }

    public static void collectResources() {
        Mainclock.collectTimer = true;
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {

                }
                Mainclock.collectTimer = false;
                timer.cancel();
            }
        }, 30, 30);
    }

    public static void animationResources() {
        

        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    while (tick < 25) {
                        tick += 1;
                        Thread.sleep(100);
                    }        
                } catch (InterruptedException ex) {
                    
                }
                tick = 0;
                timer.cancel();
            }
        }, 30, 30);
    }

}
