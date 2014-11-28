package org.hammer.producao.game.stations;

import org.javaeando.game.JavaGraphics;

public class Taverna extends EstacaoDeTrabalho {
    public Taverna() {
        x = 150;
        y = 400;
    }

    @Override
    public void draw(JavaGraphics graphics) {
        graphics.setColor(0xFFFF00);
        graphics.fillRect(x, y, 110, 40);
    }
}
