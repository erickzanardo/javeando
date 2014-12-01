package org.hammer.dwarfs;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.producao.game.utils.Assets;

public class Mineiro extends Dwarf {

    public Mineiro(float x, float y, String nome) {
        super(x, y, nome);
        setSpriteSheetLeft(Assets.instance().getMinerLeft());
        setSpriteSheetRight(Assets.instance().getMinerRight());
    }

    @Override
    public List<Acao> retornaAcoes() {
        return null; // TODO
    }

}
