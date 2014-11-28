package org.hammer.action;

import org.hammer.dwarfs.Lenhador;
import org.hammer.producao.Material;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.utils.MovimentoUtils;

public class ColherMadeiraNaFloresta implements Acao {

    private Lenhador lenhador;
    private boolean terminada = false;

    private boolean indoParaAFloresta = true;
    private long corteContador = 3000;

    public ColherMadeiraNaFloresta(Lenhador lenhador) {
        super();
        this.lenhador = lenhador;
    }

    @Override
    public void executar(long delta) {
        GoldenHammer instance = GoldenHammer.instance();

        if (indoParaAFloresta) {
            if (MovimentoUtils.moverAnaoParaEstacao(lenhador, instance.getFloresta(), delta)) {
                instance.logMessage(lenhador.getNome() + " chegou na floresta ");
                indoParaAFloresta = false;
            }
        } else if (corteContador >= 0) {
            corteContador -= delta;
        } else {
            instance.logMessage(lenhador.getNome() + " terminou de cortar uma tora de madeira ");
            lenhador.addItemIventario(Material.MADEIRA);
            terminada = true;
        }
    }

    @Override
    public boolean terminada() {
        return terminada;
    }

}
