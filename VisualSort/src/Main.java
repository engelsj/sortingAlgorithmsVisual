import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	SortCanvas canvas = new SortCanvas();
	int[] data = new int[100];
	JButton startButton;
	JButton reset;
	JButton importdata;
	JButton SetSize;
	static JLabel time;
	static long totaltime;
	JTextField textfield = new JTextField(20);
	JTextField sizefield = new JTextField(20);
	JTextField NewData = new JTextField(20);
	String[] Sorts = { "Bubble Sort", "Shell Sort", "Merge Sort", "Gnome Sort", "Cocktail Sort", "Radix Sort" };
	JComboBox<String> Box = new JComboBox<String>(Sorts);
	int ms = 0;
	JPanel mainPanel = new JPanel();

	// taken from
	// http://www.java2s.com/Code/Java/Swing-JFC/Usingdropdownlists.htm
	public Main() {
		
		for (int i = 0; i < data.length; i++) {
			int x = (int) ((Math.random()) * 100 + 1);
			data[i] = x;
		}
		canvas.data = this.data;
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Visual Sorter");
		setLocationRelativeTo(null);
		time = new JLabel();
		startButton = new JButton("Start");
		reset = new JButton("Size(Max 499)");
		importdata = new JButton("Import");
		startButton.addActionListener(this);
		importdata.addActionListener(this);
		reset.addActionListener(this);
		Box.addActionListener(this);
		textfield.addActionListener(this);
		NewData.addActionListener(this);
		JPanel SecondPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout()); // divides into 5 regions
		SecondPanel.setLayout(new FlowLayout());
		SecondPanel.add(Box);
		SecondPanel.add(startButton);
		SecondPanel.add(textfield);
		SecondPanel.add(reset);
		SecondPanel.add(NewData);
		SecondPanel.add(importdata);
		mainPanel.add(time, BorderLayout.NORTH);
		mainPanel.add(canvas, BorderLayout.CENTER);
		mainPanel.add(SecondPanel, BorderLayout.SOUTH);
		add(mainPanel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

	public void LoadData(int size) {
		int[] LoadData = new int[size];
		for (int i = 0; i < LoadData.length; i++) {
			int x = (int) ((Math.random()) * 100 + 1);
			LoadData[i] = x;
		}
		canvas.data = LoadData;
		System.out.println(canvas.data.length);
		canvas.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == reset) {
			String text = textfield.getText();
			int size = Integer.parseInt(text);
			LoadData(size + 1);
		}

		if (e.getSource() == importdata) {
			String FileName = NewData.getText();
			TextDemo text = new TextDemo(FileName);
			data = text.getNewData();
		}

		if (e.getSource() == startButton) {
			if (Box.getSelectedIndex() == 0) {
				BubbleSorter BubbleSorter = new BubbleSorter(canvas.data, canvas);
				Thread b = new Thread(BubbleSorter);
				b.start();
				canvas.repaint();
			}

			if (Box.getSelectedIndex() == 1) {
				ShellSort ShellSorter = new ShellSort(canvas.data, canvas);
				Thread s = new Thread(ShellSorter);
				s.start();
				canvas.repaint();

			}
			if (Box.getSelectedIndex() == 2) {
				MergeSort QuickSorter = new MergeSort(canvas.data, canvas);
				Thread q = new Thread(QuickSorter);
				q.start();
				canvas.repaint();

			}
			if (Box.getSelectedIndex() == 3) {
				GnomeSort GnomeSorter = new GnomeSort(canvas.data, canvas);
				Thread g = new Thread(GnomeSorter);
				g.start();
				canvas.repaint();

			}
			if (Box.getSelectedIndex() == 4) {
				CocktailSort CocktailSorter = new CocktailSort(canvas.data, canvas);
				Thread c = new Thread(CocktailSorter);
				c.start();
				canvas.repaint();

			}
			if (Box.getSelectedIndex() == 5) {
				RadixSort Radix = new RadixSort(canvas.data, canvas);
				Thread r = new Thread(Radix);
				r.start();
				canvas.repaint();

			}
		}
	}

	// worked with jay on implementation of time
	public static void ShowTime() {
		time.setText("Time Taken to Sort: " + totaltime / 1000 + " seconds");
	}
}
