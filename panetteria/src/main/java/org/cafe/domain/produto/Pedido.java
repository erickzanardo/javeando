package org.cafe.domain.produto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> itens = new ArrayList<Produto>();

    public void addItem(Produto produto) {
        itens.add(produto);
    }

    public List<Produto> itens() {
        return itens;
    }
}
