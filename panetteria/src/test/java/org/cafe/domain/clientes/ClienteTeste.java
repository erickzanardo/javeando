package org.cafe.domain.clientes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.cafe.domain.financeiro.CartaoDeCredito;
import org.cafe.domain.financeiro.CartaoDeDebito;
import org.cafe.domain.financeiro.PagamentoNoDinheiro;
import org.cafe.domain.produto.Menu;
import org.cafe.domain.produto.Pedido;
import org.cafe.domain.produto.Produto;
import org.cafe.domain.produto.TipoProduto;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteTeste {

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

    /*
     * Menu neste teste: Cafeteria: Cafe $1 Capuccino $2 Salgados: Pao na chapa
     * $1 Quiche $2 Doces: Bolo de cenoura $1 Torta holandesa $2 Natural: Lanche
     * natural $1 Suco de laranja $1
     */

    @Test
    public void testeEscolherProduto() {
        /* Programador */
        Programador programador = new Programador();
        Pedido pedido = programador.escolherPedido(menu);

        List<Produto> itens = pedido.itens();
        assertNotNull(itens);
        assertEquals(2, itens.size());
        assertEquals("Bolo de cenoura", itens.get(0).getNome());
        assertEquals("Cafe", itens.get(1).getNome());

        /* Arquiteto */
        Arquiteto arquiteto = new Arquiteto();
        pedido = arquiteto.escolherPedido(menu);

        itens = pedido.itens();
        assertNotNull(itens);
        assertEquals(2, itens.size());
        assertEquals("Capuccino", itens.get(0).getNome());
        assertEquals("Quiche", itens.get(1).getNome());

        /* Coordenador */
        Coordenador coordenador = new Coordenador();
        pedido = coordenador.escolherPedido(menu);

        itens = pedido.itens();
        assertNotNull(itens);
        assertEquals(2, itens.size());
        assertEquals("Lanche natural", itens.get(0).getNome());
        assertEquals("Suco de laranja", itens.get(1).getNome());
    }

    @Test
    public void testeEscolherPagamento() {
        Programador programador = new Programador();
        assertTrue(programador.escolherTipoDePagamento() instanceof PagamentoNoDinheiro);

        Arquiteto arquiteto = new Arquiteto();
        assertTrue(arquiteto.escolherTipoDePagamento() instanceof CartaoDeDebito);

        Coordenador coordenador = new Coordenador();
        assertTrue(coordenador.escolherTipoDePagamento() instanceof CartaoDeCredito);
    }
}
