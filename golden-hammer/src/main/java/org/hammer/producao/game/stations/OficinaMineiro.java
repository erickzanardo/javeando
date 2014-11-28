package org.hammer.producao.game.stations;

import org.javaeando.game.JavaGraphics;

public class OficinaMineiro extends EstacaoDeTrabalho {

    public OficinaMineiro() {
        x = 480;
        y = 310;
    }

    public void draw(JavaGraphics graphics) {
        graphics.setColor(0xFF0000);
        graphics.fillRect(x, y, 100, 80);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
