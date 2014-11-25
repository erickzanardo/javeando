package org.hammer.dwarfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.EsperarPorItensNoDeposito;
import org.hammer.producao.Produto;
import org.hammer.producao.game.GoldenHammer;
import org.junit.Test;

public class VendedorTest {

    @Test
    public void testAcoes() {
        GoldenHammer.init();

        // - Recebe um pedido do cliente e adiciona ele na lista de pedidos
        // - Espera o pedido estar dsponível e entrega para o cliente

        Vendedor vendedor = new Vendedor(0, 0, "Fulano");
        List<Acao> retornaAcoes = vendedor.retornaAcoes();
        assertNull(retornaAcoes);

        vendedor.recebePedido(Produto.ESPADA);
        retornaAcoes = vendedor.retornaAcoes();
        assertNotNull(retornaAcoes);
        assertEquals(1, retornaAcoes.size());

        Acao acao = retornaAcoes.get(0);
        assertTrue(acao instanceof EsperarPorItensNoDeposito);
        assertEquals(Produto.ESPADA, ((EsperarPorItensNoDeposito) acao).getItem());
    }
}
