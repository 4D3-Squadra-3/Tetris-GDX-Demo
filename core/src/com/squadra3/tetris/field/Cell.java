package com.squadra3.tetris.field;

public class Cell {
    private int id;
    private boolean occupied;

    public void setID(int id) {
        this.id = id;
    }
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getID() {
        return this.id;
    }
    public boolean isOccupied() {
        return this.occupied;
    }
}
