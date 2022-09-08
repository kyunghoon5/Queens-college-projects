/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

//define the class UnsortedClockList which extends the //ClockList
public class UnsortedClockList extends ClockList {
	//define the Constructor
	public UnsortedClockList(){
		//call the variables
		super();
	}
	//implement the method add
	public void add(Clock c){
		//just append values to the text area
		append(c);
	}
}