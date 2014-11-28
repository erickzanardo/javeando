package org.cafe.domain.financeiro;

import java.util.List;

import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.produto.Pedido;
import org.cafe.domain.produto.Produto;

public class PagamentoNoDinheiro extends Pagamento {

    @Override
    public boolean processar(Cliente cliente, Pedido pedido) {
        
        List<Produto> itens = pedido.itens();
        double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }
        
        if (cliente.getDinheiro() >= total) {
            cliente.setDinheiro(cliente.getDinheiro() - total);
            return true;
        }
        
        return false;
    }

}
