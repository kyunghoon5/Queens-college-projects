package lab1;
/**
 * <p>Title: Lab 1</p>
 * 
 * <p>Description: Introduction to Writing Programs in Eclipse </p>
 * 
 * @author KYUNGHOON ON
 */

// class definition
public class Lab1App // class header
{
	/**
	 * <p> Name: main method </p>
	 * 
	 * @param args values to be sent to the method
	 */
	public static void main(String[] args) // main method header
	{
		// variable declarations
		int x;
		int y;
		double z;
		
		// assignment and output statements
		x = 1 + 3 * 2;
		System.out.println("x is " + x);
		
		y = x + x;
		System.out.println("y is " + y);
		
		y = y + 1;
		System.out.println("y is now " + y);
		
		x = x - 5;
		System.out.println("x is now " + x);
		
		z = y / x;
		System.out.println("z is " + z);
		
		y = y / x;
		System.out.println("y is now " + y);
		
	}

}
