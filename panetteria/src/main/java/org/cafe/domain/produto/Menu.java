package org.cafe.domain.produto;

import java.util.ArrayList;
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
        // TODO
        return produtos;
    }
}
