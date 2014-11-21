package org.cafe.domain.financeiro;

import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.produto.Pedido;

public abstract class Pagamento {

    public abstract boolean processar(Cliente cliente, Pedido pedido);
}
