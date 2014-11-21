package org.cafe.game;

import org.cafe.game.core.Assets;
import org.cafe.game.core.JavaGraphics;
import org.cafe.game.core.JavaSpriteSheet;

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
        g.drawImage(spriteSheet.currentFrame(), 600, 150);
    }

    public void animate() {
       animationCounter = 2000; // 2 secs
    }
}
