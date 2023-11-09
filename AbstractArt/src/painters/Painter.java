package painters;
import java.awt.Color;
import java.awt.Graphics;

public interface Painter {
	void paint(Graphics graphics, int last, int lastY, Color lastColor);
}
