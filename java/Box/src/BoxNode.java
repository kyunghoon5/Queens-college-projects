public class BoxNode {
	
	//Instance Variables for a BoxNode 
	protected Box data;
	protected BoxNode next;
	
	/*
	 * Default constructor for a BoxNode. Default values
	 * for a BoxNode will be set equal to null
	 */
	public BoxNode() {
		data=null;
		next=null;
	}//BoxNode Constructor
	
	/*
	 * One-argument constructor that creates a BoxNode, which stores
	 * a Box object and the location of the next BoxNode
	 * @param data a Box object with a length, width, and height
	 */
	public BoxNode(Box data) {
		this.data=data;
		next=null;
	}//BoxNode Constructor
	
	
}//BoxNode