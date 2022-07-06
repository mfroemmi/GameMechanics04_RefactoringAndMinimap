package com.example.gamemechanics04_refactoring_and_minimap.actions;

import com.example.gamemechanics04_refactoring_and_minimap.draw.DrawMain;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Gamestate_e;

public class Offset {
    
    public static void Offset() {        
        if (Gamestate.state == Gamestate_e.ingame) {
            DrawMain.setxOffset(MousePressed.getxOffset() - (MousePressed.getX() - MouseDragged.getX()));
            DrawMain.setyOffset(MousePressed.getyOffset() - (MousePressed.getY() - MouseDragged.getY()));
        }        
    }
    
}
