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
    public BlockBuilder reset() {
        toBuild = new Block();
        return this;
    }

    public BlockBuilder setColor(Color color) {
        toBuild.color = color;
        return this;
    }

    public BlockBuilder setID(int id) {
        toBuild.id = id;
        return this;
    }
    
}
