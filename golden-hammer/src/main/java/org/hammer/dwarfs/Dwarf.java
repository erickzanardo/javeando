package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaSpriteSheet;

public abstract class Dwarf {
    private float x, y;
    private List<Object> inventario = new ArrayList<Object>();
    private String nome;

    private JavaSpriteSheet spriteSheetRight;
    private JavaSpriteSheet spriteSheetLeft;
    private boolean right;
    private boolean moving;

    public Dwarf(float x, float y, String nome) {
        super();
        this.x = x;
        this.y = y;
        this.nome = nome;
    }

    public abstract List<Acao> retornaAcoes();

    public void draw(JavaGraphics graphics) {
        if (right) {
            graphics.drawImage(spriteSheetRight.currentFrame(), x, y);
        } else {
            graphics.drawImage(spriteSheetLeft.currentFrame(), x, y);
        }
    }

    public void update(long delta) {
        if (moving) {
            if (right) {
                spriteSheetRight.update(delta);
            } else {
                spriteSheetLeft.update(delta);
            }
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getNome() {
        return nome;
    }

    public void addItemIventario(Object o) {
        inventario.add(o);
    }

    public List<Object> inventario() {
        return inventario;
    }

    public JavaSpriteSheet getSpriteSheetRight() {
        return spriteSheetRight;
    }

    public void setSpriteSheetRight(JavaSpriteSheet spriteSheetRight) {
        this.spriteSheetRight = spriteSheetRight;
    }

    public JavaSpriteSheet getSpriteSheetLeft() {
        return spriteSheetLeft;
    }

    public void setSpriteSheetLeft(JavaSpriteSheet spriteSheetLeft) {
        this.spriteSheetLeft = spriteSheetLeft;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

}
