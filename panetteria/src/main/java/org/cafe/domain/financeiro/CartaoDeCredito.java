package org.cafe.domain.financeiro;

import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.produto.Pedido;

public class CartaoDeCredito extends Pagamento {

    @Override
    public boolean processar(Cliente cliente, Pedido pedido) {
        // TODO
        return false;
    }

}
