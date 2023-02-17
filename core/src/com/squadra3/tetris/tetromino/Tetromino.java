package com.squadra3.tetris.tetromino;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Disposable;
import com.squadra3.tetris.field.Grid;
import com.squadra3.tetris.tetromino.block.Block;
import com.squadra3.tetris.tetromino.block.BlockBuilder;
import com.squadra3.tetris.tetromino.block.BlockCollision;
import com.squadra3.tetris.tetromino.block.Color;

// Definizione iniziale di cos'è un Tetromino
// TODO Implementare Super Rotation System
public class Tetromino implements Disposable {
    protected List<Block> body; // Lista di blocchi utilizzata come corpo del Tetromino
    protected Shape shape;

    protected int x, y;
    protected int id;

    private boolean frozen = false;

    public void create() {
        states.add(RotationStates.HORIZONTAL_1);
        states.add(RotationStates.VERTICAL_1);
        states.add(RotationStates.HORIZONTAL_2);
        states.add(RotationStates.VERTICAL_2);
        

        body = new ArrayList<Block>();

        Color drawColor;

        // A seconda della forma, cambia il colore del tetromino
        switch (shape) {
            case IPIECE:
                drawColor = Color.CYAN;
                break;
            case JPIECE:
                drawColor = Color.BLUE;
                break;
            case LPIECE:
                drawColor = Color.ORANGE;
                break;
            case OPIECE:
                drawColor = Color.YELLOW;
                break;
            case SPIECE:
                drawColor = Color.GREEN;
                break;
            case TPIECE:
                drawColor = Color.PURPLE;
                break;
            case ZPIECE:
                drawColor = Color.RED;
                break;
            default:    // drawColor deve essere inizializzata
                drawColor = null;
                break;
            
        }

        for (int i = 0; i < 4; i++) { // Inizializza il corpo del tetromino
            body.add(new BlockBuilder().reset().setColor(drawColor).setID(id).build());
            //body.get(i).getBatch().setProjectionMatrix(camera.combined);
        }
    }

    public void render(Camera camera) {
        // A seconda della forma, cambia come vengono disegnati i tetromini
        switch (shape) {
            case IPIECE:
                // I
                switch (states.get(rotationIndex)) {
                    case HORIZONTAL_1:
                        body.get(0).render(x, y);
                        body.get(1).render(x-1, y);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x+2, y);
                    break;

                    case VERTICAL_1:
                        body.get(0).render(x, y);   
                        body.get(1).render(x, y-1);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x, y+2);
                    break;

                    case HORIZONTAL_2:
                        body.get(0).render(x, y+1);
                        body.get(1).render(x-1, y+1);
                        body.get(2).render(x+1, y+1);
                        body.get(3).render(x+2, y+1);
                    break;

                    case VERTICAL_2:
                        body.get(0).render(x+1, y);
                        body.get(1).render(x+1, y-1);
                        body.get(2).render(x+1, y+1);
                        body.get(3).render(x+1, y+2);
                    break;
                }
                break;
            case JPIECE:
                // J
                body.get(0).render(x, y);
                switch (states.get(rotationIndex)) {
                    case HORIZONTAL_1:
                        body.get(1).render(x-1, y);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x-1, y+1); 
                    break;

                    case VERTICAL_1:
                        body.get(1).render(x, y+1);
                        body.get(2).render(x, y-1);
                        body.get(3).render(x+1, y+1);
                    break;

