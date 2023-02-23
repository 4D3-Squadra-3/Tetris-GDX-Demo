package com.squadra3.tetris.tetromino;

import java.util.Random;

public class Randomizer {
    Shape[] shapes = Shape.values();

    public Shape getRandomShape() {
        int value = new Random().nextInt(7);

        return shapes[value];
    }

}
