package com.squadra3.tetris.tetromino;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Disposable;
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

    public void create() {
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
        body.get(0).render(x, y);   // Primo blocco centrale
        
        // A seconda della forma, cambia come vengono disegnati i tetromini
        switch (shape) {
            case IPIECE:
                // I
                body.get(1).render(x-1, y);
                body.get(2).render(x+1, y);
                body.get(3).render(x+2, y);
                break;
            case JPIECE:
                // J
                body.get(1).render(x-1, y);
                body.get(2).render(x+1, y);
                body.get(3).render(x-1, y+1);                
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

    public boolean collidingRight() {
        boolean ret = false;

        for (int i = 0; i < body.size(); i++) {
            ret = BlockCollision.checkCollision(body.get(i))[0];
            if (ret == true) break;
        }

        return ret;
    }
    public boolean collidingLeft() {
        boolean ret = false;

        for (int i = 0; i < body.size(); i++) {
            ret = BlockCollision.checkCollision(body.get(i))[1];
            if (ret == true) break;
        }

        return ret;
    }
    public boolean collidingDown() {
        boolean ret = false;

        for (int i = 0; i < body.size(); i++) {
            ret = BlockCollision.checkCollision(body.get(i))[2];
            if (ret == true) break;
        }

        return ret;
    }

    public void rotate() {
        // TODO Implementare rotazione
    }
}
