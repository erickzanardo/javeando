package org.hammer.producao.game.stations;

import org.hammer.producao.game.utils.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaSpriteSheet;

public class Mina extends EstacaoDeTrabalho {

    private long counter = 0;
    private JavaSpriteSheet mina;

    public Mina() {
        x = 590;
        y = 230;

        mina = Assets.instance().getMina();
    }

    @Override
    public void update(long delta) {
        if (counter >= 0) {
            mina.update(delta);
            counter -= delta;
        }
    }

    @Override
    public void animate() {
        counter = 5000;
    }

    public void draw(JavaGraphics graphics) {
        graphics.drawImage(mina.currentFrame(), x, y);
    }

}
