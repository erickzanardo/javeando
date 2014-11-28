package org.hammer.action;

import java.util.ArrayList;
import java.util.List;

import org.hammer.producao.Deposito;

public class EsperarPorItensNoDeposito implements Acao {

    private List<Object> itens = new ArrayList<>();
    private List<Object> verify = new ArrayList<>();
    private int count = 0;
    private boolean terminou;

    @Override
    public void executar(long delta) {
        count = 0;
        Deposito instance = Deposito.instance();
        verify.addAll(instance.itens());

        for (Object o : itens) {
            if (verify.contains(o)) {
                count++;
                verify.remove(o);
            }
        }

        if (count == itens.size()) {
            terminou = true;
        }
        verify.clear();
    }

    public EsperarPorItensNoDeposito(Object... itens) {
        super();
        for (Object object : itens) {
            this.itens.add(object);
        }
    }

    public Object getItem() {
        return itens.get(0);
    }

    public List<Object> getItens() {
        return itens;
    }

    @Override
    public boolean terminada() {
        return terminou;
    }

}
