package proj5;

/**
 * <p>Title: Project5 App </P>
 * @author Kyunghoon Oh
 *
 */

public class Project5Testing {
	/**
	 * <p> Name: main method </p>
	 * 
	 * 
	 * @param args values to be sent to the method
	 */
	
	
	public static void main(String[] args)
	{
		DiceArray theDice;
		theDice = new DiceArray(5);
		System.out.println("Testing the parameterized constructor with an argument of 5:"
				+ "\n" + theDice.toString() + "\n");
		theDice.roll();
		System.out.println("Testing the roll method:" + "\n" + theDice.toString());
		theDice.keep(1);
		theDice.roll();
		System.out.println("\nCall the keep method with an argument of 1, then roll again:" + "\n"
			+ theDice.toString());
		theDice.keep(2);
		theDice.roll();
		System.out.println("\nCall the keep method with anargument of 2, then roll again:"
				+ "\n" + theDice.toString());
		theDice.keep(3);
		theDice.roll();
		System.out.println("\nCall the keep method with an argument of 3, then roll again:"
				+ "\n" + theDice.toString());
		theDice.reset();
		theDice.roll();
		System.out.println("\nCall the reset method, then roll again:" + "\n" + theDice.toString());
		
		System.out.println("\nCalculating the sum of all the 1s: " + theDice.calculateTotal(1));
		System.out.println("Calculating the sum of all the 2s: " + theDice.calculateTotal(2));
		System.out.println("Calculating the sum of all the 3s: " + theDice.calculateTotal(3));
		System.out.println("Calculating the sum of all the 4s: " + theDice.calculateTotal(4));
		System.out.println("Calculating the sum of all the 5s: " + theDice.calculateTotal(5));
		System.out.println("Calculating the sum of all the 6s: " + theDice.calculateTotal(6));
	}

}
