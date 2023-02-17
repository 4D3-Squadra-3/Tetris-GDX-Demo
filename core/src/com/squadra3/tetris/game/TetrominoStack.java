package com.squadra3.tetris.game;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.graphics.Camera;
import com.squadra3.tetris.tetromino.Tetromino;

public class TetrominoStack {
    List<Tetromino> stack = new ArrayList<Tetromino>();
    boolean empty = true;
    
    public void renderAll(Camera cam) {
        if (!empty) {
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) != null) stack.get(i).render(cam);
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
}
