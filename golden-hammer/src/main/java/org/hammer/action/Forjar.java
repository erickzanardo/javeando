package org.hammer.action;

import org.hammer.producao.Produto;

public class Forjar implements Acao {

    private Produto produto;

    public Forjar(Produto produto) {
        super();
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public void executar(long delta) {
    }

    @Override
    public boolean terminada() {
        return false;
    }

}
