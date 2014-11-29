package org.hammer.producao.game.stations;

import org.hammer.dwarfs.Cliente;
import org.hammer.producao.game.utils.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaImage;

public class Loja extends EstacaoDeTrabalho {

    private static Loja instance;
    private Cliente cliente;
    private JavaImage image;

    private float drawX, drawY;

    private Loja() {
        x = 30;
        y = 200;

        drawX = x - 20;
        drawY = y - 20;

        image = Assets.instance().getStore();

    }

    public static Loja instance() {
        if (instance == null) {
            instance = new Loja();
        }
        return instance;
    }

    @Override
    public void draw(JavaGraphics graphics) {
        graphics.drawImage(image, drawX, drawY);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
