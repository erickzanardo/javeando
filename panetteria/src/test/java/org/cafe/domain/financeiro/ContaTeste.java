package org.cafe.domain.financeiro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContaTeste {

    @Test
    public void testeDebitar() {
        Conta conta = new Conta(1, 10, 0);
        assertFalse(conta.debitar(11));
        assertTrue(conta.debitar(5));
        assertEquals(new Double(5), new Double(conta.getSaldo()));
    }

    @Test
    public void testeCreditar() {
        Conta conta = new Conta(1, 10, 10);
        assertFalse(conta.creditar(11));
        assertTrue(conta.creditar(5));
        assertEquals(new Double(5), new Double(conta.limiteDisponivel()));
    }

}
