package org.cafe.domain.produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Menu {
    private List<Produto> produtos = new ArrayList<>();

    public void add(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public List<Produto> listarProdutosPorTipo(TipoProduto tipoProduto) {

        List<Produto> ret = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.getTipoProduto().equals(tipoProduto)) {
                ret.add(p);
            }
        }

        Collections.sort(ret, new Comparator<Produto>() {

            @Override
            public int compare(Produto arg0, Produto arg1) {
                return arg0.getNome().compareTo(arg1.getNome());
            }
        });

        return ret;
    }
}
