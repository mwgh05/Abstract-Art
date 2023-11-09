package painters;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class OvalPainter implements Painter {
    private int x, y, width, height;
    private Color color;
    private Random random = new Random();

    public OvalPainter(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.width = random.nextInt(100) + 20;
        this.height = random.nextInt(100) + 20;
        this.color = color;
    }

    @Override
    public void paint(Graphics graphics, int last, int lastY, Color lastColor) {
        graphics.setColor(lastColor);
        graphics.fillOval(last, lastY, width, height);
    }
}
