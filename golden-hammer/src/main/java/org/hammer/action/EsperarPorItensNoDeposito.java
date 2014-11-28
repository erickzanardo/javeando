package org.hammer.action;

import org.hammer.producao.Deposito;

public class EsperarPorItensNoDeposito implements Acao {

    private Object[] item;
    private boolean contem;

    @Override
    public void executar(long delta) {
        contem = true;
        for (Object o : item) {
            contem = contem && Deposito.instance().contem(o);
        }
    }

    public EsperarPorItensNoDeposito(Object... item) {
        super();
        this.item = item;
    }

    public Object getItem() {
        return item[0];
    }

    public Object[] getItens() {
        return item;
    }

    @Override
    public boolean terminada() {
        return contem;
    }

}
