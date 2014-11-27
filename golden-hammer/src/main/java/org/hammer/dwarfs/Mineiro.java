package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.Depositar;
import org.hammer.action.FundirMinerios;
import org.hammer.action.Minerar;
import org.hammer.producao.Material;
import org.hammer.producao.Pedidos;

public class Mineiro extends Dwarf {

    public Mineiro(float x, float y, String nome) {
        super(x, y, nome);
    }

    @Override
    public List<Acao> retornaAcoes() {

        if (Pedidos.instance().getPedidos().contains(Material.LINGOTE_FERRO)) {
            List<Acao> acoes = new ArrayList<Acao>();
            acoes.add(new Minerar());
            acoes.add(new FundirMinerios());
            acoes.add(new Depositar(Material.LINGOTE_FERRO));
            return acoes;
        }

        return null;
    }

}
