package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.ColherMadeiraNaFloresta;
import org.hammer.action.Depositar;
import org.hammer.action.ProcessarMadeiraEmTabuas;
import org.hammer.producao.Material;
import org.hammer.producao.Pedidos;

public class Lenhador extends Dwarf {

    public Lenhador(float x, float y, String nome) {
        super(x, y, nome);
    }

    @Override
    public List<Acao> retornaAcoes() {

        if (Pedidos.instance().getPedidos().contains(Material.TABUA)) {
            List<Acao> acoes = new ArrayList<>();

            acoes.add(new ColherMadeiraNaFloresta());
            acoes.add(new ProcessarMadeiraEmTabuas());
            acoes.add(new Depositar(Material.TABUA));

            return acoes;
        }

        return null;
    }

}
