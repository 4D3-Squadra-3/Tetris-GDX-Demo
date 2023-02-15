package com.squadra3.tetris.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.squadra3.tetris.global.Constants;

public class MainMenu implements Disposable {

    Camera camera;
    Viewport viewport;
    
    Label.LabelStyle style = new LabelStyle();
    Label label = new Label("Premi un pulsante per iniziare", style);

    public MainMenu() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIN_WIDTH, Constants.WIN_HEIGHT, this.camera);
    }

    private void initInput() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                boolean press = false;

                if (keycode == Input.Keys.ANY_KEY) {
                    press = true;
                }
                return press;
            }
        });
    }

    @Override
    public void dispose() {

    }
}