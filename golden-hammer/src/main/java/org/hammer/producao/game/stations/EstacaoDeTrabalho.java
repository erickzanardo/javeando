package org.hammer.producao.game.stations;

import org.javaeando.game.JavaGraphics;

public abstract class EstacaoDeTrabalho {
    protected float x, y;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    public abstract void draw(JavaGraphics graphics);
    public void animate(){};
    public void update(long delta) {};
}
