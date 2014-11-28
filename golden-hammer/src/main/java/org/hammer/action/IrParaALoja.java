package org.hammer.action;

import org.hammer.dwarfs.Dwarf;

public class IrParaALoja implements Acao {

    private Dwarf dwarf;
    private boolean chegou = false;

    public IrParaALoja(Dwarf dwarf) {
        super();
        this.dwarf = dwarf;
    }

    @Override
    public void executar(long delta) {

    }

    @Override
    public boolean terminada() {
        return chegou;
    }

}
