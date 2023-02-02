package com.squadra3.tetris.tetromino.block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class Block implements Disposable {  // Parte di Tetromino
    protected Texture txt;
    protected Color color;

    private SpriteBatch batch = new SpriteBatch();

    // Metodo per renderizzare il singolo blocco
    public void render(int x, int y) {
        switch (color) {
            case BLUE:
                txt = new Texture("Blocco blu.png");
                break;
            case CYAN:
                txt = new Texture("Blocco azzurro.png");
                break;
            case GREEN:
                txt = new Texture("Blocco verde.png");
                break;
            case ORANGE:
                txt = new Texture("Blocco arancione.png");
                break;
            case PURPLE:
                txt = new Texture("Blocco viola.png");
                break;
            case YELLOW:
                txt = new Texture("Blocco giallo.png");
                break;
            case RED:
                txt = new Texture("Blocco rosso.png");
                break;
            default:
                break;

        }

        Sprite toDraw = new Sprite(txt);
        toDraw.setSize(400 / 10, 800 / 20);
        toDraw.setPosition(x * 40, y * 40);

        batch.begin();

        //batch.draw(txt, x * 256, y * 256);
        toDraw.draw(batch);

        batch.end();
    }

    public SpriteBatch getBatch() {
        return this.batch;
    }

    @Override
    public void dispose() {
        txt.dispose();
    }
}
