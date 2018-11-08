import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class SortCanvas extends Canvas 
{
	int data[];


	public SortCanvas() {

	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		// display all 100 values, must be clear which is a large value and
		// small value
		int x = (1000-data.length)/data.length;
		for (int i = 0; i < data.length; i++) {
			g.fillRect(i*(x+1), getHeight()-20-data[i]*5, 1, data[i] * 5);
			g.setColor(Color.black);

		}

	}

}
