package org.hammer.producao.game.stations;

import org.hammer.producao.game.utils.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaSpriteSheet;

public class OficinaMineiro extends EstacaoDeTrabalho {

    private long counter = 0;
    private JavaSpriteSheet oficinaMineiro;

    public OficinaMineiro() {
        x = 380;
        y = 410;

        oficinaMineiro = Assets.instance().getOficinaMineiro();
    }

    @Override
    public void update(long delta) {
        if (counter >= 0) {
            oficinaMineiro.update(delta);
            counter -= delta;
        }
    }

    @Override
    public void animate() {
        counter = 5000;
    }

    public void draw(JavaGraphics graphics) {
        graphics.drawImage(oficinaMineiro.currentFrame(), x, y);
    }

}
