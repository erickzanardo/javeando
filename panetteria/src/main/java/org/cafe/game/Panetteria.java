package org.cafe.game;

import java.util.ArrayList;
import java.util.List;

import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.produto.Menu;
import org.cafe.game.clientes.ClienteFactory;
import org.cafe.game.clientes.InGameCliente;
import org.cafe.game.core.Assets;
import org.cafe.game.core.Game;
import org.cafe.game.core.JavaGameLoop;
import org.cafe.game.core.JavaGraphics;
import org.cafe.game.core.JavaImage;

public class Panetteria implements Game {

    private static int CRIAR_CLIENTE_TEMPO = 6000; // 5 segs

    private List<InGameCliente> clientes = new ArrayList<>();
    private List<InGameCliente> clientesASeremRemovidos = new ArrayList<>();
    private Francesco francesco;

    private int criarClienteCounter;

    private Menu menu;
    private MessageBoard messageBoard = new MessageBoard();

    private JavaImage background;

    @Override
    public void init(JavaGraphics graphics) {
        Assets.init();
        francesco = new Francesco();
        background = Assets.instance().getBackground();
    }

    @Override
    public void destroy() {
    }

    @Override
    public void update(long delta) {
        francesco.update(delta);
        if (clientesASeremRemovidos.size() > 0) {
            clientes.removeAll(clientesASeremRemovidos);
            clientesASeremRemovidos.clear();
        }

        criarClienteCounter += delta;

        if (criarClienteCounter >= CRIAR_CLIENTE_TEMPO) {
            criarClienteCounter -= CRIAR_CLIENTE_TEMPO;
            if (clientes.size() < 20) {
                Cliente criarClienteAleatorio = ClienteFactory.criarClienteAleatorio();

                InGameCliente inGameCliente = new InGameCliente(criarClienteAleatorio, this);
                clientes.add(inGameCliente);

                logCliente(criarClienteAleatorio);
            }
        }

        for (InGameCliente obj : clientes) {
            obj.update(delta);
        }
    }

    @Override
    public void render(JavaGraphics graphics) {
        // Background
        graphics.drawImage(background, 0, 0);

        for (int i = clientes.size() - 1; i >= 0; i--) {
            clientes.get(i).draw(graphics);
        }

        francesco.draw(graphics);

        messageBoard.draw(graphics);
    }

    @Override
    public int getFrameRate() {
        return 60;
    }

    public static void main(String[] args) {
        Panetteria panetteria = new Panetteria();
        JavaGameLoop gameLoop = new JavaGameLoop(panetteria);
        gameLoop.run();
    }

    private void logCliente(Cliente criarClienteAleatorio) {
        logMessage("Chegou cliente " + criarClienteAleatorio.getNome() + " o "
                + criarClienteAleatorio.getClass().getSimpleName());
    }

    public void logMessage(String message) {
        messageBoard.addMessage(message);
    }

    public Menu getMenu() {
        if (menu == null) {
            MenuFactory menuFactory = new MenuFactory();
            menu = menuFactory.getMenu();
        }

        return menu;
    }

    public void removerCliente(InGameCliente cliente) {
        clientesASeremRemovidos.add(cliente);
    }

    public void atendimentoCompleto() {
        francesco.animate();
    }
}
