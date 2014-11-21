package org.cafe.domain.financeiro;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private long numero;
    private double saldo;
    private double limiteCartao;
    private List<Double> lancamentosCartao = new ArrayList<>();

    public Conta(long numero, double saldo, double limiteCartao) {
        this.numero = numero;
        this.saldo = saldo;
        this.limiteCartao = limiteCartao;
    }

    public long getNumero() {
        return numero;
    }

    public boolean debitar(double valor) {
        // TODO
        return false;
    }

    public boolean creditar(double valor) {
        // TODO
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public double limiteDisponivel() {
        // TODO
        return 0;
    }
}
