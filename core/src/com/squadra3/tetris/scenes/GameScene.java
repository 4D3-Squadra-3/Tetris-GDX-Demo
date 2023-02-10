package com.squadra3.tetris.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.squadra3.tetris.global.Constants;
import com.squadra3.tetris.tetromino.Shape;
import com.squadra3.tetris.tetromino.Tetromino;
import com.squadra3.tetris.tetromino.TetrominoBuilder;

// TODO Griglia di gioco
public class GameScene implements Disposable {
    Camera camera;
    Viewport viewport;

    // TODO Creare pool di tetromini
    Tetromino t;

    public GameScene() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIN_WIDTH, Constants.WIN_HEIGHT, this.camera);

        // TODO Randomizzare la forma
        t = new TetrominoBuilder().reset().setShape(Shape.IPIECE).setCoords(5, 15).build();
        t.create();

        // Input
        initInput();
    }

    public void render() {
        camera.update();

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
                        t.setX(t.getX() - 1);
                    break;
                    case Input.Keys.RIGHT:
                        t.setX(t.getX() + 1);
                    break;
                    case Input.Keys.DOWN:
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