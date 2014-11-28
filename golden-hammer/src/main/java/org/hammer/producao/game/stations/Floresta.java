package org.hammer.producao.game.stations;

import org.javaeando.game.JavaGraphics;

public class Floresta extends EstacaoDeTrabalho {

    public Floresta() {
        x = 480;
        y = 60;
    }

    public void draw(JavaGraphics graphics) {
        graphics.setColor(0x00ff00);
        graphics.fillRect(x, y, 300, 150);
    }

}
