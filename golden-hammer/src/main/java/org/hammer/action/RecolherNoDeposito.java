package org.hammer.action;

import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.Deposito;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.utils.MovimentoUtils;

public class RecolherNoDeposito implements Acao {

    private Dwarf dwarf;
    private Object[] itens;
    private boolean terminou = false;

    public RecolherNoDeposito(Dwarf dwarf, Object... itens) {
        super();
        this.dwarf = dwarf;
        this.itens = itens;
    }

    @Override
    public void executar(long delta) {
        GoldenHammer instance = GoldenHammer.instance();
        if (MovimentoUtils.moverAnaoParaEstacao(dwarf, instance.getDeposito(), delta)) {
            for (Object item : itens) {
                if (Deposito.instance().retirar(item)) {
                    dwarf.addItemIventario(item);
                    instance.logMessage(dwarf.getNome() + " retirou um(a) " + item + " dep\u00F3sito ");
                }
            }
            terminou = true;
        }
    }

    public Object[] getItens() {
        return itens;
    }

    @Override
    public boolean terminada() {
        return terminou;
    }

}
