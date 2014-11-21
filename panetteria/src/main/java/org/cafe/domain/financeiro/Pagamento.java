package org.cafe.domain.financeiro;

import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.produto.Pedido;

public abstract class Pagamento {
    protected Cliente cliente;
    protected Pedido pedido;

    public Pagamento(Cliente cliente, Pedido pedido) {
        super();
        this.cliente = cliente;
        this.pedido = pedido;
    }

    public abstract boolean processar();
}
