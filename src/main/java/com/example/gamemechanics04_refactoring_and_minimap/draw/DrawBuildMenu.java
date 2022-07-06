package com.example.gamemechanics04_refactoring_and_minimap.draw;

import com.example.gamemechanics04_refactoring_and_minimap.actions.BuildMenu;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateCross;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateRaster;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate;
import com.example.gamemechanics04_refactoring_and_minimap.gamestate.Buildstate_e;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Image_Loader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import com.example.gamemechanics04_refactoring_and_minimap.var.BuildingResources;

public class DrawBuildMenu extends DrawMain {

    public static String colorText = "WHITE", holzVal, steinVal, nameVal;

    public static void buildMenu(GraphicsContext g) {
        // Menü-Hintergund
        g.setFill(Color.rgb(134, 89, 45, 0.6));
        g.fillRect(BuildMenu.getX(), BuildMenu.getY(), 210, 300);
        g.setStroke(Color.valueOf(colorBorder));
        g.setLineWidth(3);
        g.strokeRect(BuildMenu.getX(), BuildMenu.getY(), 210, 300);

        // Gebäude
        g.drawImage(Image_Loader.lumberjack, BuildMenu.getX() + 30, BuildMenu.getY() + 30, 60, 60);
        g.drawImage(Image_Loader.stonepit, BuildMenu.getX() + 120, BuildMenu.getY() + 30, 60, 60);
    }

    public static void hoverBuild(GraphicsContext g) {
        g.setFont(new Font("com/example/gamemechanics04_refactoring_and_minimap/calibri.ttf", 15));
        g.setTextAlign(TextAlignment.LEFT);
        if (BuildMenu.getChooseBuilding() == "lumberjack") {
            holzVal = BuildingResources.BuildingResourcesArray[0][1];
            steinVal = BuildingResources.BuildingResourcesArray[0][2];
            nameVal = BuildingResources.BuildingResourcesArray[0][0];

        }
        if (BuildMenu.getChooseBuilding() == "stonepit") {
            holzVal = BuildingResources.BuildingResourcesArray[1][1];
            steinVal = BuildingResources.BuildingResourcesArray[1][2];
            nameVal = BuildingResources.BuildingResourcesArray[1][0];
        }
        //Holz
        BuildMenu.checkResources("Holz", Integer.parseInt(holzVal));
        g.setFill(Color.valueOf(colorText));
        g.fillText("("+holzVal+")", 165, 40);
        //Stein
        BuildMenu.checkResources("Stein", Integer.parseInt(steinVal));
        g.setFill(Color.valueOf(colorText));
        g.fillText("("+steinVal+")", 265, 40);
        //Name
        g.setFill(Color.WHITE);
        g.fillText(nameVal, 300, 40);
    }
    
    public static void chooseBuilding(GraphicsContext g) {
        if (Buildstate.state == Buildstate_e.chooseBuild || Buildstate.state == Buildstate_e.setBuild) {
            g.setStroke(Color.rgb(255, 255, 255, 0.6));
            g.strokeRect(CreateCross.getxCross() - CreateRaster.factorRaster * 3 / 2 + getxOffset(), CreateCross.getyCross() - CreateRaster.factorRaster * 3 / 2 + getyOffset(), CreateRaster.factorRaster * 3, CreateRaster.factorRaster * 3);
            g.setFill(Color.rgb(255, 255, 255, 0.3));
            g.fillRect(CreateCross.getxCross() - CreateRaster.factorRaster * 3 / 2 + getxOffset(), CreateCross.getyCross() - CreateRaster.factorRaster * 3 / 2 + getyOffset(), CreateRaster.factorRaster * 3, CreateRaster.factorRaster * 3);
        }

        if (BuildMenu.getChooseBuilding() == "lumberjack") {
            g.drawImage(Image_Loader.lumberjack, CreateCross.getxCross() - 30 + getxOffset(), CreateCross.getyCross() - 30 + getyOffset(), 60, 60);
        }
        if (BuildMenu.getChooseBuilding() == "stonepit") {
            g.drawImage(Image_Loader.stonepit, CreateCross.getxCross() - 30 + getxOffset(), CreateCross.getyCross() - 30 + getyOffset(), 60, 60);
        }
    }

}
