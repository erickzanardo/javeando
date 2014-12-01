package org.hammer.dwarfs;

import java.util.List;

import org.hammer.action.Acao;
import org.hammer.producao.game.utils.Assets;

public class Lenhador extends Dwarf {

    public Lenhador(float x, float y, String nome) {
        super(x, y, nome);
        setSpriteSheetLeft(Assets.instance().getWoodcutterLeft());
        setSpriteSheetRight(Assets.instance().getWoodcutterRight());
    }

    @Override
    public List<Acao> retornaAcoes() {
        return null; // TODO
    }

}
