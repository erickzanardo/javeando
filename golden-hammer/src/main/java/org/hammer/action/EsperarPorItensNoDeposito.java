package org.hammer.action;

public class EsperarPorItensNoDeposito implements Acao {

    private Object[] item;

    @Override
    public void executar(long delta) {
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

}
