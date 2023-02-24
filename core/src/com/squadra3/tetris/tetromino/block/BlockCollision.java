package com.squadra3.tetris.tetromino.block;

import com.squadra3.tetris.field.Cell;
import com.squadra3.tetris.field.Grid;

// Gestore collisioni di un singolo blocco, si interfaccia con la griglia di gioco per dedurre le collisioni con il bordo e con gli altri blocchi
public class BlockCollision {
    boolean[] collision = {  // Collisioni di un blocco
        false,  // RIGHT
        false,  // LEFT
        false   // DOWN
    };  // Non mi serve conoscere le collisioni sopra

    private void reset() {   // Resetta le collisioni in tutte le direzioni
        for (int i = 0; i < collision.length; i++) {
            collision[i] = false;
        }
    }

    public boolean[] checkCollision(Block b, Grid g) {
        reset();    // Pulisci la tavola di collisione

        if (b != null) {
            // Controllo collisioni bordo
            if (b.getX() >= 9) collision[0] = true;
            if (b.getX() == 0) collision[1] = true;
            if (b.getY() == 0) collision[2] = true;

            Cell[] surrounding = {  // Celle circostanti al blocco
                g.getCell(b.getX() + 1, b.getY()),  // RIGHT
                g.getCell(b.getX() - 1, b.getY()),  // LEFT
                g.getCell(b.getX(), b.getY() - 1)   // DOWN
            };
            //for (Cell c : surrounding) if (c == null) return collision; // Se getCell() ritorna null esci dalla funzione, questo per evitare di andare fuori dai bounds della griglia
            for (int i = 0; i < surrounding.length; i++) {
                if (surrounding[i] != null && surrounding[i].isOccupied() && surrounding[i].getID() != b.id) collision[i] = true; // Se la cella circostante è occupata e ha ID diverso da quelo del blocco controllato, conferma la collisione su un lato
                //System.out.println(surrounding[2].isOccupied());
            }
        }
        return collision;
    }
}
