/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

//Define the class ClockNode
public class ClockNode
{
	//declare the local variable
	protected Clock clock;
	protected ClockNode next;
	//define the Constructor
	public ClockNode(Clock c)
	{
		clock = c;
		next = null;
	}
}