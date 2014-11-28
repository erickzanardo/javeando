package org.hammer.action;

import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.utils.MovimentoUtils;

public class IrParaATaverna implements Acao {

    private Dwarf dwarf;
    private boolean chegou = false;

    public IrParaATaverna(Dwarf dwarf) {
        super();
        this.dwarf = dwarf;
    }

    @Override
    public void executar(long delta) {
        GoldenHammer instance = GoldenHammer.instance();
        if (MovimentoUtils.moverAnaoParaEstacao(dwarf, instance.getTaverna(), delta)) {
            instance.logMessage(dwarf.getNome() + " chegou a taverna ");
            chegou = true;
        }
    }

    @Override
    public boolean terminada() {
        return chegou;
    }

}
