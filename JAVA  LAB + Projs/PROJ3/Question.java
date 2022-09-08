package proj3;



import java.util.Random;

/**
 * <p>Title: Project3</p>
 *
 * <p>Description: To analyze a problem and implemnet its solution. practice writing a programmer
 * -defined calss and gain experience writing code to test a programmer-defined class. </p>
 *
 * @author Kyunghoon Oh
 */
// 3 instance variables
public class Question {
	private int operand1;
	private int operand2;
	private char operator; // using char because of +,-
	
	

	/**
	 * method name: getOperand1
	 * method description: accessor method for each of insatance variables
	 * 
	 * @return an integer with operand1
	 */	
	public int getOperand1()// accessor method
	{
		return operand1;		
	}
	/**
	 * method name: getOperand2
	 * method description: accessor method for each of insatance variables
	 * 
	 * @return an integer with  operand2
	 */
	public int getOperand2()
	{
		return operand2;
	}
	/**
	 * method name: getOperator
	 * method description: accessor method for each of insatance variables
	 * 
	 * @return charater with operator
	 */
	public char getOperator()
	{
		return operator;
	}
	
	/**
	 * Title: default constructor
	 * Description: The default constructor will generate
	 * randomvalues for the three instance variables: operand1, operand2, operator
	 */
	public Question()
	{
		
		Random rand = new Random();
		if (rand.nextBoolean())
		{
			operator = '+';
			operand1 = rand.nextInt(13); // call random numbers from 0 to 12
			operand2 = rand.nextInt(13);
		}
		else		//rndGenerator.nextInt(to - from + 1)
		{
			operator = '-';
			operand1 = rand.nextInt(7) + 6; //from 6 to 12 
			operand2 = rand.nextInt(operand1 + 1) + 0; //from 0 less than or equal operand1
		}
	}
	/**
	 * determineAnswer method - this method will calculate the total of operand1 +- operand2
	 * @return the add or subof the operand and operand2
	 */
	public int determineAnswer()
	{
		if (operator == '+')
			return operand1 + operand2;
		else 
			return operand1 - operand2;
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
		return operand1 + " " + operator + " " + operand2 + " = ";		
	}


}
