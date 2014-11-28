package org.hammer.dwarfs;

import static org.junit.Assert.*;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.EsperarPorProdutoNoInventario;
import org.hammer.action.IrEmboraDaLoja;
import org.hammer.action.IrParaALoja;
import org.hammer.producao.Pedidos;
import org.hammer.producao.Produto;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteTest {
    @BeforeClass
    public static void setup() {
        Pedidos.instance().getPedidos().clear();
    }

    @Test
    public void testAcoes() {
        Cliente cliente = new Cliente(0, 0, "Fulano", Produto.ESPADA);

        List<Acao> retornaAcoes = cliente.retornaAcoes();
        assertNotNull(retornaAcoes);
        assertEquals(3, retornaAcoes.size());
        assertTrue(retornaAcoes.get(0) instanceof IrParaALoja);
        assertTrue(retornaAcoes.get(1) instanceof EsperarPorProdutoNoInventario);
        assertEquals(Produto.ESPADA, ((EsperarPorProdutoNoInventario) retornaAcoes.get(1)).getProduto());
        assertTrue(retornaAcoes.get(2) instanceof IrEmboraDaLoja);
    }
}
