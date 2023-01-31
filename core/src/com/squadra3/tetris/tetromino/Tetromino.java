package com.squadra3.tetris.tetromino;

import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.utils.Disposable;
import com.squadra3.tetris.tetromino.block.Block;

// Definizione iniziale di cos'è un Tetromino
public class Tetromino implements Disposable {
    protected List<Block> body; // Lista di blocchi utilizzata come corpo del Tetromino
    protected Shape shape;

    @Override
    public void dispose() { // Elimina il Tetromino
        body.forEach(new Consumer<Block>() {
            @Override
            public void accept(Block t) {
                t.dispose();
            }
        });
    }
}
