package com.squadra3.tetris.tetromino.block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Block implements Disposable {  // Parte di Tetromino
    protected Texture txt;
    protected Color color;

    @Override
    public void dispose() {
        txt.dispose();
    }
}
