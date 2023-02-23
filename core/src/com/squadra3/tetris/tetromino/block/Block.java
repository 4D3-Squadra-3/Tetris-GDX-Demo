package com.squadra3.tetris.tetromino.block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.squadra3.tetris.global.Constants;
import com.squadra3.tetris.global.Variables;

public class Block implements Disposable {  // Parte di Tetromino
    protected Texture txt;
    private Sprite drawable;

    protected Color color;

    private int x, y;
    protected int id;

    private SpriteBatch batch = new SpriteBatch();

    public void create() {
        switch (color) {
            case BLUE:
                txt = new Texture("Blocco blu.png");
                break;
            case CYAN:
                txt = new Texture("Blocco ciano.png");
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

        drawable = new Sprite(txt);
        drawable.setSize(Constants.WIN_WIDTH / Constants.GRID_WIDTH, Constants.WIN_HEIGHT / Constants.GRID_HEIGHT);
    }

    // Metodo per renderizzare il singolo blocco
    public void render(int x, int y) {
        this.x = x;
        this.y = y;

        drawable.setPosition(x * (Constants.WIN_WIDTH / Constants.GRID_WIDTH), y * (Constants.WIN_HEIGHT / Constants.GRID_HEIGHT));

        batch.begin();

        drawable.draw(batch);

        batch.end();

        Variables.gameGrid.occupy(x, y, id);
    }

    public SpriteBatch getBatch() {
        return this.batch;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    @Override
    public void dispose() {
        txt.dispose();
        batch.dispose();
    }
}
