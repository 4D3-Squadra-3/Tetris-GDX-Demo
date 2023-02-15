package com.squadra3.tetris.field;

import com.squadra3.tetris.global.Constants;

public class Grid { // Griglia di gioco
    Cell[][] cells = new Cell[Constants.GRID_WIDTH][Constants.GRID_HEIGHT];

    public Grid() {
            for (int i = 0; i < Constants.GRID_WIDTH; i++) {
                for (int j = 0; j < Constants.GRID_HEIGHT; j++) {
                    cells[i][j] = new Cell();
                    cells[i][j].setOccupied(false);
                    cells[i][j].setID(0);
                }
            }
    }

    public void reset() {   // Resetta lo stato della griglia, in modo da liberare le celle che non contengono più un blocco
        for (int i = 0; i < Constants.GRID_WIDTH; i++) {
            for (int j = 0; j < Constants.GRID_HEIGHT; j++) {
                cells[i][j].setOccupied(false);
                cells[i][j].setID(0);
            }
        }
    }

    public Cell getCell(int x, int y) { // Ottieni cella date delle coordinate
        if (x >= 0 && x <= 9 && y >= 0 && y <= 19) return cells[x][y];
        else return null;
    }
    public boolean isLineFull(int lineNo) { // Controlla se una specifica riga è piena
        int occCount = 0;

        for (int i = 0; i < Constants.GRID_WIDTH; i++) {
            if(cells[i][lineNo].isOccupied()) occCount++;
        }

        return occCount == Constants.GRID_WIDTH;
    }

    public void occupy(int x, int y, int id) {  // Occupa una cella con l'ID di un blocco
        cells[x][y].setID(id);
        cells[x][y].setOccupied(true);
    }
}
