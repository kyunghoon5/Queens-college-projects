import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ToolsMenuHandler implements ActionListener{

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * Checks if the user has clicked on anything from the
	 * Tools Menu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String toolMenuName = e.getActionCommand();
		String result;
		
		/*
		 * Allows the user to search for the type of
		 * boxes with a given length width and height that are
		 * equal to or greater than any of these values together
		 */
		if(toolMenuName.equals("Search")) {
			
			/*
			 * Tests to see if the user puts valid input
			 */
			try {
			result =JOptionPane.showInputDialog(null, "Enter a length, width, height. Use commas to list all three values");
			int [] values = new int [3];
			StringTokenizer st = new StringTokenizer(result,",");
			
			for(int i=0;i<3;++i) {
				values[i]= Integer.parseInt(st.nextToken(","));
			}

			//Displays the results
			ResultsGUI gui = new ResultsGUI(values[0],values[1],values[2]);
			
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Not a valid input");
			}
			
			}
			
		}
		
}
