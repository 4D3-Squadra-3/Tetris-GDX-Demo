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
    public TetrominoBuilder reset() {
        toBuild = new Tetromino();
        return this;
    }
    
    public TetrominoBuilder setShape(Shape shape) {
        toBuild.shape = shape;
        return this;
    }

    public TetrominoBuilder setCoords(int x, int y) {
        toBuild.x = x;
        toBuild.y = y;
        return this;
    }
}
