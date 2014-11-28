package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.EntregrarProdutoAoCliente;
import org.hammer.action.EsperarPorItensNoDeposito;
import org.hammer.action.IrParaALoja;
import org.hammer.action.IrParaATaverna;
import org.hammer.producao.Pedidos;
import org.hammer.producao.Produto;
import org.hammer.producao.game.stations.Loja;

public class Vendedor extends Dwarf {

    private Produto produto;

    public Vendedor(float x, float y, String nome) {
        super(x, y, nome);
    }

    @Override
    public List<Acao> retornaAcoes() {

        Cliente cliente = Loja.instance().getCliente();
        if (cliente != null) {
            produto = cliente.getProduto();
            Pedidos.instance().requisitar(produto);

            List<Acao> ret = new ArrayList<Acao>();
            ret.add(new IrParaALoja(this));
            EsperarPorItensNoDeposito esperarPorItensNoDeposito = new EsperarPorItensNoDeposito(produto);
            ret.add(esperarPorItensNoDeposito);
            ret.add(new EntregrarProdutoAoCliente());
            ret.add(new IrParaATaverna(this));
            return ret;
        }

        return null;
    }

}
