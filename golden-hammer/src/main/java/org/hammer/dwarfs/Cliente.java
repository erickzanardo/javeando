package org.hammer.dwarfs;

import java.util.ArrayList;
import java.util.List;

import org.hammer.action.Acao;
import org.hammer.action.EsperarPorProdutoNoInventario;
import org.hammer.action.IrEmboraDaLoja;
import org.hammer.action.IrParaALoja;
import org.hammer.producao.Produto;
import org.hammer.producao.game.utils.Assets;

public class Cliente extends Dwarf {

    private Produto produto;

    public Cliente(float x, float y, String nome, Produto produto) {
        super(x, y, nome);
        this.produto = produto;
        setSpriteSheetLeft(Assets.instance().getClientLeft());
        setSpriteSheetRight(Assets.instance().getClientRight());
    }

    @Override
    public List<Acao> retornaAcoes() {
        List<Acao> acoes = new ArrayList<>();

        acoes.add(new IrParaALoja(this));
        acoes.add(new EsperarPorProdutoNoInventario(this, produto));
        acoes.add(new IrEmboraDaLoja(this));

        return acoes;
    }

    public Produto getProduto() {
        return produto;
    }

}
