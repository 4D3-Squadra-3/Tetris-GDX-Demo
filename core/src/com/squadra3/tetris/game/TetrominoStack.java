package com.squadra3.tetris.game;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Disposable;
import com.squadra3.tetris.field.Grid;
import com.squadra3.tetris.global.Constants;
import com.squadra3.tetris.global.Variables;
import com.squadra3.tetris.tetromino.Tetromino;

public class TetrominoStack implements Disposable {
    List<Tetromino> stack = new ArrayList<Tetromino>();
    boolean empty = true;
    
    public void renderAll() {
        if (!empty) {
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) != null) stack.get(i).render();
            }
        }
    }

    public Tetromino getByID(int id) {
        Tetromino ret = null;

        if (!empty) {
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i).getID() == id) ret = stack.get(i);
            }
        }

        return ret;
    }

    public void add(Tetromino toAdd) {
        empty = false;
        stack.add(toAdd);
    }

    public void removeInLine(int line) {
        for (int i = 0; i < stack.size(); i++) {
            for (int j = 0; j < Constants.GRID_WIDTH; j++) {
                stack.get(i).removeBlock(j, line);
            }
        }
    }

    public void pushDown() {
        stack.forEach(new Consumer<Tetromino>() {
            @Override
            public void accept(Tetromino t) {
                t.moveDown();
            }
        });
    }

    @Override
    public void dispose() {
        stack.forEach(new Consumer<Tetromino>() {
            @Override
            public void accept(Tetromino t) {
                t.dispose();
            }
        });
    }
}
