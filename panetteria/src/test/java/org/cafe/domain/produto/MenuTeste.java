package org.cafe.domain.produto;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class MenuTeste {
    private static Menu menu;

    @BeforeClass
    public static void beforeClass() {
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

    @Test
    public void testeListarProdutos() {
        assertEquals(8, menu.listarProdutos().size());

        List<Produto> produtosPorTipo = menu.listarProdutosPorTipo(TipoProduto.CAFETERIA);
        assertEquals(2, produtosPorTipo.size());
        assertEquals("Cafe", produtosPorTipo.get(0).getNome());
        assertEquals("Capuccino", produtosPorTipo.get(1).getNome());

        produtosPorTipo = menu.listarProdutosPorTipo(TipoProduto.SALGADO);
        assertEquals(2, produtosPorTipo.size());
        assertEquals("Pao na chapa", produtosPorTipo.get(0).getNome());
        assertEquals("Quiche", produtosPorTipo.get(1).getNome());

        produtosPorTipo = menu.listarProdutosPorTipo(TipoProduto.DOCE);
        assertEquals(2, produtosPorTipo.size());
        assertEquals("Bolo de cenoura", produtosPorTipo.get(0).getNome());
        assertEquals("Torta holandesa", produtosPorTipo.get(1).getNome());

        produtosPorTipo = menu.listarProdutosPorTipo(TipoProduto.NATURAL);
        assertEquals(2, produtosPorTipo.size());
        assertEquals("Lanche natural", produtosPorTipo.get(0).getNome());
        assertEquals("Suco de laranja", produtosPorTipo.get(1).getNome());

    }
}
