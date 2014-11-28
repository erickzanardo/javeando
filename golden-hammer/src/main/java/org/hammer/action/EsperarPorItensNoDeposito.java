package org.hammer.action;

import java.util.ArrayList;
import java.util.List;

import org.hammer.producao.Deposito;

public class EsperarPorItensNoDeposito implements Acao {

    private List<Object> itens = new ArrayList<>();
    private List<Object> itensToRemove = new ArrayList<>();

    @Override
    public void executar(long delta) {
        for (Object o : itens) {
            if (Deposito.instance().contem(o)) {
                itensToRemove.add(o);
            }
        }
        if (itensToRemove.size() > 0) {
            itens.removeAll(itensToRemove);
            itensToRemove.clear();
        }
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
        return itens.size() == 0;
    }

}
