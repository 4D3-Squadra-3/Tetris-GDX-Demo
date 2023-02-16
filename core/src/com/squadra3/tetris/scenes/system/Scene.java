package com.squadra3.tetris.scenes.system;

import com.badlogic.gdx.utils.Disposable;

public interface Scene extends Disposable {
    public void create();
    public void render();
}
