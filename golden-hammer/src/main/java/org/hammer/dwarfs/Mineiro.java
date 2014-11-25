package org.hammer.dwarfs;

import java.util.List;

import org.hammer.action.Acao;

public class Mineiro extends Dwarf {

    public Mineiro(float x, float y, String nome) {
        super(x, y, nome);
    }

    @Override
    public List<Acao> retornaAcoes() {
        return null;
    }

}
