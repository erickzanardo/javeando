package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.Depositar;
import org.hammer.action.FundirMinerios;
import org.hammer.action.IrParaATaverna;
import org.hammer.action.Minerar;
import org.hammer.producao.Material;
import org.hammer.producao.Pedidos;
import org.hammer.producao.game.utils.Assets;

public class Mineiro extends Dwarf {

    public Mineiro(float x, float y, String nome) {
        super(x, y, nome);
        setSpriteSheetLeft(Assets.instance().getMinerLeft());
        setSpriteSheetRight(Assets.instance().getMinerRight());
    }

    @Override
    public List<Acao> retornaAcoes() {

        if (Pedidos.instance().getPedidos().contains(Material.LINGOTE_FERRO)) {
            List<Acao> acoes = new ArrayList<Acao>();
            acoes.add(new Minerar(this));
            acoes.add(new FundirMinerios(this));
            acoes.add(new Depositar(Material.LINGOTE_FERRO, this));
            acoes.add(new IrParaATaverna(this));
            return acoes;
        }

        return null;
    }

}
