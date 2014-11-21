package org.cafe.game;

import org.cafe.domain.produto.Menu;
import org.cafe.domain.produto.Produto;
import org.cafe.domain.produto.TipoProduto;

public class MenuFactory {
    private Menu menu;

    public MenuFactory() {
        menu = new Menu();

        Produto produto = new Produto();
        produto.setNome("Cafe");
        produto.setPreco(1d);
        produto.setTipoProduto(TipoProduto.CAFETERIA);
        menu.add(produto);

        produto = new Produto();
        produto.setNome("Capuccino");
        produto.setPreco(2d);
        produto.setTipoProduto(TipoProduto.CAFETERIA);
        menu.add(produto);

        produto = new Produto();
        produto.setNome("Pao na chapa");
        produto.setPreco(1d);
        produto.setTipoProduto(TipoProduto.SALGADO);
        menu.add(produto);

        produto = new Produto();
        produto.setNome("Quiche");
        produto.setPreco(2d);
        produto.setTipoProduto(TipoProduto.SALGADO);
        menu.add(produto);

        produto = new Produto();
        produto.setNome("Bolo de cenoura");
        produto.setPreco(1d);
        produto.setTipoProduto(TipoProduto.DOCE);
        menu.add(produto);

        produto = new Produto();
        produto.setNome("Torta holandesa");
        produto.setPreco(2d);
        produto.setTipoProduto(TipoProduto.DOCE);
        menu.add(produto);

        produto = new Produto();
        produto.setNome("Lanche natural");
        produto.setPreco(1d);
        produto.setTipoProduto(TipoProduto.NATURAL);
        menu.add(produto);

        produto = new Produto();
        produto.setNome("Suco de laranja");
        produto.setPreco(1d);
        produto.setTipoProduto(TipoProduto.NATURAL);
        menu.add(produto);
    }

    public Menu getMenu() {
        return menu;
    }

}
