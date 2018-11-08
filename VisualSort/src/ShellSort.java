import java.awt.Canvas;

public class ShellSort implements Runnable {
	int[] data;
	Canvas canvas;
	//code from http://forgetcode.com/Java/1327-Shell-sort

	public ShellSort(int[] incoming, SortCanvas c) {
		data = incoming;
		canvas = c;
	}

	public void run() {
		
		long initialTime = System.currentTimeMillis();
		int increment, temp, j;
		int size = data.length;
		for (increment = size / 2; increment > 0; increment /= 2) {
			for (int i = increment; i < size; i++) {
				temp = data[i];
				for (j = i; j >= increment; j -= increment) {
					if (temp < data[j - increment]) {
						data[j] = data[j - increment];
						data[j-increment] = temp;
					} else {
						break;
					}
				}
				canvas.repaint();
				try {
					Thread.sleep(10);

				} catch (InterruptedException e) {
					e.printStackTrace();
			}
		}
	}
		long totalTime = System.currentTimeMillis();
		Main.totaltime = totalTime - initialTime;
		Main.ShowTime();
	}
}


