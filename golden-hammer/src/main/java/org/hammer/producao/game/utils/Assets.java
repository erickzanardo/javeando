package org.hammer.producao.game.utils;

import org.javaeando.game.JavaAssetLoader;
import org.javaeando.game.JavaImage;
import org.javaeando.game.JavaSpriteSheet;

public class Assets {

    private static Assets instance;
    private JavaSpriteSheet oficinaFerreiro;
    private JavaSpriteSheet oficinaMineiro;
    private JavaImage stockpile;
    private JavaImage store;
    private JavaImage tavern;
    private JavaSpriteSheet woodcutterHouse;
    private JavaSpriteSheet woods;
    private JavaSpriteSheet blacksmithLeft;
    private JavaSpriteSheet blacksmithRight;
    private JavaSpriteSheet clientLeft;
    private JavaSpriteSheet clientRight;
    private JavaSpriteSheet minerLeft;
    private JavaSpriteSheet minerRight;
    private JavaSpriteSheet salesmanLeft;
    private JavaSpriteSheet salesmanRight;
    private JavaSpriteSheet woodcutterLeft;
    private JavaSpriteSheet woodcutterRight;
    private JavaSpriteSheet mina;

    private Assets() {
        oficinaFerreiro = JavaAssetLoader.instance().loadSpriteSheet("blacksmith_house.png", 2, 1, 2);
        oficinaMineiro = JavaAssetLoader.instance().loadSpriteSheet("miner_house.png", 2, 1, 2);
        mina = JavaAssetLoader.instance().loadSpriteSheet("mine.png", 2, 1, 2);
        stockpile = JavaAssetLoader.instance().loadImage("stockpile.png");
        store = JavaAssetLoader.instance().loadImage("store.png");
        tavern = JavaAssetLoader.instance().loadImage("tavern.png");
        woodcutterHouse = JavaAssetLoader.instance().loadSpriteSheet("woodcutter_house.png", 2, 1, 3);
        woods = JavaAssetLoader.instance().loadSpriteSheet("woods.png", 2, 1, 3);

        blacksmithLeft = JavaAssetLoader.instance().loadSpriteSheet("blacksmith_left.png", 2, 1, 3);
        blacksmithRight = JavaAssetLoader.instance().loadSpriteSheet("blacksmith_right.png", 2, 1, 3);

        clientLeft = JavaAssetLoader.instance().loadSpriteSheet("client_left.png", 2, 1, 3);
        clientRight = JavaAssetLoader.instance().loadSpriteSheet("client_right.png", 2, 1, 3);

        minerLeft = JavaAssetLoader.instance().loadSpriteSheet("miner_left.png", 2, 1, 3);
        minerRight = JavaAssetLoader.instance().loadSpriteSheet("miner_right.png", 2, 1, 3);

        salesmanLeft = JavaAssetLoader.instance().loadSpriteSheet("salesman_left.png", 2, 1, 3);
        salesmanRight = JavaAssetLoader.instance().loadSpriteSheet("salesman_right.png", 2, 1, 3);

        woodcutterLeft = JavaAssetLoader.instance().loadSpriteSheet("woodcutter_left.png", 2, 1, 3);
        woodcutterRight = JavaAssetLoader.instance().loadSpriteSheet("woodcutter_right.png", 2, 1, 3);
    }

    public static Assets instance() {
        if (instance == null) {
            instance = new Assets();
        }
        return instance;
    }

    public JavaSpriteSheet getOficinaFerreiro() {
        return oficinaFerreiro;
    }

    public JavaSpriteSheet getOficinaMineiro() {
        return oficinaMineiro;
    }

    public JavaImage getStockpile() {
        return stockpile;
    }

    public JavaImage getStore() {
        return store;
    }

    public JavaImage getTavern() {
        return tavern;
    }

    public JavaSpriteSheet getWoodcutterHouse() {
        return woodcutterHouse;
    }

    public JavaSpriteSheet getWoods() {
        return woods;
    }

    public static Assets getInstance() {
        return instance;
    }

    public JavaSpriteSheet getBlacksmithLeft() {
        return blacksmithLeft;
    }

    public JavaSpriteSheet getBlacksmithRight() {
        return blacksmithRight;
    }

    public JavaSpriteSheet getClientLeft() {
        return clientLeft;
    }

    public JavaSpriteSheet getClientRight() {
        return clientRight;
    }

    public JavaSpriteSheet getMinerLeft() {
        return minerLeft;
    }

    public JavaSpriteSheet getMinerRight() {
        return minerRight;
    }

    public JavaSpriteSheet getSalesmanLeft() {
        return salesmanLeft;
    }

    public JavaSpriteSheet getSalesmanRight() {
        return salesmanRight;
    }

    public JavaSpriteSheet getWoodcutterLeft() {
        return woodcutterLeft;
    }

    public JavaSpriteSheet getWoodcutterRight() {
        return woodcutterRight;
    }

    public JavaSpriteSheet getMina() {
        return mina;
    }

}
