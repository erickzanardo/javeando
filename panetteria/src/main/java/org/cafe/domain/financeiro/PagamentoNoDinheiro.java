package org.cafe.domain.financeiro;

import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.produto.Pedido;

public class PagamentoNoDinheiro extends Pagamento {

    public PagamentoNoDinheiro(Cliente cliente, Pedido pedido) {
        super(cliente, pedido);
    }

    @Override
    public boolean processar() {
        // TODO
        return false;
    }

}
