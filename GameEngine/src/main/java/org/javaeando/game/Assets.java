package org.javaeando.game;

public class Assets {

    private static Assets instance;
    private JavaSpriteSheet programadorSpriteRight;
    private JavaSpriteSheet arquitetoSpriteRight;
    private JavaSpriteSheet coordenadorSpriteRight;
    private JavaSpriteSheet programadorSpriteLeft;
    private JavaSpriteSheet arquitetoSpriteLeft;
    private JavaSpriteSheet coordenadorSpriteLeft;
    private JavaSpriteSheet francesco;
    private JavaImage background;
    private JavaSpriteSheet happy;
    private JavaSpriteSheet sad;

    private Assets() {
        programadorSpriteRight = JavaAssetLoader.instance().loadSpriteSheet("programador.png", 2, 1, 5);
        arquitetoSpriteRight = JavaAssetLoader.instance().loadSpriteSheet("arquiteto.png", 2, 1, 5);
        coordenadorSpriteRight = JavaAssetLoader.instance().loadSpriteSheet("coordenador.png", 2, 1, 5);

        programadorSpriteLeft = JavaAssetLoader.instance().loadSpriteSheet("programador_left.png", 2, 1, 5);
        arquitetoSpriteLeft = JavaAssetLoader.instance().loadSpriteSheet("arquiteto_left.png", 2, 1, 5);
        coordenadorSpriteLeft = JavaAssetLoader.instance().loadSpriteSheet("coordenador_left.png", 2, 1, 5);

        francesco = JavaAssetLoader.instance().loadSpriteSheet("francesco.png", 3, 1, 5);

        happy = JavaAssetLoader.instance().loadSpriteSheet("happy.png", 5, 1, 5);
        sad = JavaAssetLoader.instance().loadSpriteSheet("sad.png", 5, 1, 5);

        background = JavaAssetLoader.instance().loadImage("background.png");
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

    public JavaSpriteSheet getFrancesco() {
        return francesco.copy();
    }

    public JavaSpriteSheet getHappy() {
        return happy.copy();
    }

    public JavaSpriteSheet getSad() {
        return sad.copy();
    }

    public JavaImage getBackground() {
        return background;
    }
}
