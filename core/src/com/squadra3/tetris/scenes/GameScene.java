package com.squadra3.tetris.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.squadra3.tetris.global.Constants;
import com.squadra3.tetris.global.Variables;
import com.squadra3.tetris.tetromino.Shape;
import com.squadra3.tetris.tetromino.Tetromino;
import com.squadra3.tetris.tetromino.TetrominoBuilder;

// TODO Griglia di gioco
public class GameScene implements Scene {
    Camera camera;
    Viewport viewport;

    // TODO Creare pool di tetromini
    Tetromino t;

    public GameScene() {
        this.create();
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIN_WIDTH, Constants.WIN_HEIGHT, this.camera);

        // TODO Randomizzare la forma
        t = new TetrominoBuilder().reset().setShape(Shape.ZPIECE).setCoords(5, 15).setID(0).build();
        t.create();

        // Input
        initInput();
    }

    @Override
    public void render() {
        camera.update();            // Aggiorna la fotocamera di gioco ogni frame
        Variables.gameGrid.reset(); // Pulisce lo stato della griglia di gioco ogni frame

        // Pulisce lo schermo con un colore grigio
        // TODO Creare sfondo
        Gdx.gl.glClearColor(0.05f, 0.05f, 0.05f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO Creare pool di tetromini
        t.render(camera);
    }

    @Override
    public void dispose() {
        
    }

    // Inizializzazione input
    private void initInput() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                switch (keycode) {
                    case Input.Keys.LEFT:
                        if (!t.collidingLeft(Variables.gameGrid))    
                            t.setX(t.getX() - 1);
                    break;
                    case Input.Keys.RIGHT:
                        if (!t.collidingRight(Variables.gameGrid))
                            t.setX(t.getX() + 1);
                    break;
                    case Input.Keys.DOWN:
                        if (!t.collidingDown(Variables.gameGrid))
                            t.setY(t.getY() - 1);
                    break;
                    case Input.Keys.SPACE:
                        //t.setY(0);
                        // TODO Bounds
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