package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.EntregrarProdutoAoCliente;
import org.hammer.action.EsperarPorItensNoDeposito;
import org.hammer.action.IrParaATaverna;
import org.hammer.producao.Pedidos;
import org.hammer.producao.Produto;

public class Vendedor extends Dwarf {

    private boolean recebendoPedidos = true;
    private Produto produto;

    public Vendedor(float x, float y, String nome) {
        super(x, y, nome);
    }

    @Override
    public List<Acao> retornaAcoes() {

        if (produto != null) {
            Pedidos.instance().requisitar(produto);

            List<Acao> ret = new ArrayList<Acao>();
            EsperarPorItensNoDeposito esperarPorItensNoDeposito = new EsperarPorItensNoDeposito(produto);
            ret.add(esperarPorItensNoDeposito);
            ret.add(new EntregrarProdutoAoCliente());
            ret.add(new IrParaATaverna(this));
            return ret;
        }

        return null;
    }

    public void recebePedido(Produto produto) {
        this.produto = produto;
        recebendoPedidos = false;
    }

    public boolean estaRecebendoPedidos() {
        return recebendoPedidos;
    }

}
