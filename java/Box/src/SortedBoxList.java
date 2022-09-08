public class SortedBoxList extends BoxList {
	
	/*
	 * Default Constructor for a SortedBoxList which calls
	 * on its parent class constructor to initialize the variables
	 */
	public SortedBoxList() {
		super();
	}//SortedBoxList Constructor
	
	/*
	 * Adds a BoxNode to the list and will put the node in the correct
	 * position. The list is sorted from lowest to highest based on the Box's 
	 * volume
	 * @param b a Box object with a length, width, and height
	 */
	public void add(Box b) {
			//The new BoxNode that will be added to the list
			BoxNode tempNode = new BoxNode(b);
			
			//A BoxNode that keeps track of the next node
			BoxNode nextNode = first.next;
			
			//A BoxNode that keeps track of the previous node
			BoxNode prevNode = first;
			
			//Keeps going through the list until there are no more nodes
			while(nextNode!=null) {
				//If the next node has a greater volume than the new node, break out of the loop
				if(nextNode.data.volume()>tempNode.data.volume())break;
				
				//Otherwise move to the next node and keep track of the previous node as well
				prevNode=nextNode;
				nextNode=nextNode.next;
			}
			
			//Add the new box node to the right position
			prevNode.next = tempNode;
			tempNode.next=nextNode;
		
	}//add
	
}//SortedBoxList