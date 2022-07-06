package com.example.gamemechanics04_refactoring_and_minimap.gamemechanics04;

import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateWorker;
import com.example.gamemechanics04_refactoring_and_minimap.clock.Mainclock;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Gui;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    Gui g = new Gui();

    @Override
    public void start(Stage stage) {

        g.init();
        g.create(stage);

        Mainclock.Timer();
        new CreateWorker();

    }

    public static void main(String[] args) {
        launch();
    }
}