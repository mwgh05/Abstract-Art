package painters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class PolygonPainter implements Painter {
    private Polygon polygon;
    private Color color;
    private Random random = new Random();
    private int x;
    private int y;
    public PolygonPainter(int x, int y, Color color) {
    	this.x = x;
    	this.y = y;
        this.polygon = generateRandomPolygon(x,y);
        this.color = color;
    }
    
    private Polygon generateRandomPolygon(int x, int y) {
        int sides = random.nextInt(6) + 3; 
        int size = random.nextInt(100) + 20; 

        int[] xPoints = new int[sides];
        int[] yPoints = new int[sides];

        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            xPoints[i] = (int) (x + size * Math.cos(angle));
            yPoints[i] = (int) (y + size * Math.sin(angle));
        }
        polygon = new Polygon(xPoints, yPoints, sides);
        return polygon;
    }

    @Override
    public void paint(Graphics graphics, int last, int lastY, Color lastColor) {
        graphics.setColor(color);
        graphics.fillPolygon(generateRandomPolygon(last,lastY));
    }
}
