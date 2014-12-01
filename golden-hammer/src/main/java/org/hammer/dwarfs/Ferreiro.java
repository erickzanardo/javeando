package org.hammer.dwarfs;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.producao.game.utils.Assets;

public class Ferreiro extends Dwarf {

    public Ferreiro(float x, float y, String nome) {
        super(x, y, nome);
        setSpriteSheetLeft(Assets.instance().getBlacksmithLeft());
        setSpriteSheetRight(Assets.instance().getBlacksmithRight());
    }

    @Override
    public List<Acao> retornaAcoes() {
        return null; // TODO

    }

}
