package org.javaeando.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class JavaGraphics {

    private Graphics2D g2d;
    private int width;
    private int height;
    private Font gearFont;

    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(int color) {
        Color c = new Color(color);
        g2d.setColor(c);
    }

    public int getColor() {
        return g2d.getColor().getRGB();
    }

    public void drawRect(float x, float y, int w, int h) {
        g2d.drawRect((int) x, (int) y, w, h);
    }

    public void fillRect(float x, float y, int w, int h) {
        g2d.fillRect((int) x, (int) y, (int) w, (int) h);
    }

    public void drawCircle(float x, float y, int radius) {
        int size = radius * 2;
        Shape circle = new Ellipse2D.Float(x, y, size, size);
        g2d.draw(circle);
    }

    public void fillCircle(float x, float y, int radius) {
        int size = radius * 2;
        Shape circle = new Ellipse2D.Float(x, y, size, size);
        g2d.fill(circle);
    }

    public void drawOval(float x, float y, int w, int h) {
        Shape circle = new Ellipse2D.Float(x, y, w, h);
        g2d.draw(circle);
    }

    public void fillOval(float x, float y, int w, int h) {
        Shape circle = new Ellipse2D.Float(x, y, w, h);
        g2d.fill(circle);
    }

    public Font getTextStyle() {
        return gearFont;
    }

    public void drawString(String str, float x, float y) {
        g2d.drawString(str, x, y);
    }

    public int screenWidth() {
        return width;
    }

    public int screenHeight() {
        return height;
    }

    public void drawImage(JavaImage image, float x, float y) {
        image.draw(this, x, y);
    }

    public void drawImage(JavaImage image, float x, float y, int w, int h) {
        image.draw(this, x, y, w, h);
    }

    public void drawImage(JavaImage image, float dx, float dy, float dw, float dh, float sx, float sy, float sw, float sh) {
        image.draw(this, dx, dy, dw, dh, sx, sy, sw, sh);
    }
}