package org.hammer.action;

import java.util.ArrayList;
import java.util.List;

import org.hammer.producao.Material;

public class teste {

    public static void main(String[] args) {
        List<Material> materiais = new ArrayList<>();
        materiais.add(Material.LINGOTE_FERRO);
        materiais.add(Material.LINGOTE_FERRO);
        materiais.add(Material.LINGOTE_FERRO);
        
        materiais.remove(Material.LINGOTE_FERRO);
        System.out.println(materiais.size());
    }

}
