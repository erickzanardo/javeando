package org.hammer.dwarfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.Depositar;
import org.hammer.action.EsperarPorItensNoDeposito;
import org.hammer.action.Forjar;
import org.hammer.action.RecolherNoDeposito;
import org.hammer.producao.Pedidos;
import org.hammer.producao.Produto;
import org.junit.Test;

public class FerreiroTest {

    @Test
    public void testAcoes() {

        Ferreiro ferreiro = new Ferreiro(0, 0, "Fulano");

        // Nada para fazer por enquanto
        List<Acao> retornaAcoes = ferreiro.retornaAcoes();
        assertNull(retornaAcoes);

        // - Espera por algum pedido de produto
        Pedidos.instance().requisitar(Produto.ESPADA);
        retornaAcoes = ferreiro.retornaAcoes();
        assertNotNull(retornaAcoes);
        assertEquals(4, retornaAcoes.size());

        // - Faz o pedido dos materiais necessários para realizar o produto
        TesteUtils.assertItensDaReceitaRequisitados(Produto.ESPADA);

        // - Espera os materiais estarem disponíveis
        assertTrue(retornaAcoes.get(0) instanceof EsperarPorItensNoDeposito);
        TesteUtils.assertEsperaPorItensDaReceita(Produto.ESPADA, (EsperarPorItensNoDeposito) retornaAcoes.get(0));

        // - Vai ao depósito e pega os materiais
        assertTrue(retornaAcoes.get(1) instanceof RecolherNoDeposito);
        TesteUtils.assertRecolhimentoDeItensDaReceita(Produto.ESPADA, (RecolherNoDeposito) retornaAcoes.get(1));

        // - Forja o produto
        assertTrue(retornaAcoes.get(2) instanceof Forjar);
        assertEquals(Produto.ESPADA, ((Forjar) retornaAcoes.get(2)).getProduto());

        // - Leva o produto para o depósito e retorna para seu posto
        assertTrue(retornaAcoes.get(3) instanceof Depositar);
        assertEquals(Produto.ESPADA, ((Depositar) retornaAcoes.get(3)).getItem());
    }
}
