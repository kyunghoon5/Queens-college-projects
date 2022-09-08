import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class BoxGUI extends JFrame {
	
	//Instance variables for a BoxGUI
	private JTextArea unsorted,sorted;
	private JMenuBar menubar;
	private JMenu tools;
	private JMenuItem search;
	private ToolsMenuHandler tmh;
	protected static BoxList unsortedList, sortedList; 
	
	/*
	 * Default Constructor for the BoxGUI. Sets up the main components
	 * to the GUI such as the title, size, location etc. of the GUI
	 * @param usl an Unsorted BoxList
	 * @param sl a Sorted BoxList
	 */
	public BoxGUI(BoxList usl ,BoxList sl) {
		unsortedList = usl;
		sortedList = sl;
		tmh = new ToolsMenuHandler();
		setTitle("BoxGUI Project 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		setComponenets();
		setVisible(true);
	}
	
	/*
	 * Sets up the components needed for the GUI
	 */
	private void setComponenets() {
		/* 
		 * Sets the layout of the GUI like a grid. This grid layout
		 * contains one row and two columns 
		 */
		setLayout(new GridLayout(1,2));
		setMenu();
		
		/*
		 * Displays the unsorted list of Boxes in a text area with 
		 * some decorations such as a different background color 
		 * and text style
		 */
		unsorted = new JTextArea();
		unsorted.setBackground(Color.CYAN);
		unsorted.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		unsorted.setEditable(false);
		unsorted.setBorder(BorderFactory.createLineBorder(Color.black));
		unsorted.append(unsortedList.toString());
		
		//Adds the TextArea to the GUI on the left side
		add(unsorted);
		
		
		
		
		/*
		 * Displays the sorted list of Boxes in a text area with
		 * some decorations such as a different background color
		 * and text style
		 */
		sorted = new JTextArea();
		sorted.setBackground(Color.YELLOW);
		sorted.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
		sorted.setEditable(false);
		sorted.setBorder(BorderFactory.createLineBorder(Color.black));
		sorted.append(sortedList.toString());
		
		//Adds the TextArea to the GUI on the right side
		add(sorted);
	
	}//setComponents
	
	/*
	 * A helper function that sets up 
	 * the menu for the Box GUI
	 */
	private void setMenu() {
		
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		tools = new JMenu("Tools");
		menubar.add(tools);
		
		search = new JMenuItem("Search");
		search.addActionListener(tmh);
		tools.add(search);
		
	}
	
}//BoxGUI