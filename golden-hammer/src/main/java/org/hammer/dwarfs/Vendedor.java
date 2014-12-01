package org.hammer.dwarfs;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.producao.Produto;
import org.hammer.producao.game.utils.Assets;

public class Vendedor extends Dwarf {

    private Produto produto;

    public Vendedor(float x, float y, String nome) {
        super(x, y, nome);
        setSpriteSheetLeft(Assets.instance().getSalesmanLeft());
        setSpriteSheetRight(Assets.instance().getSalesmanRight());
    }

    @Override
    public List<Acao> retornaAcoes() {
        return null; // TODO
    }

}
