package org.cafe.game;

import org.javaeando.game.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaSpriteSheet;

public class Francesco {
    private JavaSpriteSheet spriteSheet;
    private int animationCounter;

    public Francesco() {
        spriteSheet = Assets.getInstance().getFrancesco();
    }

    public void update(long delta) {
        if (animationCounter > 0) {
            animationCounter -= delta;
            spriteSheet.update(delta);
        }
    }

    public void draw(JavaGraphics g) {
        g.drawImage(spriteSheet.currentFrame(), 615, 250);
    }

    public void animate() {
       animationCounter = 2000; // 2 secs
    }
}
