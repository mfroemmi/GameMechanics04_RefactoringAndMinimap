package com.example.gamemechanics04_refactoring_and_minimap.draw;

import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateRaster;
import com.example.gamemechanics04_refactoring_and_minimap.chars.CreateWorker;
import com.example.gamemechanics04_refactoring_and_minimap.gui.Image_Loader;
import javafx.scene.canvas.GraphicsContext;

public class DrawWorker extends DrawMain {

    public static void moveResource(GraphicsContext g) {
        for (int i = 0; i < CreateWorker.worker.size(); i++) {
            if (CreateWorker.worker.get(i).getDirString() == "DOWN") {
                g.drawImage(Image_Loader.workerDown, CreateRaster.factorRaster + (CreateRaster.factorRaster * CreateWorker.worker.get(i).getxInkrement()) - 30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * CreateWorker.worker.get(i).getyInkrement()) - 30 + getyOffset(), 60, 60);
            }
            if (CreateWorker.worker.get(i).getDirString() == "LEFT") {
                g.drawImage(Image_Loader.workerLeft, CreateRaster.factorRaster + (CreateRaster.factorRaster * CreateWorker.worker.get(i).getxInkrement()) - 30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * CreateWorker.worker.get(i).getyInkrement()) - 30 + getyOffset(), 60, 60);
            }
            if (CreateWorker.worker.get(i).getDirString() == "RIGHT") {
                g.drawImage(Image_Loader.workerRight, CreateRaster.factorRaster + (CreateRaster.factorRaster * CreateWorker.worker.get(i).getxInkrement()) - 30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * CreateWorker.worker.get(i).getyInkrement()) - 30 + getyOffset(), 60, 60);
            }
            if (CreateWorker.worker.get(i).getDirString() == "UP") {
                g.drawImage(Image_Loader.workerUp, CreateRaster.factorRaster + (CreateRaster.factorRaster * CreateWorker.worker.get(i).getxInkrement()) - 30 + getxOffset(), (CreateRaster.factorRaster * 2) + (CreateRaster.factorRaster * CreateWorker.worker.get(i).getyInkrement()) - 30 + getyOffset(), 60, 60);
            }
        }

    }

}
