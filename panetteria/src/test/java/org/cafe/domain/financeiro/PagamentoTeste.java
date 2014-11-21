package org.cafe.domain.financeiro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.cafe.domain.clientes.Arquiteto;
import org.cafe.domain.clientes.Coordenador;
import org.cafe.domain.clientes.Programador;
import org.cafe.domain.produto.Pedido;
import org.cafe.domain.produto.Produto;
import org.cafe.domain.produto.TipoProduto;
import org.junit.BeforeClass;
import org.junit.Test;

public class PagamentoTeste {

    private static Programador programador;
    private static Arquiteto arquiteto;
    private static Coordenador coordenador;

    @BeforeClass
    public static void beforeClass() {
        /* Programador */
        programador = new Programador();
        programador.setDinheiro(10);

        /* Arquiteto */
        Conta conta = new Conta(1l, 10, 0);
        Banco.instance().adicionaConta(conta);

        arquiteto = new Arquiteto();
        arquiteto.setNumeroDaConta(1l);

        /* Coordenador */
        conta = new Conta(2l, 10, 10);
        Banco.instance().adicionaConta(conta);

        coordenador = new Coordenador();
        coordenador.setNumeroDaConta(2l);
    }

    @Test
    public void testePagamentoNoDinheiro() {
        Pedido pedido = new Pedido();

        Produto produto = new Produto();
        produto.setNome("cafe");
        produto.setPreco(5);
        produto.setTipoProduto(TipoProduto.CAFETERIA);
        pedido.addItem(produto);

        produto = new Produto();
        produto.setNome("bolo");
        produto.setPreco(6);
        produto.setTipoProduto(TipoProduto.CAFETERIA);
        pedido.addItem(produto);

        PagamentoNoDinheiro pagamentoNoDinheiro = new PagamentoNoDinheiro(programador, pedido);
        // cafe(5) + bolo(6) = 11 > programador(10)
        boolean processo = pagamentoNoDinheiro.processar();
        assertFalse(processo);

        pedido.itens().get(0).setPreco(1);
        // cafe(1) + bolo(6) = 7 < programador(10)
        processo = pagamentoNoDinheiro.processar();
        assertTrue(processo);

        assertEquals(new Double(3), new Double(programador.getDinheiro()));
    }

    @Test
    public void testeCartaoDeDebito() {
        Pedido pedido = new Pedido();

        Produto produto = new Produto();
        produto.setNome("cafe");
        produto.setPreco(5);
        produto.setTipoProduto(TipoProduto.CAFETERIA);
        pedido.addItem(produto);

        produto = new Produto();
        produto.setNome("quiche");
        produto.setPreco(6);
        produto.setTipoProduto(TipoProduto.SALGADO);
        pedido.addItem(produto);

        CartaoDeDebito cartaoDeDebito = new CartaoDeDebito(arquiteto, pedido);
        // cafe(5) + quiche(6) = 11 > conta_arquiteto(10)
        boolean processo = cartaoDeDebito.processar();
        assertFalse(processo);

        pedido.itens().get(0).setPreco(1);
        // cafe(1) + bolo(6) = 7 < conta_arquiteto(10)
        processo = cartaoDeDebito.processar();
        assertTrue(processo);

        Conta conta = Banco.instance().getConta(arquiteto.getNumeroDaConta());
        assertEquals(new Double(3), new Double(conta.getSaldo()));

    }

    @Test
    public void testeCartaoDeCredito() {
        Pedido pedido = new Pedido();

        Produto produto = new Produto();
        produto.setNome("suco");
        produto.setPreco(5);
        produto.setTipoProduto(TipoProduto.NATURAL);
        pedido.addItem(produto);

        produto = new Produto();
        produto.setNome("lanche");
        produto.setPreco(6);
        produto.setTipoProduto(TipoProduto.NATURAL);
        pedido.addItem(produto);

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(coordenador, pedido);
        // suco(5) + lanche(6) = 11 > credito_coordenador(10)
        boolean processo = cartaoDeCredito.processar();
        assertFalse(processo);

        pedido.itens().get(0).setPreco(1);
        // suco(1) + lanche(6) = 7 < credito_coordenador(10)
        processo = cartaoDeCredito.processar();
        assertTrue(processo);

        Conta conta = Banco.instance().getConta(coordenador.getNumeroDaConta());
        assertEquals(new Double(3), new Double(conta.limiteDisponivel()));

    }
}
