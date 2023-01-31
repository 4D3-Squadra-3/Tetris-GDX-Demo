package com.squadra3.tetris.tetromino.block;

import com.squadra3.tetris.tool.Builder;

// Costruttore blocco
public class BlockBuilder implements Builder<Block> {

    private Block toBuild;

    @Override
    public Block build() {
        return toBuild;
    }

    @Override
    public void reset() {
        toBuild = new Block();
    }
    
}
