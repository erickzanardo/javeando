package org.hammer.producao.game.stations;

import org.javaeando.game.JavaGraphics;

public class Mina extends EstacaoDeTrabalho {

    public Mina() {
        x = 690;
        y = 230;
    }

    public void draw(JavaGraphics graphics) {
        graphics.setColor(0xe3e3e3);
        graphics.fillRect(x, y, 100, 60);
    }

}
