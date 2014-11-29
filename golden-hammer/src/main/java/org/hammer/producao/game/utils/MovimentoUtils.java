package org.hammer.producao.game.utils;

import org.hammer.dwarfs.Dwarf;
import org.hammer.producao.game.stations.EstacaoDeTrabalho;

public class MovimentoUtils {

    private static final float DWARF_SPEED = (80f / 1000f); // 10 pixels por
                                                            // segundo;

    public static boolean moverAnaoParaEstacao(Dwarf dwarf, EstacaoDeTrabalho estacaoDeTrabalho, long delta) {

        float x = estacaoDeTrabalho.getX();
        float y = estacaoDeTrabalho.getY();

        float dwarfX = dwarf.getX();
        float dwarfY = dwarf.getY();

        if (Math.round(dwarfX) < x) {
            dwarf.setRight(true);
            dwarf.setX(dwarfX + DWARF_SPEED * delta);
        } else if (Math.round(dwarfX) > x) {
            dwarf.setRight(false);
            dwarf.setX(dwarfX - DWARF_SPEED * delta);
        } else if (Math.round(dwarfY) > y) {
            dwarf.setY(dwarfY - DWARF_SPEED * delta);
        } else if (Math.round(dwarfY) < y) {
            dwarf.setY(dwarfY + DWARF_SPEED * delta);
        } else {
            dwarf.setMoving(false);
            return true;
        }
        dwarf.setMoving(true);
        return false;
    }
}
