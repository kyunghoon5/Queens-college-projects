public class UnsortedBoxList extends BoxList {
	
	/*
	 * Default UnsortedBoxList Constructor which calls on 
	 * its parent class constructor to initialize the variables
	 */
	public UnsortedBoxList() {
		super();
	}//UnsortedBoxList Constructor
	
	/*
	 * Adds a BoxNode to the list, but the list is unsorted
	 * @param b a Box object that has a length, width, and height
	 */
	public void add(Box b) {
		append(b);
	}//add

	
}//UnsortedBoxLis