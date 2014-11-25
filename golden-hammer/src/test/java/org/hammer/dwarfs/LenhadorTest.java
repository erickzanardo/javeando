package org.hammer.dwarfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.ColherMadeiraNaFloresta;
import org.hammer.action.Depositar;
import org.hammer.action.ProcessarMadeiraEmTabuas;
import org.hammer.producao.Material;
import org.hammer.producao.Pedidos;
import org.junit.Test;

public class LenhadorTest {

    @Test
    public void testAcoes() {
        Lenhador lenhador = new Lenhador();

        // - Espera por algum pedido de tábua
        List<Acao> retornaAcoes = lenhador.retornaAcoes();
        assertNull(retornaAcoes);

        Pedidos.instance().requisitar(Material.TABUA);
        // - Vai para a floresta e corta recolhe madeira
        retornaAcoes = lenhador.retornaAcoes();
        assertNotNull(retornaAcoes);
        assertEquals(3, retornaAcoes.size());
        assertTrue(retornaAcoes.get(0) instanceof ColherMadeiraNaFloresta);

        // - Volta para sua cabana e corta a madeira em tabuas
        assertTrue(retornaAcoes.get(1) instanceof ProcessarMadeiraEmTabuas);

        // - Leva a tábua para o deposito
        assertTrue(retornaAcoes.get(2) instanceof Depositar);
    }
}
