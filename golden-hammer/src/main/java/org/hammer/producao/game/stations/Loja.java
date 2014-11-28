package org.hammer.producao.game.stations;

import org.hammer.dwarfs.Cliente;
import org.javaeando.game.JavaGraphics;

public class Loja extends EstacaoDeTrabalho {

    private static Loja instance;
    private Cliente cliente;

    private Loja() {
        x = 30;
        y = 200;
    }

    public static Loja instance() {
        if (instance == null) {
            instance = new Loja();
        }
        return instance;
    }

    @Override
    public void draw(JavaGraphics graphics) {
        graphics.setColor(0xDF7401);
        graphics.fillRect(x, y, 100, 60);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
