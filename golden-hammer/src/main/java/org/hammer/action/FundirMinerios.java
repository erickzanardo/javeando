package org.hammer.action;

import java.util.List;

import org.hammer.dwarfs.Mineiro;
import org.hammer.producao.Material;
import org.hammer.producao.game.GoldenHammer;

public class FundirMinerios implements Acao {

    private Mineiro mineiro;

    private boolean validou = false;
    private long contadorFundicao = 5000;
    private boolean terminou = false;

    public FundirMinerios(Mineiro mineiro) {
        super();
        this.mineiro = mineiro;
    }

    @Override
    public void executar(long delta) {

        if (!validou) {
            validou = true;
            List<Object> inventario = mineiro.inventario();

            boolean carvao = inventario.remove(Material.MINERIO_CARVAO);
            boolean ferro = inventario.remove(Material.MINERIO_FERRO);

            if (!carvao && !ferro) {
                terminou = true;
                GoldenHammer.instance().logMessage(
                        mineiro.getNome() + " n\u00E3o tem os min\u00E9rios necess\u00E1rios para fundir ");
                return;
            }
        }

        contadorFundicao -= delta;
        if (contadorFundicao <= 0) {
            GoldenHammer.instance().logMessage(mineiro.getNome() + " terminou de fundir os min\u00E9rios ");
            mineiro.addItemIventario(Material.LINGOTE_FERRO);
            terminou = true;
        }
    }

    @Override
    public boolean terminada() {
        return terminou;
    }

}
