package com.example.gamemechanics04_refactoring_and_minimap.chars;

import com.example.gamemechanics04_refactoring_and_minimap.actions.Worker;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class CreateWorker {
    
    public static ArrayList<Worker> worker = new ArrayList<>();
    public static Timer timer;

    private static int x, y;

    public CreateWorker() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (CreateBuildings.isBuild()) {
                    worker.add(new Worker(x, y, CreateCross.getiPosition(), CreateCross.getjPosition(), x, y, Double.valueOf(x), Double.valueOf(y)));
                    CreateBuildings.setBuild(false);
                }
            }
        }, 600, 600);
    }
    
     public static int getX() {
        return x;
    }

    public static void setX(int x) {
        CreateWorker.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        CreateWorker.y = y;
    }

}
