import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
// taken from dow loader from last year
public class TextDemo {
	int[] Data;
	ArrayList<Integer> ints = new ArrayList<Integer>();

	public TextDemo(String name) {

		String filename = name;
		// loads file into an arraylist
		try {
			File f = new File(filename);
			Scanner fileLoader = new Scanner(f);
			ArrayList<String> NewData = new ArrayList<String>();
			while (fileLoader.hasNext()) {
				NewData.add(fileLoader.nextLine());
			}
			fileLoader.close();
			// parses first string in arraylist to determine the size of the array that it will fill
			int size = Integer.parseInt(NewData.get(0));
			 Data = new int[size];
			 // fills array with values from arraylist
			for (int i = 0; i < NewData.size(); i++) {
				Data[i] = Integer.parseInt(NewData.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// sends data to main to be used
	public int[] getNewData() 
	{
		return Data; 
	
	}

}
