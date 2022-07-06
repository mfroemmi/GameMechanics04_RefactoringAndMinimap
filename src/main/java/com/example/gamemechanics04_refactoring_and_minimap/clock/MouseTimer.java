package com.example.gamemechanics04_refactoring_and_minimap.clock;

import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate_e;

import java.util.Timer;
import java.util.TimerTask;

public class MouseTimer {

    public static void setBuildTimer() {
        Timer timer;

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
                if (Buildstate.state == Buildstate_e.chooseBuild) {
                    Buildstate.state = Buildstate_e.setBuild;
                }  
                timer.cancel();
            }
        }, 30, 30);
    }

}
