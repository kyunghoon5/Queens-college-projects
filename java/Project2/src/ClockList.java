/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

//declare the abstract ClockList
public abstract class ClockList
{
	//declare local variables
	protected ClockNode head , last;
	protected int size_of_list;
	//define the default constructor
	public ClockList()
	{
		head = last = new ClockNode(null);
		size_of_list = 0;
	}

	//implement the method to test the linked list is empty
	//or not
	public boolean isEmpty()
	{
		if(size_of_list == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//append date to the list
	public void append(Clock data)
	{
		//append the date to the last node
		last.next = new ClockNode(data);
		//set the last node to last.next
		last = last.next;
		//increment the size of list
		size_of_list++;
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
			str += curr.clock.toString() + "\n";
			//set current to current next
			curr = curr.next;
		}
		//return the string
		return str;
	}
}