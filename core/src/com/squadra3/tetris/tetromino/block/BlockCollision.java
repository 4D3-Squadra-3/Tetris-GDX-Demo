package com.squadra3.tetris.tetromino.block;

public class BlockCollision {
    static boolean[] collision = {
        false,  // RIGHT
        false,  // LEFT
        false   // DOWN
    };  // Non mi serve conoscere le collisioni sopra

    private static void reset() {
        for (int i = 0; i < collision.length; i++) {
            collision[i] = false;
        }
    }

    public static boolean[] checkCollision(Block b) {
        reset();
        if (b.getX() >= 9) collision[0] = true;
        if (b.getX() == 0) collision[1] = true;
        if (b.getY() == 0) collision[2] = true;

        return collision;
    }
}
