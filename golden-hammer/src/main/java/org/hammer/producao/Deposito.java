package org.hammer.producao;

import java.util.ArrayList;
import java.util.List;

public class Deposito {
    private List<Object> itens = new ArrayList<>();

    private static Deposito instance;

    private Deposito() {
    }

    public static Deposito instance() {
        if (instance == null) {
            instance = new Deposito();
        }
        return instance;
    }
    
    public boolean contem(Object object) {
        return itens.contains(object);
    }
}
