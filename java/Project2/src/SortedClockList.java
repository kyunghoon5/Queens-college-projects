/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

//define the class which extends the abstract class
public class SortedClockList extends ClockList{
	//Constructor
	public SortedClockList(){
		//call variables though super keyWord
		super();
	}
	//implement the method add()
	public void add(Clock c){
		//define the head for the previous and current nodes in the liked list
		ClockNode prev = head,
				curr = head.next;

		//define the nodes
		ClockNode node = new ClockNode(c);
		
		//Using while loop
		while(curr != null && c.toString().compareTo(curr.clock.toString()) > 0)
		{
			//set previous node as current node
			prev = curr;
			//set current node as next node
			curr = curr.next;
		}
		//set node to next is current node
		node.next = curr;
		//previous to next is node
		prev.next = node;
		//If node to next value is null
		if(node.next == null)
		{
			//set that is as last node
			last = node;
			//increment the node
			size_of_list++;
		}

	}

}
