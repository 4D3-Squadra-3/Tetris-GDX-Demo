package com.squadra3.tetris.field;

public class Cell { // Singola cella della griglia di gioco
    private int id;             // ID del blocco presente
    private boolean occupied;   // Stato della cella

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
