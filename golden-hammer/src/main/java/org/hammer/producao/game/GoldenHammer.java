package org.hammer.producao.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.hammer.action.Acao;
import org.hammer.dwarfs.Cliente;
import org.hammer.dwarfs.Dwarf;
import org.hammer.dwarfs.Ferreiro;
import org.hammer.dwarfs.Lenhador;
import org.hammer.dwarfs.Mineiro;
import org.hammer.dwarfs.Vendedor;
import org.hammer.producao.Produto;
import org.hammer.producao.game.stations.CabanaLenhador;
import org.hammer.producao.game.stations.EstacaoDeTrabalho;
import org.hammer.producao.game.stations.Floresta;
import org.hammer.producao.game.stations.Loja;
import org.hammer.producao.game.stations.Mina;
import org.hammer.producao.game.stations.OficinaFerreiro;
import org.hammer.producao.game.stations.OficinaMineiro;
import org.hammer.producao.game.stations.PontoDeSaida;
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
    private PontoDeSaida pontoDeSaida;
    private Dwarf clienteASerRemovido;

    private Map<Dwarf, List<Acao>> mapaAcoes = new HashMap<>();
    private List<EstacaoDeTrabalho> estacoes = new ArrayList<>();

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
        vendedor = new Vendedor(250, 450, "Larry");
        mapaAcoes.put(vendedor, new ArrayList<Acao>());

        ferreiro = new Ferreiro(250, 450, "John");
        mapaAcoes.put(ferreiro, new ArrayList<Acao>());

        mineiro = new Mineiro(250, 450, "Charles");
        mapaAcoes.put(mineiro, new ArrayList<Acao>());

        lenhador = new Lenhador(250, 450, "Rudolf");
        mapaAcoes.put(lenhador, new ArrayList<Acao>());

        // Estacoes
        floresta = new Floresta();
        estacoes.add(floresta);
        deposito = new Stockpile();
        estacoes.add(deposito);
        cabanaLenhador = new CabanaLenhador();
        estacoes.add(cabanaLenhador);
        oficinaFerreiro = new OficinaFerreiro();
        estacoes.add(oficinaFerreiro);
        oficinaMineiro = new OficinaMineiro();
        estacoes.add(oficinaMineiro);
        mina = new Mina();
        estacoes.add(mina);
        taverna = new Taverna();
        estacoes.add(taverna);
        pontoDeSaida = new PontoDeSaida();
        estacoes.add(pontoDeSaida);
        estacoes.add(Loja.instance());
    }

    @Override
    public void render(JavaGraphics graphics) {
        graphics.setColor(0x5FAD62);
        graphics.fillRect(0, 0, 800, 600);

        Cliente cliente = Loja.instance().getCliente();
        if (cliente != null) {
            cliente.draw(graphics);
        }
        vendedor.draw(graphics);
        ferreiro.draw(graphics);
        mineiro.draw(graphics);
        lenhador.draw(graphics);

        for (EstacaoDeTrabalho estacaoDeTrabalho : estacoes) {
            estacaoDeTrabalho.draw(graphics);
        }

    }

    @Override
    public void update(long delta) {

        for (EstacaoDeTrabalho estacaoDeTrabalho : estacoes) {
            estacaoDeTrabalho.update(delta);
        }

        if (clienteASerRemovido != null) {
            mapaAcoes.remove(clienteASerRemovido);
            Loja.instance().setCliente(null);
            clienteASerRemovido = null;
        }

        if (Loja.instance().getCliente() == null) {
            Produto produto = gerarProdutoAleatorio();
            Cliente cliente = new Cliente(0, 0, "Fulano", produto);
            Loja.instance().setCliente(cliente);
            mapaAcoes.put(cliente, new ArrayList<Acao>());
            logMessage(cliente.getNome() + " chegou na loja ");
        }

        Set<Entry<Dwarf, List<Acao>>> entrySet = mapaAcoes.entrySet();
        for (Entry<Dwarf, List<Acao>> entry : entrySet) {
            entry.getKey().update(delta);
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

    public PontoDeSaida getPontoDeSaida() {
        return pontoDeSaida;
    }

    public void removerClienteDaLoja(Dwarf cliente) {
        clienteASerRemovido = cliente;
    }
}
