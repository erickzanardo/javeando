package org.cafe.domain.financeiro;

import java.util.HashMap;
import java.util.Map;

public class Banco {
    private static Banco instance;
    private Map<Long, Conta> contas = new HashMap<>();

    private Banco() {
    }

    public static Banco instance() {
        if (instance == null) {
            instance = new Banco();
        }

        return instance;
    }

    public Conta getConta(long numero) {
        return contas.get(numero);
    }

    public void adicionaConta(Conta conta) {
        contas.put(conta.getNumero(), conta);
    }
}
