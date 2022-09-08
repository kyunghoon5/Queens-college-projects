public abstract class BoxList {
	
	//Instance Variables for BoxList
	protected BoxNode first,last,head;
	protected int length;
	
	/*
	 * Default constructor for a BoxList
	 * Creates an empty list
	 */
	public BoxList() {
		head = new BoxNode();
		first= head;
		last= head;
		length=0;
	}//BoxList Constructor
	
	/*
	 * Adds a BoxNode to the BoxList 
	 * @param b a Box object with a length,width and height
	 */
	public void append(Box b) {
		BoxNode node = new BoxNode(b);
		last.next=node;
		last=node;
		++length;
	}//append
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Represents a BoxList as a string
	 * @return a BoxList as a string representation
	 */
	public String toString() {
		String list = "";
		BoxNode display = first.next;
		
		while(display!=null) {
			list += (display.data).toString() +"\n";
			display = display.next;
		}
		return list;
	}//toString	
	
}//BoxList