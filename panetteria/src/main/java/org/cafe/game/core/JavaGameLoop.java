package org.cafe.game.core;

import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class JavaGameLoop implements WindowListener {
    protected JFrame mainWindow;
    private boolean active;
    private BufferStrategy bufferStrategy;
    private long expectedMilis;

    private final Game game;
    private JavaGraphics graphics;

    private long lastUpdate;

    private JavaGameWindow gameWindow;

    public JavaGameLoop(final Game game) {
        this.game = game;

        mainWindow = new JFrame(game.getClass().getSimpleName());
        mainWindow.setIgnoreRepaint(true);
        mainWindow.setLocation(100, 100);

        mainWindow.setVisible(true);
        mainWindow.createBufferStrategy(2);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);

        gameWindow = new JavaSimpleWindow(mainWindow, 800, 600, game);

        mainWindow.addWindowListener(this);

        graphics = new JavaGraphics();
        graphics.setWidth(gameWindow.getWindowWidth());
        graphics.setHeight(gameWindow.getWindowHeight());

        active = false;
    }

    public void terminate() {
        active = false;
    }

    public void run() {
        active = true;

        // Game Init
        bufferStrategy = mainWindow.getBufferStrategy();

        expectedMilis = 1000 / game.getFrameRate();
        game.init(graphics);
        lastUpdate = System.currentTimeMillis();

        long lastRender = 0;

        // Game loop
        do {
            long update = System.currentTimeMillis();
            long delta = update - lastUpdate;

            if (lastUpdate - lastRender >= expectedMilis) {
                // Game Render
                Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();

                graphics.setG2d(g);
                gameWindow.draw(graphics);

                g.dispose();
                bufferStrategy.show();

                lastRender = System.currentTimeMillis();
            } else {
                // Game update
                gameWindow.update(delta);
                game.update(delta);
                Thread.yield();
            }
            lastUpdate += delta;
        } while (active);

        // Game destroy
        game.destroy();
        bufferStrategy.dispose();
        mainWindow.dispose();
    }

    public void windowClosing(WindowEvent e) {
        terminate();
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}