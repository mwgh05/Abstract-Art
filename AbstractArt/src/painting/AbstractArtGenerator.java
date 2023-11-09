package painting;

import painters.*;
import javax.swing.*;
import java.awt.*;

public class AbstractArtGenerator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Abstract Art Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Painting painting = createPainting();
                painting.startPainting(g);
            }
        };
        frame.add(panel);
        frame.setVisible(true);
                
        panel.repaint();
        
    }

    private static Painting createPainting() {
        Painting painting = new Painting(1000); 
        painting.addPainter(new OvalPainter(0, 0, Color.RED));
        painting.addPainter(new StripePainter(0, 0, Color.GREEN));
        painting.addPainter(new PolygonPainter(0, 0, Color.BLUE));

        return painting;
    }
}
