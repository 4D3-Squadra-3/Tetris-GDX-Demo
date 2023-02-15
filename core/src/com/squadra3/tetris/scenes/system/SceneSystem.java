package com.squadra3.tetris.scenes.system;

import java.util.ArrayList;
import java.util.List;

public class SceneSystem {
    static int sceneIndex = 0;
    static List<Scene> scenes = new ArrayList<Scene>();

    public static Scene getCurrentScene() {
        Scene ret = scenes.get(sceneIndex);
        
        if (ret == null) return null;
        
        return ret;
    }

    public static void addScene(Scene scene) {
        scenes.add(scene);
    }

    public static void setActive(int index) {
        if (scenes.get(index) == null) return;
        
        sceneIndex = index;
    }
}
