package org.cafe.game.clientes;

import org.cafe.domain.clientes.Arquiteto;
import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.clientes.Programador;
import org.cafe.domain.financeiro.Pagamento;
import org.cafe.domain.produto.Pedido;
import org.cafe.game.Panetteria;
import org.javaeando.game.Assets;
import org.javaeando.game.JavaGraphics;
import org.javaeando.game.JavaSpriteSheet;

public class InGameCliente {
    private Cliente cliente;
    private float x = 0, y = 250;
    private Panetteria panetteria;
    private boolean indo = true;
    private JavaSpriteSheet spriteSheet;
    private JavaSpriteSheet state;

    static float speed = (20f / 1000f); // 10 pixels por segundo

    static int POSICAO_CAIXA = 500;
    static int POSICAO_DE_VOLTA = 300;

    public InGameCliente(Cliente cliente, Panetteria panetteria) {
        this.cliente = cliente;
        this.panetteria = panetteria;

        atualizarSprite();
    }

    private void atualizarSprite() {
        if (indo) {
            if (cliente instanceof Programador) {
                spriteSheet = Assets.instance().getProgramadorSpriteRight();
            } else if (cliente instanceof Arquiteto) {
                spriteSheet = Assets.instance().getArquitetoSpriteRight();
            } else {
                spriteSheet = Assets.instance().getCoordenadorSpriteRight();
            }
        } else {
            if (cliente instanceof Programador) {
                spriteSheet = Assets.instance().getProgramadorSpriteLeft();
            } else if (cliente instanceof Arquiteto) {
                spriteSheet = Assets.instance().getArquitetoSpriteLeft();
            } else {
                spriteSheet = Assets.instance().getCoordenadorSpriteLeft();
            }
        }
    }

    public void draw(JavaGraphics graphics) {
        graphics.drawImage(spriteSheet.currentFrame(), x, y);
        if (state != null) {
            graphics.drawImage(state.currentFrame(), x - 10, y - 40);
        }
    }

    public void update(long delta) {
        spriteSheet.update(delta);
        if (state != null) {
            state.update(delta);
        }
        if (indo) {
            x += speed * delta;
            if (x >= POSICAO_CAIXA) {
                panetteria.atendimentoCompleto();
                // Escolhendo o pedido
                Pedido pedido = cliente.escolherPedido(panetteria.getMenu());

                if (pedido == null) {
                    panetteria.logMessage(cliente.getNome() + " did not find any avaiable product on the menu! ");
                    state = Assets.instance().getSad();
                } else {
                    Pagamento pagamento = cliente.escolherTipoDePagamento();
                    boolean sucesso = pagamento.processar(cliente, pedido);
                    if (sucesso) {
                        state = Assets.instance().getHappy();
                        panetteria.logMessage(cliente.getNome() + " just bought: " + pedido.itens().get(0).getNome()
                                + " and " + pedido.itens().get(1).getNome());
                    } else {
                        panetteria.logMessage(cliente.getNome() + " could not complete his payment! ");
                        state = Assets.instance().getSad();
                    }
                }

                indo = false;
                atualizarSprite();
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
