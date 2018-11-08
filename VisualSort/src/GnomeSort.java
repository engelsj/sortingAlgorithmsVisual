import java.awt.Canvas;
//taken from https://en.wikipedia.org/wiki/Gnome_sort
public class GnomeSort implements Runnable {
	int[] data;
	Canvas canvas;
	int t2 = 3;

	public GnomeSort(int[] incoming, SortCanvas c) {
		data = incoming;
		canvas = c;
	}

	@Override
	public void run() {
		long initialTime = System.currentTimeMillis();
		
	        int lowest = Integer.MAX_VALUE;

	        for (int n : data)
	        {
	            if (n < lowest)
	                lowest = n;
	        }

	        int index = 0;

	        int down = 0;

	        while (index < data.length)
	        {
	        	canvas.repaint(); 
	            for (int i = index; i < data.length; i++)
	            {
	           
	                if (data[i] == lowest)
	                {
	                    int temp = data[i] + down;
	                    data[i] = data[index];
	                    data[index] = temp;
	                    
	                    index++;
	                }
	                else 
	                    data[i]--;
	            }
	            down++;
	        }
	        
	        
	    }
		long totalTime = System.currentTimeMillis();

}
	
