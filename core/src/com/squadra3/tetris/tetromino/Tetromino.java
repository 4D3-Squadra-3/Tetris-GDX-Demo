package com.squadra3.tetris.tetromino;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Disposable;
import com.squadra3.tetris.tetromino.block.Block;
import com.squadra3.tetris.tetromino.block.BlockBuilder;
import com.squadra3.tetris.tetromino.block.Color;

// Definizione iniziale di cos'è un Tetromino
// TODO Implementare Super Rotation System
public class Tetromino implements Disposable {
    protected List<Block> body; // Lista di blocchi utilizzata come corpo del Tetromino
    protected Shape shape;

    protected int x, y;

    public void create() {
        states.add(RotationStates.HORIZONTAL_1);
        states.add(RotationStates.HORIZONTAL_2);
        states.add(RotationStates.VERTICAL_1);
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
            body.add(new BlockBuilder().reset().setColor(drawColor).build());
            //body.get(i).getBatch().setProjectionMatrix(camera.combined);
        }
    }

    public void render(Camera camera) {
        body.get(0).render(x, y);   // Primo blocco centrale
        
        // A seconda della forma, cambia come vengono disegnati i tetromini
        switch (shape) {
            case IPIECE:
                // I
                // TODO Finire rotazione
                switch (states.get(rotationIndex)) {
                    case HORIZONTAL_1:
                        body.get(1).render(x-1, y);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x+2, y);
                    break;

                    case HORIZONTAL_2:
                        body.get(1).render(x, y-1);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x, y+2);
                    break;

                    case VERTICAL_1:
                        body.get(1).render(x-1, y);
                        body.get(2).render(x+1, y);
                        body.get(3).render(x+2, y);
                    break;

                    case VERTICAL_2:
                        body.get(1).render(x, y-1);
                        body.get(2).render(x, y+1);
                        body.get(3).render(x, y+2);
                    break;
                }
                break;
            case JPIECE:
                // J
                switch (states.get(rotationIndex)) {
                    case HORIZONTAL_1:
                    body.get(1).render(x-1, y);
                    body.get(2).render(x+1, y);
                    body.get(3).render(x-1, y+1); 
                    break;

                    case HORIZONTAL_2:
                    body.get(1).render(x-1, y);
                    body.get(2).render(x+1, y);
                    body.get(3).render(x-1, y+1); 
                    break;

                    case VERTICAL_1:
                    body.get(1).render(x-1, y);
                    body.get(2).render(x+1, y);
                    body.get(3).render(x-1, y+1); 
                    break;

                    case VERTICAL_2:
                    body.get(1).render(x-1, y);
                    body.get(2).render(x+1, y);
                    body.get(3).render(x-1, y+1); 
                    break;
                }             
                break;
            case LPIECE:
                // L
                body.get(1).render(x-1, y);
                body.get(2).render(x+1, y);
                body.get(3).render(x+1, y+1);
                break;
            case OPIECE:
                // O
                body.get(1).render(x+1, y+1);
                body.get(2).render(x, y+1);
                body.get(3).render(x+1, y);
                break;
            case ZPIECE:
                // Z
                body.get(1).render(x+1, y);
                body.get(2).render(x, y+1);
                body.get(3).render(x-1, y+1);
                break;
            case SPIECE:
                // S
                body.get(1).render(x-1, y);
                body.get(2).render(x, y+1);
                body.get(3).render(x+1, y+1);       
                break;
            case TPIECE:
                // T
                body.get(1).render(x, y+1);
                body.get(2).render(x+1, y);
                body.get(3).render(x-1, y);
                break;
        }
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


    // Rotazione
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
        HORIZONTAL_2,
        VERTICAL_1,
        VERTICAL_2
    }
}