                    case HORIZONTAL_2:
                        body.get(1).render(x-1, y);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x+1, y-1); 
                    break;

                    case VERTICAL_2:
                        body.get(1).render(x, y+1);
                        body.get(2).render(x, y-1);
                        body.get(3).render(x-1, y-1);
                    break;
                }             
                break;
            case LPIECE:
                // L
                body.get(0).render(x, y);
                switch (states.get(rotationIndex)) {
                    case HORIZONTAL_1:
                        body.get(1).render(x-1, y);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x+1, y+1);
                    break;

                    case VERTICAL_1:
                        body.get(1).render(x, y+1);
                        body.get(2).render(x, y-1);
                        body.get(3).render(x+1, y-1);
                    break;

                    case HORIZONTAL_2:
                        body.get(1).render(x+1, y);
                        body.get(2).render(x-1, y);
                        body.get(3).render(x-1, y-1);
                    break;

                    case VERTICAL_2:
                        body.get(1).render(x, y+1);
                        body.get(2).render(x, y-1);
                        body.get(3).render(x-1, y+1);
                    break;
                } 
                break;
            case OPIECE:
                // O
                body.get(0).render(x, y);
                body.get(1).render(x+1, y+1);
                body.get(2).render(x, y+1);
                body.get(3).render(x+1, y);
                break;
            case ZPIECE:
                // Z
                body.get(0).render(x, y);
                switch (states.get(rotationIndex)) {
                    case HORIZONTAL_1:
                        body.get(1).render(x+1, y+1);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x+1, y);
                    break;

                    case VERTICAL_1:
                        body.get(1).render(x+1, y+1);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x+1, y);
                    break;

                    case HORIZONTAL_2:
                        body.get(1).render(x+1, y+1);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x+1, y);
                    break;

                    case VERTICAL_2:
                        body.get(1).render(x+1, y+1);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x+1, y);
                    break;
                }
                break;
            case SPIECE:
                // S
                body.get(0).render(x, y);
                switch (states.get(rotationIndex)) {
                    case HORIZONTAL_1:
                        body.get(1).render(x-1, y);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x+1, y+1);
                    break;

                    case VERTICAL_1:
                        body.get(1).render(x, y+1);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x+1, y-1);
                    break;

                    case HORIZONTAL_2:
                        body.get(1).render(x-1, y);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x+1, y+1);
                    break;

                    case VERTICAL_2:
                        body.get(1).render(x, y+1);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x+1, y-1);
                    break;
                }       
                break;
            case TPIECE:
                // T
                body.get(0).render(x, y);
                switch (states.get(rotationIndex)) {
                    case HORIZONTAL_1:
                        body.get(1).render(x, y+1);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x-1, y);
                    break;

                    case VERTICAL_1:
                        body.get(1).render(x, y+1);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x, y-1);
                    break;

                    case HORIZONTAL_2:
                        body.get(1).render(x+1, y);
                        body.get(2).render(x-1, y);
                        body.get(3).render(x, y-1);
                    break;

                    case VERTICAL_2:
                        body.get(1).render(x-1, y);
                        body.get(2).render(x, y-1);
                        body.get(3).render(x, y+1);
                    break;
                } 
                break;
        }
    }

    public int getID() {
        return id;
    }

    @Override
    public void dispose() { // Elimina il Tetromino
        body.forEach(new Consumer<Block>() {
            @Override
            public void accept(Block t) {
                t.dispose();
            }
        });
    }

    // COORDINATE
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    // COLLISIONI
    public boolean collidingRight(Grid g) {
        boolean ret = false;

        for (int i = 0; i < body.size(); i++) {
            ret = BlockCollision.checkCollision(body.get(i), g)[0];
            if (ret == true) break;
        }

        return ret;
    }
    public boolean collidingLeft(Grid g) {
        boolean ret = false;

        for (int i = 0; i < body.size(); i++) {
            ret = BlockCollision.checkCollision(body.get(i), g)[1];
            if (ret == true) break;
        }

        return ret;
    }
    public boolean collidingDown(Grid g) {
        boolean ret = false;

        for (int i = 0; i < body.size(); i++) {
            ret = BlockCollision.checkCollision(body.get(i), g)[2];
            //System.out.println(ret);
            if (ret == true) break;
        }

        return ret;
    }
    
    // ROTAZIONE
    private List<RotationStates> states = new ArrayList<RotationStates>();
    private int rotationIndex = 0;
    public void rotate() {
        rotationIndex++;

        if (rotationIndex > 3) {
            rotationIndex = 0;
        }
    }

    private enum RotationStates {
        HORIZONTAL_1,
        VERTICAL_1,
        HORIZONTAL_2,
        VERTICAL_2
    }

    // FREEZE
    public void freeze() {
        frozen = true;
    }
    public void unfreeze() {
        frozen = false;
    }
    public boolean isFrozen() {
        return frozen;
    }
}
