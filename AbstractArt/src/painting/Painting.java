package painting;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import painters.*;

public class Painting {
	private LinkedList <Painter> paintersQueue;
	private List <Painter> painters;
    private int maxElements;
    private int paintedElements;
    private Random random = new Random();

    public Painting(int maxElements) {
        this.painters = new ArrayList<>();
        this.maxElements = maxElements;
        this.paintedElements = 0;
    }

    public void addPainter(Painter painter) {
        painters.add(painter);
    }

    public void startPainting(Graphics graphics) {
    	initializePainters(painters);
        Painter currentPainter = null;
        int x = 0;
        int y = 0;
        Color color = Color.BLACK;

        while (paintedElements < maxElements) {
            currentPainter = getNextPainter();

            currentPainter.paint(graphics, x, y, color);
            x = getNextX(x);
            y = getNextY(y);
            color = getNextColor(color);

            paintedElements++;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void initializePainters(List<Painter> painters) {
        paintersQueue = new LinkedList<Painter>();
        paintersQueue.addAll(painters);
    }

    private Painter getNextPainter() {
        Painter currentPainter = (Painter) paintersQueue.poll();
        paintersQueue.offer(currentPainter);
        return currentPainter;
    }

    private int getNextX(int lastX) {
        int x=random.nextInt(100) + 20;
        while(x==lastX) {
        	x=random.nextInt(100) + 20; 
        }
        return x;
    }

    private int getNextY(int lastY) {
        int y = random.nextInt(100) + 20;
        while(y==lastY) {
        	y=random.nextInt(100) + 20; 
        }
        return y;
    }

    private Color getNextColor(Color lastColor) {
        Color color = generateRandomColor();
        while(color==lastColor) {
        	color = generateRandomColor();
        }
        return color;
    }
    
    public Color generateRandomColor() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        return new Color(red, green, blue);
    }
}
