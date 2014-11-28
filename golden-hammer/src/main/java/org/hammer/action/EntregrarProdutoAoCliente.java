package org.hammer.action;

import org.hammer.dwarfs.Cliente;
import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.game.GoldenHammer;
import org.hammer.producao.game.stations.Loja;
import org.hammer.producao.game.utils.MovimentoUtils;

public class EntregrarProdutoAoCliente implements Acao {

    private Dwarf dwarf;

    public EntregrarProdutoAoCliente(Dwarf dwarf) {
        super();
        this.dwarf = dwarf;
    }

    private boolean entregue = false;

    @Override
    public void executar(long delta) {
        GoldenHammer instance = GoldenHammer.instance();
        Loja loja = Loja.instance();
        if (MovimentoUtils.moverAnaoParaEstacao(dwarf, loja, delta)) {
            entregue = true;
            Cliente cliente = loja.getCliente();
            cliente.inventario().addAll(dwarf.inventario());
            instance.logMessage("Produtos entregues para " + cliente.getNome());
        }
    }

    @Override
    public boolean terminada() {
        return entregue;
    }

}
