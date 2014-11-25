package org.hammer.action;

public class RecolherNoDeposito implements Acao {

    private Object[] itens;

    public RecolherNoDeposito(Object... itens) {
        super();
        this.itens = itens;
    }

    @Override
    public void executar(long delta) {
    }

    public Object[] getItens() {
        return itens;
    }

}
