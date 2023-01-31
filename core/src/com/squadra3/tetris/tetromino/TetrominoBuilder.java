package com.squadra3.tetris.tetromino;

import com.squadra3.tetris.tool.Builder;

// Costruttore Tetromino
public class TetrominoBuilder implements Builder<Tetromino> {

    private Tetromino toBuild;

    @Override
    public Tetromino build() {
        return toBuild;
    }

    @Override
    public void reset() {
        toBuild = new Tetromino();
    }
    
}
