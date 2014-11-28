package org.hammer.action;

import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.game.stations.Loja;
import org.hammer.producao.game.utils.MovimentoUtils;

public class IrParaALoja implements Acao {

    private Dwarf dwarf;
    private boolean chegou = false;

    public IrParaALoja(Dwarf dwarf) {
        super();
        this.dwarf = dwarf;
    }

    @Override
    public void executar(long delta) {
        if (MovimentoUtils.moverAnaoParaEstacao(dwarf, Loja.instance(), delta)) {
            chegou = true;
        }
    }

    @Override
    public boolean terminada() {
        return chegou;
    }

}
