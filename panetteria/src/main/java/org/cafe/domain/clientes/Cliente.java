package org.cafe.domain.clientes;

import org.cafe.domain.financeiro.Pagamento;
import org.cafe.domain.produto.Menu;
import org.cafe.domain.produto.Pedido;

public abstract class Cliente {
    private String nome;
    private double dinheiro;
    private long numeroDaConta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public long getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(long numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public abstract Pedido escolherPedido(Menu menu);
    
    public abstract Pagamento escolherTipoDePagamento();

}
