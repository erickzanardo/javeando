package org.hammer.action;

import org.hammer.dwarfs.Mineiro;
import org.hammer.producao.Material;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.stations.Mina;
import org.hammer.producao.game.stations.OficinaMineiro;
import org.hammer.producao.game.utils.MovimentoUtils;

public class Minerar implements Acao {

    private boolean indoParaAMina;
    private boolean minerando;
    private boolean indoParaAEstacao;

    private long contadorMinerando = 5000;

    private Mineiro mineiro;

    private boolean terminou = false;

    public Minerar(Mineiro mineiro) {
        this.mineiro = mineiro;
        indoParaAMina = true;
    }

    @Override
    public void executar(long delta) {
        GoldenHammer instance = GoldenHammer.instance();
        if (indoParaAMina) {
            Mina mina = instance.getMina();
            if (MovimentoUtils.moverAnaoParaEstacao(mineiro, mina, delta)) {
                instance.logMessage(mineiro.getNome() + " chegou na mina ");
                indoParaAMina = false;
                minerando = true;
            }
        } else if (minerando) {
            contadorMinerando -= delta;
            if (contadorMinerando <= 0) {
                minerando = false;
                indoParaAEstacao = true;
                instance.logMessage(mineiro.getNome() + " terminou de minerar ");

                mineiro.addItemIventario(Material.MINERIO_FERRO);
                mineiro.addItemIventario(Material.MINERIO_CARVAO);
            }
        } else if (indoParaAEstacao) {
            OficinaMineiro oficina = instance.getOficinaMineiro();

            if (MovimentoUtils.moverAnaoParaEstacao(mineiro, oficina, delta)) {
                indoParaAEstacao = false;
                terminou = true;
                instance.logMessage(mineiro.getNome() + " chegou em sua oficina ");
            }

        }
    }

    @Override
    public boolean terminada() {
        return terminou;
    }

}
