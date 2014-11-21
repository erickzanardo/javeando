package org.cafe.game.clientes;

import java.util.Random;

import org.cafe.domain.clientes.Arquiteto;
import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.clientes.Coordenador;
import org.cafe.domain.clientes.Programador;
import org.cafe.domain.financeiro.Banco;
import org.cafe.domain.financeiro.Conta;

public class ClienteFactory {

    static long numeroConta = 0l;

    static Random r = new Random();

    public static Cliente criarClienteAleatorio() {
        Cliente c = null;

        int value = r.nextInt(3);
        if (value == 0) {
            c = new Programador();
        } else if (value == 1) {
            c = new Arquiteto();
        } else {
            c = new Coordenador();
        }
        String nome = GeradorDeNomes.gerarNome();
        c.setNome(nome);

        c.setNumeroDaConta(numeroConta++);

        Conta conta = new Conta(numeroConta, Math.min(10, r.nextInt(20)), Math.min(10, r.nextInt(20)));
        Banco.instance().adicionaConta(conta);

        c.setDinheiro(Math.min(10, r.nextInt(20)));

        return c;
    }
}
