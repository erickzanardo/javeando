package org.cafe.game;

import java.util.ArrayList;
import java.util.List;

import org.cafe.game.core.JavaGraphics;

public class MessageBoard {
    private List<String> messages = new ArrayList<String>();

    private float x = 10, y = 500 ;
    private int w = 780, h = 90;
    
    public void addMessage(String message) {
        messages.add(message);
        if (messages.size() > 5) {
            messages.remove(0);
        }
    }
    
    public void draw(JavaGraphics g) {
        g.setColor(0x000000);
        g.fillRect(x, y, w, h);

        g.setColor(0xffffff);
        g.drawRect(x, y, w, h);

        for (int i = 0; i < messages.size(); i++) {
            g.drawString(messages.get(i),  x + 10, 20 + (y + (15 * i)));
        }
    }
}
