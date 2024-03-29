package com.squadra3.tetris;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.squadra3.tetris.Tetris;
import com.squadra3.tetris.global.Constants;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(Constants.FRAMERATE);
		config.setTitle("Tetris GDX Demo");
		config.useVsync(true);
		config.setWindowedMode(400, 800);
		config.setResizable(false);
		new Lwjgl3Application(new Tetris(), config);
	}
}
