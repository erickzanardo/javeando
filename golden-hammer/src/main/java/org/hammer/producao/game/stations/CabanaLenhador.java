package org.hammer.producao.game.stations;

import org.hammer.producao.game.utils.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaSpriteSheet;

public class CabanaLenhador extends EstacaoDeTrabalho {

    private long counter = 0;
    private JavaSpriteSheet cabana;

    public CabanaLenhador() {
        x = 380;
        y = 210;

        cabana = Assets.instance().getWoodcutterHouse();
    }

    @Override
    public void update(long delta) {
        if (counter >= 0) {
            cabana.update(delta);
            counter -= delta;
        }
    }

    @Override
    public void animate() {
        counter = 2500;
    }

    public void draw(JavaGraphics graphics) {
        graphics.drawImage(cabana.currentFrame(), x, y);
    }

}
