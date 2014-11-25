package org.hammer.producao;

import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    private List<Object> itens = new ArrayList<Object>();

    private static Pedidos instance;

    private Pedidos() {
    }

    public static Pedidos instance() {
        if (instance == null) {
            instance = new Pedidos();
        }
        return instance;
    }

    public void requisitar(Object objeto) {
        itens.add(objeto);
    }

    public List<Object> getPedidos() {
        return itens;
    }
}
