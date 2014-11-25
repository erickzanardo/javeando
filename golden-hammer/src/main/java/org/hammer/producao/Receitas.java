package org.hammer.producao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receitas {
    private Map<Object, List<Material>> receitas = new HashMap<Object, List<Material>>();

    private static Receitas instance;

    private Receitas() {
        List<Material> materias = new ArrayList<Material>();
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.LINGOTE_FERRO);
        receitas.put(Produto.ESPADA, materias);

        materias = new ArrayList<Material>();
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.TABUA);
        materias.add(Material.TABUA);
        materias.add(Material.TABUA);
        receitas.put(Produto.ESCUDO_MADEIRA, materias);

        materias = new ArrayList<Material>();
        materias.add(Material.TABUA);
        receitas.put(Produto.ARCO_CURTO, materias);

        materias = new ArrayList<Material>();
        materias.add(Material.TABUA);
        materias.add(Material.TABUA);
        receitas.put(Produto.ARCO_LONGO, materias);

        materias = new ArrayList<Material>();
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.TABUA);
        receitas.put(Produto.MACHADO, materias);

        materias = new ArrayList<Material>();
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.TABUA);
        receitas.put(Produto.MACHADO_DUPLO, materias);

        materias = new ArrayList<Material>();
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.LINGOTE_FERRO);
        materias.add(Material.LINGOTE_FERRO);
        receitas.put(Produto.COTA_MALHA, materias);

    }

    public static Receitas instance() {
        if (instance == null) {
            instance = new Receitas();
        }
        return instance;
    }

    public List<Material> getMateriais(Object object) {
        return receitas.get(object);
    }

}
