package com.sherlocked;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Sherlocked extends Game {
    public SpriteBatch batch;
    public GameState gameState;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gameState = new GameState();

        setScreen(new HotelLobbyScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
