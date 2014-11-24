package org.javaeando.game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class JavaSpriteSheet {

    private int spriteWidth, spriteHeight, fps, startingIndex, finalIndex, currentIndex;
    private int deltaCounter, milisRate;
    private List<JavaImage> sprites = new ArrayList<JavaImage>();

    private JavaSpriteSheet() {
    }

    public JavaSpriteSheet copy() {
        JavaSpriteSheet copy = new JavaSpriteSheet();

        copy.spriteWidth = spriteWidth;
        copy.spriteHeight = spriteHeight;
        copy.fps = fps;
        copy.startingIndex = startingIndex;
        copy.finalIndex = finalIndex;
        copy.currentIndex = currentIndex;
        copy.deltaCounter = deltaCounter;
        copy.milisRate = milisRate;
        copy.sprites = sprites;

        return copy;
    }

    public JavaSpriteSheet(BufferedImage image, int columns, int rows) {
        startingIndex = 0;
        this.spriteWidth = image.getWidth() / columns;
        this.spriteHeight = image.getHeight() / rows;
        deltaCounter = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                BufferedImage sprite = image.getSubimage(c * spriteWidth, r * spriteHeight, spriteWidth, spriteHeight);
                JavaImage javaImage = new JavaImage(sprite);
                sprites.add(javaImage);
            }
        }
        finalIndex = sprites.size();

    }

    public void setFramesPerSecond(int fps) {
        this.fps = fps;
        this.milisRate = 1000 / fps;
    }

    public int getFramesPerSecond() {
        return fps;
    }

    public void update(long delta) {
        if (deltaCounter >= milisRate) {
            if (currentIndex + 1 < finalIndex) {
                currentIndex++;
            } else {
                currentIndex = startingIndex;
            }
            deltaCounter = 0;
        }
        deltaCounter += delta;
    }

    public JavaImage currentFrame() {
        return sprites.get(currentIndex);
    }

    public void drawCurrentFrame(JavaGraphics graphics, float x, float y) {
        graphics.drawImage(sprites.get(currentIndex), x, y);
    }

    public void setStartFrameIndex(int index) {
        this.startingIndex = index;
        if (index < currentIndex) {
            currentIndex = index;
        }
    }

    public void setEndFrameIndex(int index) {
        this.finalIndex = index;
        if (index > finalIndex) {
            finalIndex = index;
        }
    }
}
