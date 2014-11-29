package org.hammer.action;

import org.hammer.dwarfs.Lenhador;
import org.hammer.producao.Material;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.utils.MovimentoUtils;

public class ProcessarMadeiraEmTabuas implements Acao {

    private boolean terminada = false;
    private boolean validou = false;
    private boolean indoParaCabana = true;
    private long contadorProcesso = 2500;
    private Lenhador lenhador;

    public ProcessarMadeiraEmTabuas(Lenhador lenhador) {
        super();
        this.lenhador = lenhador;
    }

    @Override
    public void executar(long delta) {
        GoldenHammer instance = GoldenHammer.instance();

        if (!validou) {
            validou = true;

            boolean madeira = lenhador.inventario().remove(Material.MADEIRA);
            if (!madeira) {
                instance.logMessage(lenhador.getNome() + " n\u00E3o tem nenhuma madeira para trabalhar ");
                terminada = true;
            }
        }

        if (indoParaCabana) {
            if (MovimentoUtils.moverAnaoParaEstacao(lenhador, instance.getCabanaLenhador(), delta)) {
                indoParaCabana = false;
                instance.getCabanaLenhador().animate();
                instance.logMessage(lenhador.getNome() + " chegou em sua cabana ");
            }
        } else if (contadorProcesso >= 0) {
            contadorProcesso -= delta;
        } else {
            terminada = true;
            lenhador.addItemIventario(Material.TABUA);
            instance.logMessage(lenhador.getNome() + " terminou de processar as toras em t\u00E1buas");
        }
    }

    @Override
    public boolean terminada() {
        return terminada;
    }

}
