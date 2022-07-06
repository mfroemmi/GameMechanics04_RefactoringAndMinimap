package com.example.gamemechanics04_refactoring_and_minimap.actions;

import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawLadenSpeichern;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate_e;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Gui;
import com.example.gamemechanics04_refactoring_and_minimap.var.Lager;

import static com.example.gamemechanics04_refactoring_and_minimap.actions.Collision.rectangleCollision;

public class Speichern extends Menu {

    public static void getText() {
        // Klick Spiel speichern
        if (Gamestate.state == Gamestate_e.speichern) {
            if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    DrawLadenSpeichern.xMain + DrawLadenSpeichern.mainWidth - DrawLadenSpeichern.widthLaden, DrawLadenSpeichern.yMain + DrawLadenSpeichern.mainHeight - 30, DrawLadenSpeichern.widthLaden, DrawLadenSpeichern.heightLaden)) {
                Lager.speichern(Gui.speichern.getText());
                Gamestate.state = Gamestate_e.ingame;
            }
        }
    }

}
