package org.cafe.game.core;

public class Assets {

    private static Assets instance;
    private JavaSpriteSheet programadorSpriteRight;
    private JavaSpriteSheet arquitetoSpriteRight;
    private JavaSpriteSheet coordenadorSpriteRight;
    private JavaSpriteSheet programadorSpriteLeft;
    private JavaSpriteSheet arquitetoSpriteLeft;
    private JavaSpriteSheet coordenadorSpriteLeft;

    private Assets() {
        programadorSpriteRight = JavaAssetLoader.instance().loadSpriteSheet("programador.png", 2, 1, 5);
        arquitetoSpriteRight = JavaAssetLoader.instance().loadSpriteSheet("arquiteto.png", 2, 1, 5);
        coordenadorSpriteRight = JavaAssetLoader.instance().loadSpriteSheet("coordenador.png", 2, 1, 5);

        programadorSpriteLeft = JavaAssetLoader.instance().loadSpriteSheet("programador_left.png", 2, 1, 5);
        arquitetoSpriteLeft = JavaAssetLoader.instance().loadSpriteSheet("arquiteto_left.png", 2, 1, 5);
        coordenadorSpriteLeft = JavaAssetLoader.instance().loadSpriteSheet("coordenador_left.png", 2, 1, 5);

    }

    public static Assets getInstance() {
        return instance;
    }

    public static void init() {
        instance = new Assets();
    }

    public static Assets instance() {
        return instance;
    }

    public JavaSpriteSheet getProgramadorSpriteRight() {
        return programadorSpriteRight.copy();
    }

    public JavaSpriteSheet getArquitetoSpriteRight() {
        return arquitetoSpriteRight.copy();
    }

    public JavaSpriteSheet getCoordenadorSpriteRight() {
        return coordenadorSpriteRight.copy();
    }

    public JavaSpriteSheet getProgramadorSpriteLeft() {
        return programadorSpriteLeft.copy();
    }

    public JavaSpriteSheet getArquitetoSpriteLeft() {
        return arquitetoSpriteLeft.copy();
    }

    public JavaSpriteSheet getCoordenadorSpriteLeft() {
        return coordenadorSpriteLeft.copy();
    }

}
