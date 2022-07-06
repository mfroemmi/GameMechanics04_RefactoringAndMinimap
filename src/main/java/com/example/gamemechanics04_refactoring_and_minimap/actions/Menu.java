package com.example.gamemechanics04_refactoring_and_minimap.actions;

import com.example.gamemechanics04_refactoring_and_minimap.chars.*;
import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawLadenSpeichern;
import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawMenu;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate_e;
import com.example.gamemechanics04_refactoring_and_minimap.json.ListAllFiles;
import com.example.gamemechanics04_refactoring_and_minimap.var.Lager;

import static com.example.gamemechanics04_refactoring_and_minimap.actions.Collision.rectangleCollision;

public class Menu {

    private static boolean resume = false;

    public static void main() {
        if (Gamestate.state == Gamestate_e.menu || Gamestate.state == Gamestate_e.laden || Gamestate.state == Gamestate_e.speichern) {
            // Klick Neues Spiel
            if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    DrawMenu.xB, DrawMenu.yB1, DrawMenu.widthB, DrawMenu.heightB)) {
                resume = true;
                DrawLadenSpeichern.stringLaden = "";
                Lager.laden("src/main/resources/com/example/gamemechanics04_refactoring_and_minimap/restart.json");
                // Alles löschen
                CreateBuildings.clearList();
                CreateTreesStorage.clearList();
                CreateLab.clearList();
                CreateWorker.worker.clear();
                CreateCollectResources.clearList();
                // Alles laden
                CreateTreesStorage.insertList();
                CreateTreesStorage.setStorage();
                CreateLab.insertBorder();
                Gamestate.state = Gamestate_e.ingame;
            }

            // Klick Laden
            if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    DrawMenu.xB, DrawMenu.yB2, DrawMenu.widthB, DrawMenu.heightB)) {               
                ListAllFiles.list(ListAllFiles.dirPath);
                Gamestate.state = Gamestate_e.laden;
            }

            // Klick Speichern
            if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                    DrawMenu.xB, DrawMenu.yB3, DrawMenu.widthB, DrawMenu.heightB)) {
                ListAllFiles.list(ListAllFiles.dirPath);
                DrawLadenSpeichern.stringLaden = "";
                Gamestate.state = Gamestate_e.speichern;
            }

            // Klick Menü-Button
            if (resume == true) {
                if (rectangleCollision(MousePressed.getX(), MousePressed.getY(), 1, 1,
                        DrawMenu.xB, DrawMenu.yB1 - 100, DrawMenu.widthB, DrawMenu.heightB)) {
                    Gamestate.state = Gamestate_e.ingame;
                }
            }
        }
    }
    
    public static boolean isResume() {
        return resume;
    }

    public static void setResume(boolean resume) {
        Menu.resume = resume;
    }
}
