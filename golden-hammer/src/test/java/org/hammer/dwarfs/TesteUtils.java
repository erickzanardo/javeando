package org.hammer.dwarfs;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.hammer.action.EsperarPorItensNoDeposito;
import org.hammer.action.RecolherNoDeposito;
import org.hammer.producao.Material;
import org.hammer.producao.Pedidos;
import org.hammer.producao.Receitas;

public class TesteUtils {
    public static void assertEsperaPorItensDaReceita(Object object, EsperarPorItensNoDeposito acao) {
        List<Object> listaDeItens = acao.getItens();
        List<Material> materiais = Receitas.instance().getMateriais(object);
        for (Material material : materiais) {
            assertTrue(listaDeItens.contains(material));
        }
    }

    public static void assertItensDaReceitaRequisitados(Object object) {

        List<Object> pedidos = Pedidos.instance().getPedidos();

        List<Material> materiais = Receitas.instance().getMateriais(object);
        for (Material material : materiais) {
            assertTrue(pedidos.contains(material));
        }
    }

    public static void assertRecolhimentoDeItensDaReceita(Object object, RecolherNoDeposito acao) {
        List<Object> listaItens = Arrays.asList(acao.getItens());

        List<Material> materiais = Receitas.instance().getMateriais(object);
        for (Material material : materiais) {
            assertTrue(listaItens.contains(material));
        }
    }

}
