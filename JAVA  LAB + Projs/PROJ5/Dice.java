package lab5;
import java.util.Random;

/**
 * Title: Dice.java
 * Description:
 * 
 * @author KYUNGHOON OH
 *
 */
public class Dice {
	
	private int die1;
	private int die2;
	private int die3;
	
	/**
	 * Title: default constructor
	 * Description: initialize the instance variables to 0.
	 */
	
	public Dice()
	{
		this.die1 = 0;
		this.die2 = 0;
		this.die3 = 0;
	}
	
	/**
	 * method name: getDie1
	 * method description: return the value of the die1 instance variable
	 * 
	 * @return an integer with the value of die1
	 */
	
	public int getDie1()
	{
		return this.die1;
	}
	/**
	 * 
	 * method name: getDie2
	 * method description: return the value of the die2 instance variable
	 * @return an integer with the value of die2
	 */
	public int getDie2()
	{
		return this.die2;
	}	
	/**
	 * 
	 * method name: getDie3
	 * method description: return the value of the die3 instance variable
	 * @return an integer with the value of die3
	 */
	
	public int getDie3()
	{
		return this.die3;
	}
	
	
	
	/**
	 * method name: toString
	 * method description: this method returns a String reference
	 * with the values of the three instance variables.
	 * 
	 * @return a String with the values of the three instance  variables
	 */	
	public String toString()
	{
		return this.die1 + " " + this.die2 + " " + this.die3;
	}
	
	/**
	 * method name: roll
	 * method description: give random numbers between 1 and 6 to the three dice
	 */
	
	public void roll()
	{
		Random rand = new Random();
		
		// give a random integer between 1 and 6 to die1
		this.die1 = rand.nextInt(6) + 1;
		
		// give a random integer between 1 and 6 to die2
		this.die2 = rand.nextInt(6) + 1;
				
		// give a random integer between 1 and 6 to die3
		this.die3 = rand.nextInt(6) + 1;		
	}
	
	/**
	 * calcTotalRoll method - this method will calculate the total of the three dice
	 * @return the sum of the dice
	 */
	
	public int calcTotalRoll()
	{
		return (this.die1 + this.die2 + this.die3);
	}
	
	/**
	 * threeOfAkind method - this method will determine if all three of the dice have the
	 * same value
	 * @return true if they have the same value,false otherwise
	 */
	
	public boolean threeOfAKind()
	{
		if (this.die1 == this.die2 && this.die2 == this.die3 && this.die1 == this.die3)
			return true;
		else
			return false;				
	}
	
	/**
	 * findHighestDie method - this method will determine which of the three dice have the
	 * highest value - if two die have the same value,the first occurrence of the value
	 * should be used
	 * @return the value of the highest die
	 */
	
	public int findHighestDie()
	{
		if (this.die1 >= this.die2 && this.die1 >= this.die3)
			return this.die1;
		else if (this.die2 >= this.die1 && this.die2 >= this.die3)
			return this.die2;
		else  
			return this.die3;		
	}
	
	/**
	 * 
	 * method name: rollOneDie
	 * method description:
	 * @param value is one parameter integer
	 * 
	 */ 
	
	public void rollOneDie(int value)
	{
		Random rand = new Random();
		if(value == 1)
			this.die1 = rand.nextInt(6) + 1;
		else if (value == 2)
		this.die2 = rand.nextInt(6) + 1;
		else if (value == 3)
		this.die3 = rand.nextInt(6) + 1;		
	}
	
	
	


}
