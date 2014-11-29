package org.hammer.producao.game.stations;

import org.hammer.producao.game.utils.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaSpriteSheet;

public class Floresta extends EstacaoDeTrabalho {

    private long counter = 0;
    private JavaSpriteSheet floresta;

    public Floresta() {
        x = 580;
        y = 30;

        floresta = Assets.instance().getWoods();
    }

    @Override
    public void update(long delta) {
        if (counter >= 0) {
            floresta.update(delta);
            counter -= delta;
        }
    }

    @Override
    public void animate() {
        counter = 3000;
    }

    public void draw(JavaGraphics graphics) {
        graphics.drawImage(floresta.currentFrame(), x, y);
    }

}
