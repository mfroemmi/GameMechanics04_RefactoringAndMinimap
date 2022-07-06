package com.example.gamemechanics04_refactoring_and_minimap.actions;

import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateCross;
import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawMain;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate_e;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate_e;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MousePressed implements EventHandler<MouseEvent> {

    private static int x, y;
    private static int xOffset, yOffset;

    @Override
    public void handle(MouseEvent e) {

        x = (int) e.getX();
        y = (int) e.getY();
        xOffset = DrawMain.getxOffset();
        yOffset = DrawMain.getyOffset();
        
        // Linke Maustaste
        if (e.getButton() == MouseButton.PRIMARY) {
            BuildMenu.chooseBuild();
            BuildMenu.build();
            BuildMenu.allFalse();
            Menu.main();
            Navi.navi();
            Laden.chooseFile();
            Speichern.getText();
        }
        
        // Rechte Maustaste
        if (e.getButton() == MouseButton.SECONDARY) {
            BuildMenu.setPosition(CreateCross.getxCross(), CreateCross.getyCross());
            if (Gamestate.state == Gamestate_e.ingame) {
                Buildstate.state = Buildstate_e.buildMenu;
            }
        }
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        MousePressed.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        MousePressed.y = y;
    }

    public static int getxOffset() {
        return xOffset;
    }

    public static void setxOffset(int xOffset) {
        MousePressed.xOffset = xOffset;
    }

    public static int getyOffset() {
        return yOffset;
    }

    public static void setyOffset(int yOffset) {
        MousePressed.yOffset = yOffset;
    }

}
