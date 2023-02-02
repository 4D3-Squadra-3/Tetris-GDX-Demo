package com.squadra3.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.squadra3.tetris.scenes.GameScene;

public class Tetris extends ApplicationAdapter {
	GameScene scene;

	@Override
	public void create () {		// Principalmente usato per caricare gli asset
		scene = new GameScene();
	}

	@Override
	public void render () {
		scene.render();
	}
}
