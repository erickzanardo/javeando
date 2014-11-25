package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.javaeando.game.JavaGraphics;

public abstract class Dwarf {
    private float x, y;
    private List<Object> inventario = new ArrayList<Object>();
    private String nome;

    public Dwarf(float x, float y, String nome) {
        super();
        this.x = x;
        this.y = y;
        this.nome = nome;
    }

    public abstract List<Acao> retornaAcoes();

    public void draw(JavaGraphics graphics) {
        graphics.setColor(0xffffff);
        graphics.drawString(nome, x, y - 10);
        graphics.fillRect(x, y, 50, 100);
    }
}
