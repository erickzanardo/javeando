package org.hammer.dwarfs;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.producao.Produto;

public class Cliente extends Dwarf {

    private Produto produto;

    public Cliente(float x, float y, String nome, Produto produto) {
        super(x, y, nome);
        this.produto = produto;
    }

    @Override
    public List<Acao> retornaAcoes() {
        return null;
    }

    public Produto getProduto() {
        return produto;
    }

}
