package com.squadra3.tetris.tetromino;

import java.util.Random;

public class Randomizer {
    Shape[] shapes = {
        Shape.OPIECE,
        Shape.IPIECE,
        Shape.JPIECE,
        Shape.LPIECE,
        Shape.TPIECE,
        Shape.SPIECE,
        Shape.ZPIECE
    };

    public Shape getRandomShape() {
        int value = new Random().nextInt(6);

        return shapes[value];
    }

}
