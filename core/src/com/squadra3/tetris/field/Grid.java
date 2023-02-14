package com.squadra3.tetris.field;

import com.squadra3.tetris.global.Constants;

public class Grid {
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

    public Cell getCell(int x, int y) {
        if (x >= 0 && x <= 9 && y >= 0 && y <= 19) return cells[x][y];
        else return null;
    }
    public boolean isLineFull(int lineNo) {
        int occCount = 0;

        for (int i = 0; i < Constants.GRID_WIDTH; i++) {
            if(cells[i][lineNo].isOccupied()) occCount++;
        }

        return occCount == Constants.GRID_WIDTH;
    }

    public void occupy(int x, int y, int id) {
        cells[x][y].setID(id);
        cells[x][y].setOccupied(true);
    }
}
