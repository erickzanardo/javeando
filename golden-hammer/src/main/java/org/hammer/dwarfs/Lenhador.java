package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.ColherMadeiraNaFloresta;
import org.hammer.action.Depositar;
import org.hammer.action.IrParaATaverna;
import org.hammer.action.ProcessarMadeiraEmTabuas;
import org.hammer.producao.Material;
import org.hammer.producao.Pedidos;
import org.hammer.producao.game.utils.Assets;

public class Lenhador extends Dwarf {

    public Lenhador(float x, float y, String nome) {
        super(x, y, nome);
        setSpriteSheetLeft(Assets.instance().getWoodcutterLeft());
        setSpriteSheetRight(Assets.instance().getWoodcutterRight());
    }

    @Override
    public List<Acao> retornaAcoes() {

        if (Pedidos.instance().getPedidos().contains(Material.TABUA)) {
            List<Acao> acoes = new ArrayList<>();

            acoes.add(new ColherMadeiraNaFloresta(this));
            acoes.add(new ProcessarMadeiraEmTabuas(this));
            acoes.add(new Depositar(Material.TABUA, this));
            acoes.add(new IrParaATaverna(this));

            return acoes;
        }

        return null;
    }

}
