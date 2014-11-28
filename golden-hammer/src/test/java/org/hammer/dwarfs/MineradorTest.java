package org.hammer.dwarfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.Depositar;
import org.hammer.action.FundirMinerios;
import org.hammer.action.IrParaATaverna;
import org.hammer.action.Minerar;
import org.hammer.producao.Material;
import org.hammer.producao.Pedidos;
import org.hammer.producao.game.GoldenHammer;
import org.junit.BeforeClass;
import org.junit.Test;

public class MineradorTest {

    @BeforeClass
    public static void setup() {
        Pedidos.instance().getPedidos().clear();
    }

    @Test
    public void testeAcoes() {
        GoldenHammer.init();

        Mineiro mineiro = new Mineiro(0, 0, "Fulano");

        List<Acao> retornaAcoes = mineiro.retornaAcoes();
        assertNull(retornaAcoes);

        Pedidos.instance().requisitar(Material.LINGOTE_FERRO);
        // - Espera por pedido de lingotes de ferro
        retornaAcoes = mineiro.retornaAcoes();
        assertNotNull(retornaAcoes);
        assertEquals(4, retornaAcoes.size());

        // - Vai para a mina e minera um ferro e um carvão
        assertTrue(retornaAcoes.get(0) instanceof Minerar);

        // - Volta para sua estação e funde os minérios
        assertTrue(retornaAcoes.get(1) instanceof FundirMinerios);

        // - Leva o lingote para o depósito
        assertTrue(retornaAcoes.get(2) instanceof Depositar);
        assertEquals(Material.LINGOTE_FERRO, ((Depositar) retornaAcoes.get(2)).getItem());

        // Volta para a taverna
        assertTrue(retornaAcoes.get(3) instanceof IrParaATaverna);

    }
}
