package com.squadra3.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.squadra3.tetris.scenes.GameScene;
import com.squadra3.tetris.scenes.MainMenu;
import com.squadra3.tetris.scenes.system.SceneSystem;

public class Tetris extends ApplicationAdapter {
	@Override
	public void create () {		// Carico le scene di gioco
		SceneSystem.addScene(new MainMenu());
		SceneSystem.addScene(new GameScene());

		SceneSystem.setActive(0);
	}

	@Override
	public void render () {
		SceneSystem.getCurrentScene().render();
	}
}
