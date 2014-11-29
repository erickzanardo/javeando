package org.hammer.action;

import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.Produto;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.utils.MovimentoUtils;

public class Forjar implements Acao {

    private Produto produto;
    private Dwarf dwarf;
    private boolean terminou = false;
    private boolean indoParaAForja = true;
    private long contadorForjando = 4000;

    public Forjar(Produto produto, Dwarf dwarf) {
        super();
        this.produto = produto;
        this.dwarf = dwarf;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public void executar(long delta) {
        GoldenHammer instance = GoldenHammer.instance();
        if (indoParaAForja) {
            if (MovimentoUtils.moverAnaoParaEstacao(dwarf, instance.getOficinaFerreiro(), delta)) {
                instance.logMessage(dwarf.getNome() + " chegou na forja ");
                indoParaAForja = false;
                instance.getOficinaFerreiro().animate();
            }
        } else if (contadorForjando >= 0) {
            contadorForjando -= delta;
        } else {
            instance.logMessage(dwarf.getNome() + " terminou de forjar um(a) " + produto);
            dwarf.addItemIventario(produto);
            terminou = true;
        }
    }

    @Override
    public boolean terminada() {
        return terminou;
    }

}
