package org.hammer.action;

import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.utils.MovimentoUtils;

public class IrEmboraDaLoja implements Acao {

    private Dwarf dwarf;
    private boolean foiEmbora = false;

    public IrEmboraDaLoja(Dwarf dwarf) {
        super();
        this.dwarf = dwarf;
    }

    @Override
    public void executar(long delta) {
        GoldenHammer instance = GoldenHammer.instance();
        if (MovimentoUtils.moverAnaoParaEstacao(dwarf, instance.getPontoDeSaida(), delta)) {
            foiEmbora = true;
            instance.logMessage(dwarf.getNome() + " deixou o estabelecimento ");
            instance.removerClienteDaLoja(dwarf);
        }
    }

    @Override
    public boolean terminada() {
        return foiEmbora;
    }

}
