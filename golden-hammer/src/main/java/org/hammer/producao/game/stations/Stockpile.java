package org.hammer.producao.game.stations;

import org.javaeando.game.JavaGraphics;

public class Stockpile {
    private float x = 250, y = 40;
    
    public void draw(JavaGraphics graphics) {
        graphics.setColor(0x828278);
        graphics.fillRect(x, y, 110, 40);
    }
}
