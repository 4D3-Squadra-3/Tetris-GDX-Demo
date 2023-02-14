package com.squadra3.tetris.tetromino.block;

import com.squadra3.tetris.field.Cell;
import com.squadra3.tetris.field.Grid;

public class BlockCollision {
    static boolean[] collision = {
        false,  // RIGHT
        false,  // LEFT
        false   // DOWN
    };  // Non mi serve conoscere le collisioni sopra

    private static void reset() {
        for (int i = 0; i < collision.length; i++) {
            collision[i] = false;
        }
    }

    public static boolean[] checkCollision(Block b, Grid g) {
        reset();
        if (b.getX() >= 9) collision[0] = true;
        if (b.getX() == 0) collision[1] = true;
        if (b.getY() == 0) collision[2] = true;

        Cell[] surrounding = {
            g.getCell(b.getX() + 1, b.getY()),  // RIGHT
            g.getCell(b.getX() - 1, b.getY()),  // LEFT
            g.getCell(b.getX(), b.getY() - 1)   // DOWN
        };
        for (Cell c : surrounding) if (c == null) return collision; // Se getCell() ritorna null esci dalla funzione
        for (int i = 0; i < surrounding.length; i++)
            if (surrounding[i].isOccupied() && surrounding[i].getID() != b.id) collision[i] = true;

        return collision;
    }
}
