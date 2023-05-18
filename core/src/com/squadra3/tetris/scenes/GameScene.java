package com.squadra3.tetris.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.squadra3.tetris.field.Grid;
import com.squadra3.tetris.game.TetrominoStack;
import com.squadra3.tetris.global.Constants;
import com.squadra3.tetris.tetromino.Randomizer;
import com.squadra3.tetris.global.Variables;
import com.squadra3.tetris.scenes.system.Scene;
import com.squadra3.tetris.tetromino.Tetromino;
import com.squadra3.tetris.tetromino.TetrominoBuilder;

// TODO Griglia di gioco
public class GameScene implements Scene {
    Camera camera;
    Viewport viewport;

    Randomizer randomizer = new Randomizer();

    // TODO Creare pool di tetromini
    Tetromino t;                                            // Tetromino corrente
    TetrominoStack stack;                                   // Stack di tetromini

    int frameCounter = 0;
    int pieceCounter = 0;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIN_WIDTH, Constants.WIN_HEIGHT, this.camera);

        stack = new TetrominoStack();

        // TODO Randomizzare la forma
        t = new TetrominoBuilder().reset().setShape(randomizer.getRandomShape()).setCoords(5, 15).setID(pieceCounter).build();
        t.create();

        // Input
        initInput();
    }

    @Override
    public void render() {
        frameCounter++;

        Grid.getInstance().reset();

        camera.update();            // Aggiorna la fotocamera di gioco ogni frame

        // Pulisce lo schermo con un colore grigio
        // TODO Creare sfondo
        Gdx.gl.glClearColor(0.05f, 0.05f, 0.05f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO Creare pool di tetromini
        t.render();

        stack.renderAll();

        if (frameCounter % Constants.FRAMERATE == 0) {
            t.moveDown();

            stack.pushDown();

            if (t.collidingDown()) {
                pieceCounter++;

                for (int i = 0; i < Constants.GRID_HEIGHT; i++) {
                    if (Grid.getInstance().isLineFull(i)) {
                        for (int j = 0; j < Constants.GRID_WIDTH; j++) {
                            stack.removeInLine(i);
                            t.removeBlock(j, i);
                        }
                    }
                }
                //Grid.getInstance().reset(); // Pulisce lo stato della griglia di gioco

                stack.add(t);
                t = new TetrominoBuilder().reset().setShape(randomizer.getRandomShape()).setCoords(5, 15).setID(pieceCounter).build();
                t.create();
            }

            //Grid.getInstance().reset(); // Pulisce lo stato della griglia di gioco
        }
    }

    @Override
    public void dispose() {
        t.dispose();
        stack.dispose();
    }

    // Inizializzazione input
    private void initInput() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                switch (keycode) {
                    case Input.Keys.LEFT:
                        if (!t.collidingLeft())    
                            t.moveX(-1);
                    break;
                    case Input.Keys.RIGHT:
                        if (!t.collidingRight())
                            t.moveX(1);
                    break;
                    case Input.Keys.DOWN:
                        if (!t.collidingDown())
                            t.moveDown();
                    break;
                    case Input.Keys.UP:
                        t.rotate();
                    break;
                }

                return true;
            }
        });
    }
}