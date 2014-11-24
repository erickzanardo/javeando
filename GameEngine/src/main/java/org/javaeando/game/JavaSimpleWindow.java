package org.javaeando.game;

import javax.swing.JFrame;

public class JavaSimpleWindow extends JavaGameWindow {

    public JavaSimpleWindow(JFrame window, int windowWidth, int windowHeight, Game game) {
        super(window, windowWidth, windowHeight, game);

        window.getAlignmentX();
        window.getAlignmentY();

        window.setSize(windowWidth, windowHeight);
    }

    @Override
    public void update(long delta) {

    }

    @Override
    public void draw(JavaGraphics g) {
        game.render(g);
    }
}