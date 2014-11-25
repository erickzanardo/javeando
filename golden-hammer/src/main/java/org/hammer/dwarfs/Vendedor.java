package org.hammer.dwarfs;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.producao.Produto;

public class Vendedor extends Dwarf {

    private boolean recebendoPedidos = true;
    private Produto produto;

    public Vendedor(float x, float y, String nome) {
        super(x, y, nome);
    }

    @Override
    public List<Acao> retornaAcoes() {
        return null;
    }

    public void recebePedido(Produto produto) {
        this.produto = produto;
        recebendoPedidos = false;
    }

    public boolean estaRecebendoPedidos() {
        return recebendoPedidos;
    }

}
