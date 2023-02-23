package com.squadra3.tetris.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.squadra3.tetris.global.Constants;
import com.squadra3.tetris.scenes.system.Scene;
import com.squadra3.tetris.scenes.system.SceneSystem;

public class MainMenu implements Scene {
    FreeTypeFontGenerator fgen = new FreeTypeFontGenerator(Gdx.files.internal("title-font.ttf"));
    FreeTypeFontParameter fparam = new FreeTypeFontParameter();
    BitmapFont titleFont; // Output del generatore freetype

    Camera camera;
    Viewport viewport;
    
    Label.LabelStyle style = new LabelStyle();
    Label label;

    SpriteBatch batch = new SpriteBatch();

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIN_WIDTH, Constants.WIN_HEIGHT, this.camera);

        // FONT
        fparam.size = 10;
        titleFont = fgen.generateFont(fparam);

        style.font = titleFont;

        // Creazione label
        label = new Label("Premi un pulsante per iniziare...", style);
        label.setPosition(0, Constants.WIN_HEIGHT/2);
        label.setSize(Constants.WIN_WIDTH,Constants.WIN_WIDTH/10);
        label.setAlignment(Align.center);
    }

    @Override
    public void render() {
        camera.update();

        // SFONDO
        Gdx.gl.glClearColor(0.05f, 0.05f, 0.05f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Cambia scena quando viene premuto un qualsiasi pulsante
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) SceneSystem.setActive(1);

        batch.begin();

        // Disegna il label
        label.draw(batch, 1);
        
        batch.end();
    }

    @Override
    public void dispose() {
        titleFont.dispose();
        fgen.dispose();
        batch.dispose();
    }
}