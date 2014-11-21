package org.cafe.game.clientes;

import org.cafe.domain.clientes.Arquiteto;
import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.clientes.Programador;
import org.cafe.domain.financeiro.Pagamento;
import org.cafe.domain.produto.Pedido;
import org.cafe.game.Panetteria;
import org.cafe.game.core.JavaGraphics;

public class InGameCliente {
    private Cliente cliente;
    private float x = 0, y = 150;
    private Panetteria panetteria;
    private boolean indo = true;

    static float speed = (20f / 1000f); // 10 pixels por segundo

    static int POSICAO_CAIXA = 500;
    static int POSICAO_DE_VOLTA = 300;

    public InGameCliente(Cliente cliente, Panetteria panetteria) {
        this.cliente = cliente;
        this.panetteria = panetteria;
    }

    public void draw(JavaGraphics graphics) {
        // TODO
        if (cliente instanceof Programador) {
            graphics.setColor(0xffffff);
        } else if (cliente instanceof Arquiteto) {
            graphics.setColor(0x2E07A6);
        } else {
            graphics.setColor(0xE01F56);
        }

        graphics.fillRect(x, y, 50, 100);
    }

    public void update(long delta) {
        if (indo) {
            x += speed * delta;
            if (x >= POSICAO_CAIXA) {
                // Escolhendo o pedido
                Pedido pedido = cliente.escolherPedido(panetteria.getMenu());

                if (pedido == null) {
                    panetteria.logMessage(cliente.getNome() + " nao encontrou nenhum produto disponivel no menu! ");
                } else {
                    Pagamento pagamento = cliente.escolherTipoDePagamento();
                    boolean sucesso = pagamento.processar(cliente, pedido);
                    if (sucesso) {

                    } else {
                        panetteria.logMessage(cliente.getNome() + " nao conseguiu processar o pagamento! ");
                    }
                }

                indo = false;
            }
        } else {
            if (y <= POSICAO_DE_VOLTA) {
                y += speed * delta;
            } else {
                x -= speed * delta;
            }

            if (x < 0) {
                panetteria.removerCliente(this);
            }
        }
    }
}
