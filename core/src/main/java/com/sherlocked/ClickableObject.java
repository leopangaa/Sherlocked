package com.sherlocked;

import com.badlogic.gdx.math.Rectangle;

public abstract class ClickableObject {

    protected Rectangle bounds;

    public ClickableObject(float x, float y, float width, float height) {
        bounds = new Rectangle(x, y, width, height);
    }

    public boolean isClicked(float screenX, float screenY) {
        return bounds.contains(screenX, screenY);
    }

    public abstract void onClick();
}

