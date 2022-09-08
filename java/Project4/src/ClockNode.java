/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

//Define the class ClockNode
public class ClockNode
{
	//declare the local variable
	protected Clock data;
	protected ClockNode next;
	//define the Constructor
	public ClockNode(Clock d)
	{
		data = d;
		next = null;
	}
}