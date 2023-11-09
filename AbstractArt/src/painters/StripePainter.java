package painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class StripePainter implements Painter {
    private int x1, y1, x2, y2;
    private Color color;
    private int thickness;
    private Random random = new Random();

    public StripePainter(int x1, int y1, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = random.nextInt(100) + 20; 
        this.y2 = random.nextInt(100) + 20; 
        this.color = color;
        this.thickness = random.nextInt(100) + 20;
    }

    @Override
    public void paint(Graphics graphics, int lastX, int lastY, Color lastColor) {
        int x1 = lastX;
        int y1 = lastY;

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(lastColor);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawLine(x1, y1, x2, y2);
    }

}
