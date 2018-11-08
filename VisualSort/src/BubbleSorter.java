import java.awt.Canvas;

public class BubbleSorter implements Runnable {
	int[] data;
	Canvas canvas;
	long t = 0;

	public BubbleSorter(int[] incoming, SortCanvas c) {
		data = incoming;
		canvas = c;

	}

	public void run() {
		long initialTime = System.currentTimeMillis();
		int n = data.length;
		boolean swapped = true;
		while (swapped == true) {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (data[i - 1] > data[i]) {
					int temp = data[i - 1];
					data[i - 1] = data[i];
					data[i] = temp;
					canvas.repaint();
					try {
						Thread.sleep(10);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					swapped = true;
				}
			}
			canvas.repaint();
		}
		long totalTime = System.currentTimeMillis();
		Main.totaltime = totalTime - initialTime;
		Main.ShowTime();

	}

}
