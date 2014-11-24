package org.javaeando.game;


public interface Game {
    public abstract void init(JavaGraphics graphics);

    public abstract void destroy();

    public abstract void update(long delta);

    public abstract void render(JavaGraphics graphics);

    public abstract int getFrameRate();
}