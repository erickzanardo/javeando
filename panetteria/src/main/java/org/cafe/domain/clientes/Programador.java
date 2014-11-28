package org.cafe.domain.clientes;

import java.util.List;

import org.cafe.domain.financeiro.Pagamento;
import org.cafe.domain.financeiro.PagamentoNoDinheiro;
import org.cafe.domain.produto.Menu;
import org.cafe.domain.produto.Pedido;
import org.cafe.domain.produto.Produto;
import org.cafe.domain.produto.TipoProduto;

public class Programador extends Cliente {

    @Override
    public Pedido escolherPedido(Menu menu) {

        List<Produto> caffeteria = menu.listarProdutosPorTipo(TipoProduto.CAFETERIA);

        Produto caffeteriaEscolhida = null;
        for (Produto produto : caffeteria) {
            if (caffeteriaEscolhida == null || caffeteriaEscolhida.getPreco() > produto.getPreco()) {
                caffeteriaEscolhida = produto;
            }
        }

        List<Produto> doces = menu.listarProdutosPorTipo(TipoProduto.DOCE);
        Produto doceEscolhido = null;
        for (Produto produto : doces) {
            if (doceEscolhido == null || doceEscolhido.getPreco() > produto.getPreco()) {
                doceEscolhido = produto;
            }
        }

        Pedido p = new Pedido();
        p.addItem(doceEscolhido);
        p.addItem(caffeteriaEscolhida);

        return p;
    }

    @Override
    public Pagamento escolherTipoDePagamento() {
        return new PagamentoNoDinheiro();
    }

}
