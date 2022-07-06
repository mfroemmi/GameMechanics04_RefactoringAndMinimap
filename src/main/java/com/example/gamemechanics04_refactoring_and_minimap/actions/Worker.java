package com.example.gamemechanics04_refactoring_and_minimap.actions;

public class Worker {

    /**
     * @param cx the cat's X coordinate
     * @param cy the cat's Y coordinate
     * @param mx the mouse's X coordinate
     * @param my the mouse's Y coordinate
     * @param xInkrement und param yInkrement zum zeichnen der Worker
     */
    private int cx, cy, mx, my, cxTemp, cyTemp;
    private double xInkrement, yInkrement;
    private String dirString;

    public Worker(int cx, int cy, int mx, int my, int cxTemp, int cyTemp, double x, double y) {
        this.cx = cx;
        this.cy = cy;
        this.mx = mx;
        this.my = my;
        this.cxTemp = cxTemp;
        this.cyTemp = cyTemp;
        this.xInkrement = x;
        this.yInkrement = y;
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public int getMx() {
        return mx;
    }

    public void setMx(int mx) {
        this.mx = mx;
    }

    public int getMy() {
        return my;
    }

    public void setMy(int my) {
        this.my = my;
    }

    public int getCxTemp() {
        return cxTemp;
    }

    public void setCxTemp(int cxTemp) {
        this.cxTemp = cxTemp;
    }

    public int getCyTemp() {
        return cyTemp;
    }

    public void setCyTemp(int cyTemp) {
        this.cyTemp = cyTemp;
    }

    public String getDirString() {
        return dirString;
    }

    public void setDirString(String dir) {
        this.dirString = dir;
    }

    public double getxInkrement() {
        return xInkrement;
    }

    public void setxInkrement(double x) {
        this.xInkrement = x;
    }

    public double getyInkrement() {
        return yInkrement;
    }

    public void setyInkrement(double y) {
        this.yInkrement = y;
    }

}
