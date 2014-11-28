package org.hammer.producao.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.hammer.action.Acao;
import org.hammer.dwarfs.Dwarf;
import org.hammer.dwarfs.Ferreiro;
import org.hammer.dwarfs.Lenhador;
import org.hammer.dwarfs.Mineiro;
import org.hammer.dwarfs.Vendedor;
import org.hammer.producao.Produto;
import org.hammer.producao.game.stations.CabanaLenhador;
import org.hammer.producao.game.stations.Floresta;
import org.hammer.producao.game.stations.Mina;
import org.hammer.producao.game.stations.OficinaFerreiro;
import org.hammer.producao.game.stations.OficinaMineiro;
import org.hammer.producao.game.stations.Stockpile;
import org.hammer.producao.game.stations.Taverna;
import org.javaeando.game.Game;
import org.javaeando.game.JavaGameLoop;
import org.javaeando.game.JavaGraphics;

public class GoldenHammer implements Game {

    private static GoldenHammer instance;
    private Random random = new Random();

    private Vendedor vendedor;
    private Ferreiro ferreiro;
    private Mineiro mineiro;
    private Lenhador lenhador;

    private Floresta floresta;
    private Stockpile deposito;
    private CabanaLenhador cabanaLenhador;
    private OficinaFerreiro oficinaFerreiro;
    private OficinaMineiro oficinaMineiro;
    private Mina mina;
    private Taverna taverna;

    private Map<Dwarf, List<Acao>> mapaAcoes = new HashMap<>();

    private GoldenHammer() {
    }

    public static void init() {
        instance = new GoldenHammer();
    }

    public static GoldenHammer instance() {
        return instance;
    }

    @Override
    public void destroy() {

    }

    @Override
    public int getFrameRate() {
        return 60;
    }

    @Override
    public void init(JavaGraphics graphics) {
        // Dwarfs
        vendedor = new Vendedor(110, 150, "Larry");
        mapaAcoes.put(vendedor, new ArrayList<Acao>());

        ferreiro = new Ferreiro(250, 450, "John");
        mapaAcoes.put(ferreiro, new ArrayList<Acao>());

        mineiro = new Mineiro(350, 450, "Charles");
        mapaAcoes.put(mineiro, new ArrayList<Acao>());

        lenhador = new Lenhador(450, 450, "Rudolf");
        mapaAcoes.put(lenhador, new ArrayList<Acao>());

        // Estacoes
        floresta = new Floresta();
        deposito = new Stockpile();
        cabanaLenhador = new CabanaLenhador();
        oficinaFerreiro = new OficinaFerreiro();
        oficinaMineiro = new OficinaMineiro();
        mina = new Mina();
        taverna = new Taverna();
    }

    @Override
    public void render(JavaGraphics graphics) {
        graphics.setColor(0x000000);
        graphics.fillRect(0, 0, 800, 600);

        vendedor.draw(graphics);
        ferreiro.draw(graphics);
        mineiro.draw(graphics);
        lenhador.draw(graphics);

        floresta.draw(graphics);
        deposito.draw(graphics);
        cabanaLenhador.draw(graphics);
        oficinaFerreiro.draw(graphics);
        oficinaMineiro.draw(graphics);
        mina.draw(graphics);
        taverna.draw(graphics);
    }

    @Override
    public void update(long delta) {

        // Gerando um pedido aleatorio
        if (vendedor.estaRecebendoPedidos()) {
            Produto produto = gerarProdutoAleatorio();
            vendedor.recebePedido(produto);
        }

        Set<Entry<Dwarf, List<Acao>>> entrySet = mapaAcoes.entrySet();
        for (Entry<Dwarf, List<Acao>> entry : entrySet) {
            List<Acao> acoes = entry.getValue();
            if (acoes.size() > 0) {
                Acao acao = acoes.get(0);
                acao.executar(delta);
                if (acao.terminada()) {
                    acoes.remove(acao);
                }
            } else {
                List<Acao> acoesRetornadas = entry.getKey().retornaAcoes();
                if (acoesRetornadas != null) {
                    acoes.addAll(acoesRetornadas);
                }
            }
        }
    }

    private Produto gerarProdutoAleatorio() {
        Produto[] values = Produto.values();
        return values[random.nextInt(values.length)];
    }

    public static void main(String[] args) {
        GoldenHammer.init();
        new JavaGameLoop(GoldenHammer.instance()).run();
    }

    public void logMessage(String message) {
        System.out.println(message);
    }

    public Floresta getFloresta() {
        return floresta;
    }

    public Stockpile getDeposito() {
        return deposito;
    }

    public CabanaLenhador getCabanaLenhador() {
        return cabanaLenhador;
    }

    public OficinaFerreiro getOficinaFerreiro() {
        return oficinaFerreiro;
    }

    public OficinaMineiro getOficinaMineiro() {
        return oficinaMineiro;
    }

    public Mina getMina() {
        return mina;
    }

    public Taverna getTaverna() {
        return taverna;
    }
}
