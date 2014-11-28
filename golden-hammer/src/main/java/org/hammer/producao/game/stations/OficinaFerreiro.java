package org.hammer.producao.game.stations;

import org.javaeando.game.JavaGraphics;

public class OficinaFerreiro extends EstacaoDeTrabalho {

    public OficinaFerreiro() {
        x = 680;
        y = 310;
    }

    public void draw(JavaGraphics graphics) {
        graphics.setColor(0xCF6363);
        graphics.fillRect(x, y, 100, 80);
    }

}
