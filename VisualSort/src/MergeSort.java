import java.awt.Canvas;

public class MergeSort implements Runnable {
	int[] data;
	int[] sort;
	Canvas canvas;
//taken from https://en.wikipedia.org/wiki/Merge_sort
	public MergeSort(int[] incoming, SortCanvas c) {
		data = incoming;
		sort = new int[data.length];
		canvas = c;
	}

	@Override
	public void run() {
		
		long initialTime = System.currentTimeMillis();
		mergesort(data, sort, data.length - 1);
		long totalTime = System.currentTimeMillis();
		Main.totaltime = totalTime - initialTime;
		Main.ShowTime();
	}

	public void mergesort(int A[], int B[], int n) {
		TopDownSplitMerge(A, 0, n, B);
	}

	public void TopDownSplitMerge(int A[], int iBegin, int iEnd, int B[]) {
		if (iEnd - iBegin < 2)
			return;
		//splits the list
		int iMiddle = (iEnd + iBegin) / 2;
		TopDownSplitMerge(A, iBegin, iMiddle, B);
		TopDownSplitMerge(A, iMiddle, iEnd, B);
		TopDownMerge(A, iBegin, iMiddle, iEnd, B);
		CopyArray(B, iBegin, iEnd, A);
	}

	public void CopyArray(int[] b, int iBegin, int iEnd, int[] a) {

		for(int k = iBegin; k < iEnd; k++)
	        a[k] = b[k];	
		data = a; 
	}

	public void TopDownMerge(int[] a, int iBegin, int iMiddle, int iEnd, int[] b) {
		int i0 = iBegin;
		int i1 = iMiddle;
		  for (int j = iBegin; j < iEnd; j++) {
		       
		        if (i0 < iMiddle && (i1 >= iEnd || a[i0] <= a[i1])) {
		            b[j] = a[i0];
		            i0 = i0 + 1;
		  
		        }
					else {
		            b[j] = a[i1];
		            i1 = i1 + 1;    

		        }
		        canvas.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    } 
		  canvas.repaint();
		
	}
	
	}

