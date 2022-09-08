package lab5;

/**
 * Title: Lab5App.java
 * Description:
 * 
 * @author KYUNGHOON OH
 *
 */

public class Lab5App {
	
	/**
	 * main method
	 * 
	 * @param args - values to be sent to the main method
	 */
	
	public static void main(String[] args)
	{
		// declare a Dice reference variable
		Dice dice;		
		// instantiate a Dice object
		dice = new Dice();		
		// print the state of the Dice object to the console
		System.out.println("After instantiation: " + dice.toString() + "\n");		
		// print the value of die1,2,3
		System.out.println("Value of die1: " + dice.getDie1());	
		System.out.println("Value of die2: " + dice.getDie2());
		System.out.println("Value of die3: " + dice.getDie3() + "\n");		
		// call the roll method - give random values to the instance variables
		dice.roll();		
		// print the value of die 1,2,3
		System.out.println("After rolling the dice: " + dice.toString() + "\n");		
		// roll total
		System.out.println("The roll total is " + dice.calcTotalRoll() + "\n");
		// threeOfAkind
		if (dice.threeOfAKind() == true)
			System.out.println("Three of a kind.");
		else
			System.out.println("Not three of a kind." + "\n"); 
		//Highest value
		System.out.println("The highest value of the three dice is " + dice.findHighestDie() + "\n");		
		dice.rollOneDie(1);
		System.out.println("Rolling die 1 only: " + dice.toString());
		dice.rollOneDie(2);
		System.out.println("Rolling die 2 only: " + dice.toString());
		dice.rollOneDie(3);
		System.out.println("Rolling die 3 only: " + dice.toString());
	}

}
