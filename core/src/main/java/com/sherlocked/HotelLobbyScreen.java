package com.sherlocked;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class HotelLobbyScreen implements Screen, InputProcessor {

    private final Sherlocked game;
    private Texture background;

    private ClickableObject logbook;
    private ClickableObject elevator;

    public HotelLobbyScreen(Sherlocked game) {
        this.game = game;
    }

    @Override
    public void show() {
        background = new Texture("images/hotel_lobby.jpg");

        createObjects();
        Gdx.input.setInputProcessor(this);
    }

    private void createObjects() {

        logbook = new ClickableObject(300, 200, 80, 60) {
            @Override
            public void onClick() {
                game.gameState.hasLogbookClue = true;
                game.gameState.elevatorUnlocked = true;
                System.out.println("Logbook collected.");
            }
        };

        elevator = new ClickableObject(600, 180, 120, 220) {
            @Override
            public void onClick() {
                if (game.gameState.elevatorUnlocked) {
                    System.out.println("Going to guest floor...");
                    // game.setScreen(new GuestFloorScreen(game));
                } else {
                    System.out.println("The elevator is locked.");
                }
            }
        };
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.batch.end();
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        float y = Gdx.graphics.getHeight() - screenY;

        if (logbook.isClicked(screenX, y)) logbook.onClick();
        if (elevator.isClicked(screenX, y)) elevator.onClick();

        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

    // Required overrides (empty for now)
    public void resize(int w, int h) {}
    public void pause() {}
    public void resume() {}
    public void hide() {}
    public void dispose() { background.dispose(); }
}

