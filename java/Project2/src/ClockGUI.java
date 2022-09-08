/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//declare the class
@SuppressWarnings("serial")
public class ClockGUI extends JFrame
{	
	//Constructor which takes an array of Box objects as parameter
	public ClockGUI(SortedClockList sortedClockList,UnsortedClockList unsortedClockList) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//using GridLayout with 1 row and 2 columns, with 10 spaces gap between
		//each cells horizontally and vertically
		setLayout(new GridLayout(1, 2, 10, 10));

		//Defining a Text area for displaying unsorted list
		JTextArea left = new JTextArea();

		// making it not editable (by user)
		left.setEditable(false);
		String clock = "UNSORTED LIST OF CLOCKS\n\n";
		clock+=unsortedClockList.toString();

		//Setting text for unsorted list
		left.setText(clock);

		//Adding the text area
		add(left);

		//Defining a text area for displaying sorted list, and adding the
		//details of each clock
		JTextArea right = new JTextArea();
		right.setEditable(false);
		clock = "SORTED LIST OF CLOCKS\n\n";
		clock+=sortedClockList.toString();
		right.setText(clock);
		add(right);
		setVisible(true);
		//Adjust the length and width of the window
		pack();
	}
}