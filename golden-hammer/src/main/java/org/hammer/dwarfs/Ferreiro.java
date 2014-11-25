package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.Depositar;
import org.hammer.action.EsperarPorItensNoDeposito;
import org.hammer.action.Forjar;
import org.hammer.action.RecolherNoDeposito;
import org.hammer.producao.Material;
import org.hammer.producao.Pedidos;
import org.hammer.producao.Produto;
import org.hammer.producao.Receitas;

public class Ferreiro extends Dwarf {

    public Ferreiro(float x, float y, String nome) {
        super(x, y, nome);
    }

    @Override
    public List<Acao> retornaAcoes() {

        List<Object> pedidos = Pedidos.instance().getPedidos();

        for (Object object : pedidos) {
            if (object instanceof Produto) {
                List<Acao> acoes = new ArrayList<Acao>();
                List<Material> materiais = Receitas.instance().getMateriais(object);

                for (Material material : materiais) {
                    Pedidos.instance().requisitar(material);
                }
                Object[] materiasArray = materiais.toArray();
                EsperarPorItensNoDeposito esperarPorItensNoDeposito = new EsperarPorItensNoDeposito(materiasArray);
                acoes.add(esperarPorItensNoDeposito);

                RecolherNoDeposito recolherNoDeposito = new RecolherNoDeposito(materiasArray);
                acoes.add(recolherNoDeposito);

                Forjar forjar = new Forjar((Produto) object);
                acoes.add(forjar);

                Depositar depositar = new Depositar(object);
                acoes.add(depositar);

                return acoes;
            }
        }

        return null;
    }

}
