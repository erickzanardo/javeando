package org.cafe.game.core;

import javax.swing.JFrame;

public abstract class JavaGameWindow {
    protected JFrame window;
    protected int windowHeight;
    protected int windowWidth;
    protected Game game;

    public JavaGameWindow(JFrame window, int windowWidth, int windowHeight, Game game) {
        this.window = window;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.game = game;
    }

    public abstract void update(long delta);

    public abstract void draw(JavaGraphics graphics);

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

}