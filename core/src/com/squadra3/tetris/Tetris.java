package com.squadra3.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

// TODO Implementare una vera e propria scena
public class Tetris extends ApplicationAdapter {

	Camera camera;
	Viewport v;

	@Override
	public void create () {		// Principalmente usato per caricare gli asset

		camera = new OrthographicCamera();
		
		v = new FitViewport(400, 800, camera);
	}

	@Override
	public void render () {
		camera.update();

		Gdx.gl.glClearColor(0.05f, 0.05f, 0.05f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@Override
	public void dispose () {
	}
}
