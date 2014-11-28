package org.hammer.action;

import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.Produto;

public class EsperarPorProdutoNoInventario implements Acao {

    private Dwarf dwarf;
    private Produto produto;

    public EsperarPorProdutoNoInventario(Dwarf dwarf, Produto produto) {
        super();
        this.dwarf = dwarf;
        this.produto = produto;
    }

    public Dwarf getDwarf() {
        return dwarf;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public void executar(long delta) {

    }

    @Override
    public boolean terminada() {
        return dwarf.inventario().contains(produto);
    }

}
