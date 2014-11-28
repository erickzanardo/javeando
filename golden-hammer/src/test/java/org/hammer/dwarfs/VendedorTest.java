package org.hammer.dwarfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.EntregrarProdutoAoCliente;
import org.hammer.action.EsperarPorItensNoDeposito;
import org.hammer.action.IrParaALoja;
import org.hammer.action.IrParaATaverna;
import org.hammer.producao.Pedidos;
import org.hammer.producao.Produto;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.stations.Loja;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendedorTest {

    @BeforeClass
    public static void setup() {
        Pedidos.instance().getPedidos().clear();
    }

    @Test
    public void testAcoes() {
        GoldenHammer.init();

        // - Recebe um pedido do cliente e adiciona ele na lista de pedidos
        // - Espera o pedido estar dsponível e entrega para o cliente

        Vendedor vendedor = new Vendedor(0, 0, "Fulano");
        List<Acao> retornaAcoes = vendedor.retornaAcoes();
        assertNull(retornaAcoes);

        Cliente cliente = new Cliente(0, 0, "Cliente", Produto.ESPADA);
        Loja.instance().setCliente(cliente);

        retornaAcoes = vendedor.retornaAcoes();
        assertTrue(Pedidos.instance().getPedidos().contains(Produto.ESPADA));

        assertNotNull(retornaAcoes);
        assertEquals(4, retornaAcoes.size());

        Acao acao = retornaAcoes.get(0);
        assertTrue(acao instanceof IrParaALoja);

        acao = retornaAcoes.get(1);
        assertTrue(acao instanceof EsperarPorItensNoDeposito);
        assertEquals(Produto.ESPADA, ((EsperarPorItensNoDeposito) acao).getItem());

        acao = retornaAcoes.get(2);
        assertTrue(acao instanceof EntregrarProdutoAoCliente);

        // Volta para a taverna
        assertTrue(retornaAcoes.get(3) instanceof IrParaATaverna);

    }
}
