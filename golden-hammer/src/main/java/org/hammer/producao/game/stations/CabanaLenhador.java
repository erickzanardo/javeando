package org.hammer.producao.game.stations;

import org.javaeando.game.JavaGraphics;

public class CabanaLenhador extends EstacaoDeTrabalho {

    public CabanaLenhador() {
        x = 480;
        y = 210;
    }

    public void draw(JavaGraphics graphics) {
        graphics.setColor(0xB07F23);
        graphics.fillRect(x, y, 100, 80);
    }

}
