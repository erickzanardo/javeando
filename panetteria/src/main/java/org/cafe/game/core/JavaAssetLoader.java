package org.cafe.game.core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class JavaAssetLoader {

    private static JavaAssetLoader instance;

    private JavaAssetLoader() {
    }

    public static JavaAssetLoader instance() {
        if (instance == null) {
            instance = new JavaAssetLoader();
        }

        return instance;
    }

    public JavaImage loadImage(String src) {
        InputStream is = JavaAssetLoader.class.getClassLoader().getResourceAsStream(src);
        try {
            BufferedImage read = ImageIO.read(is);
            return new JavaImage(read);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JavaSpriteSheet loadSpriteSheet(String src, int c, int r, int fps) {
        InputStream is = null;
        try {
            is = JavaAssetLoader.class.getClassLoader().getResourceAsStream(src);
            if (is == null) {
                throw new RuntimeException("InputStream is null");
            } else {
                BufferedImage image = ImageIO.read(is);
                JavaSpriteSheet spriteSheet = new JavaSpriteSheet(image, c, r);
                spriteSheet.setFramesPerSecond(fps);
                return spriteSheet;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
