package org.hammer.producao.game.stations;

import org.hammer.producao.game.utils.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaImage;

public class Stockpile extends EstacaoDeTrabalho {

    private JavaImage image;
    private float drawX, drawY;

    public Stockpile() {
        x = 250;
        y = 20;
        image = Assets.instance().getStockpile();

        drawX = x - 20;
        drawY = y + 20;
    }

    public void draw(JavaGraphics graphics) {
        graphics.drawImage(image, drawX, drawY);
    }
}
