package org.hammer.producao.game.stations;

import org.hammer.producao.game.utils.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaImage;

public class Taverna extends EstacaoDeTrabalho {

    private JavaImage image;
    private float drawY, drawX;

    public Taverna() {
        x = 150;
        y = 400;

        drawX = x - 20;
        drawY = y;
        image = Assets.instance().getTavern();
    }

    @Override
    public void draw(JavaGraphics graphics) {
        graphics.drawImage(image, drawX, drawY);
    }
}
