package org.hammer.action;

import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.Deposito;
import org.hammer.producao.Pedidos;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.stations.Stockpile;
import org.hammer.producao.game.utils.MovimentoUtils;

public class Depositar implements Acao {

    private Object item;
    private Dwarf dwarf;
    private boolean terminou = false;

    public Depositar(Object item, Dwarf dwarf) {
        super();
        this.item = item;
        this.dwarf = dwarf;
    }

    @Override
    public void executar(long delta) {
        Stockpile deposito = GoldenHammer.instance().getDeposito();
        if (MovimentoUtils.moverAnaoParaEstacao(dwarf, deposito, delta)) {
            if (dwarf.inventario().remove(item)) {
                Pedidos.instance().getPedidos().remove(item);
                Deposito.instance().adicionar(item);
                GoldenHammer.instance().logMessage(dwarf.getNome() + " depositou " + item);
            }
            terminou = true;
        }
    }

    public Object getItem() {
        return item;
    }

    @Override
    public boolean terminada() {
        return terminou;
    }

}
