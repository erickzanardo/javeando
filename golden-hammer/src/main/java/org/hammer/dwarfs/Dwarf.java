package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;

public abstract class Dwarf {
    private List<Object> inventario = new ArrayList<Object>();
    private String nome;

    public abstract List<Acao> retornaAcoes();
}
