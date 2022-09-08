/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

//declare the abstract ClockList
public abstract class ClockList
{
	//declare local variables
	protected ClockNode head , last;
	protected int length;
	//define the default constructor
	public ClockList()
	{
		head = last = new ClockNode(null);
		length = 0;
	}

	//implement the method to test the linked list is empty
	//or not
	public boolean isEmpty()
	{
		return length ==0;
	}

	//append date to the list
	public void append(Clock d)
	{
		//append the date to the last node
		last.next = new ClockNode(d);
		//set the last node to last.next
		last = last.next;
		//increment the size of list
		length++;
	}
	
	//implement the method toString
	public String toString()
	{
		//define the current node
		ClockNode curr = head.next;
		String str = "";
		//Using while loop to repeat the current node is null or not
		while(curr != null)
		{
			//call the toString()
			str += curr.data.toString() + "\n";
			//set current to current next
			curr = curr.next;
		}
		//return the string
		return str;
	}
}