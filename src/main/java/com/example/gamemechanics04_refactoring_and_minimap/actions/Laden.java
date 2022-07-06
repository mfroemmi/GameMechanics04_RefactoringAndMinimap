package com.example.gamemechanics04_refactoring_and_minimap.actions;

import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawLadenSpeichern;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate_e;
import com.example.gamemechanics04_refactoring_and_minimap.json.ListAllFiles;
import com.example.gamemechanics04_refactoring_and_minimap.var.Lager;

import java.io.File;

import static com.example.gamemechanics04_refactoring_and_minimap.actions.Collision.rectangleCollision;

public class Laden extends Menu {

    public static void chooseFile() {
        if (Gamestate.state == Gamestate_e.laden) {
            int offset = 0;
            for (File file : ListAllFiles.fList) {
                if (rectangleCollision(MouseMoved.getX(), MouseMoved.getY(), 1, 1,
                        DrawLadenSpeichern.xMain, DrawLadenSpeichern.yMain + 30 + offset, DrawLadenSpeichern.mainWidth, 30)) {
                    DrawLadenSpeichern.stringLaden = file.getName();                    
                }
                offset += 30;
            }
            if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    DrawLadenSpeichern.xMain + DrawLadenSpeichern.mainWidth - DrawLadenSpeichern.widthLaden, DrawLadenSpeichern.yMain + DrawLadenSpeichern.mainHeight - 30, DrawLadenSpeichern.widthLaden, DrawLadenSpeichern.heightLaden)) {
                Lager.laden("src/main/java/com/example/gamemechanics04_refactoring_and_minimap/save/" + DrawLadenSpeichern.stringLaden);
                Gamestate.state = Gamestate_e.ingame;
            }
        }
    }
}
