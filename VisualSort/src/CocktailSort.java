import java.awt.Canvas;

//taken from http://www.javacodex.com/Sorting/Cocktail-Sort
public class CocktailSort implements Runnable {

	int[] data;
	Canvas canvas;

	public CocktailSort(int[] incoming, SortCanvas c) {
		data = incoming;
		canvas = c;
	}

	@Override
	public void run() {
		long initialTime = System.currentTimeMillis();
		boolean swapped = true;
		int i = 0;
		int j = data.length - 1;
		while (i < j && swapped) {
			swapped = false;
			for (int k = i; k < j; k++) {
				if (data[k] > data[k + 1]) {
					int temp = data[k];
					data[k] = data[k + 1];
					data[k + 1] = temp;
					swapped = true;
				}
			}
			j--;
			if (swapped) {
				swapped = false;
				for (int k = j; k > i; k--) {
					if (data[k] < data[k - 1]) {
						int temp = data[k];
						data[k] = data[k - 1];
						data[k - 1] = temp;
						swapped = true;
					}
				}
			}
			canvas.repaint();
			try {
				Thread.sleep(50);

			} catch (InterruptedException e) {
				e.printStackTrace();
				i++;
			}
		}
		long totalTime = System.currentTimeMillis();
		Main.totaltime = totalTime - initialTime;
		Main.ShowTime();
	}
}
