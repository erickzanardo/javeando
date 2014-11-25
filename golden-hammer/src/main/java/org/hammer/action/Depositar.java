package org.hammer.action;

public class Depositar implements Acao {

    private Object item;

    public Depositar(Object item) {
        super();
        this.item = item;
    }

    @Override
    public void executar(long delta) {
    }

    public Object getItem() {
        return item;
    }

}
