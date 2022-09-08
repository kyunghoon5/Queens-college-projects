import java.util.StringTokenizer;

public class Project3 {
	
	public static void main(String[] args) {
		
		//A variable that will read off the given file
		TextFileInput fileInput = new TextFileInput("boxes.txt");

		//Stores a unsorted list of Box objects
		UnsortedBoxList unsorted = new UnsortedBoxList();
		
		//Stores a sorted list of Box objects
		SortedBoxList sorted = new SortedBoxList();
		
		//A variable that will store each line of the text file one by one
		String line = fileInput.readLine();
		
		//Keeps reading through the file until there are no more lines to read
		while(line!=null) {

			//An array to store the 3 values from the file (length,width,height)
			int [] values = new int [3];
			
			//To determine how to separate each part of the string
			StringTokenizer st = new StringTokenizer(line,",");
			
			//Counts the number of commas that appears in the current line
			int numberOfCommas = st.countTokens();
			
			/*
			 * Tests the following input values to
			 * see if any values of the text file are less 
			 * than one or if they are not numbers at all.
			 */
			try {
				
				//Reads each number of the line and stores it in the values array
				for(int i=0;i<numberOfCommas;++i) {
					values[i]=Integer.parseInt(st.nextToken(","));
				}				
				//Stores the 3 values into a box object and stores the box object in an unsorted list
				unsorted.add(new Box(values[0],values[1],values[2]));
			
				//Stores the 3 values into a box object and stores the box object in a sorted list
				sorted.add(new Box(values[0],values[1],values[2]));

			}catch (IllegalBoxException e) {
				System.out.println("Not a valid box");
			}catch(NumberFormatException e) {
				System.out.println("Not the correct format for a box");
			}
			
			//Reads the next line
			line = fileInput.readLine();
		
		}//end of loop

		//Displays a graphical user interface
		BoxGUI gui = new BoxGUI(unsorted,sorted);
		
	}//main

}//Project2