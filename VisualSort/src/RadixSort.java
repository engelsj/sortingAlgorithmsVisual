import java.awt.Canvas;

public class RadixSort implements Runnable {
	int[] data;
	Canvas canvas;
	Bin bin = new Bin();
	Bin[] bins = new Bin[10];
	int max;
	int len;
	int x = 10;
	int y = 1;

	public RadixSort(int[] incoming, SortCanvas c) {
		for (int i = 0; i < bins.length; i++) {
			bins[i] = new Bin();
		}
		data = incoming;
		canvas = c;
	}

	public void Radix() {
		for (int i : data) {
			max = Math.max(max, i);
		}
		len = ("" + max).length();
		sort1();
	}

	public void sort1() {
		for (int j = 0; j < len; j++) {
			for (int i = 0; i < data.length; i++) {
				int temp = data[i] % x / y;
				bins[temp].numbers.add(data[i]);
			}
			x = x * 10;
			y = y * 10;
			addvalues();
			clearvalues();

		}
	}

	public void addvalues() {
		int count = 0;
		for (int i = 0; i < bins.length; i++) {
			for (int j = 0; j < bins[i].numbers.size(); j++) {
				int k = bins[i].numbers.get(j);
				data[count] = k;
				canvas.repaint();
				try {
					Thread.sleep(20);

				} catch (InterruptedException e) {
					e.printStackTrace();
					i++;
				}
				count++;
			}
		}
	}

	public void clearvalues() {
		for (int i = 0; i < bins.length; i++) {
			bins[i].numbers.clear();
		}
	}

	public void run() {
		long initialTime = System.currentTimeMillis();
		Radix();
		long totalTime = System.currentTimeMillis();
		Main.totaltime = totalTime - initialTime;
		Main.ShowTime();

	}

}
