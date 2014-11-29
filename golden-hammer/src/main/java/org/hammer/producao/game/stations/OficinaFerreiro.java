package org.hammer.producao.game.stations;

import org.hammer.producao.game.utils.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaSpriteSheet;

public class OficinaFerreiro extends EstacaoDeTrabalho {

    private long counter = 0;
    private JavaSpriteSheet oficinaFerreiro;

    public OficinaFerreiro() {
        x = 580;
        y = 410;

        oficinaFerreiro = Assets.instance().getOficinaFerreiro();
    }

    @Override
    public void update(long delta) {
        if (counter >= 0) {
            oficinaFerreiro.update(delta);
            counter -= delta;
        }
    }

    @Override
    public void animate() {
        counter = 4000;
    }

    public void draw(JavaGraphics graphics) {
        graphics.drawImage(oficinaFerreiro.currentFrame(), x, y);
    }

}
