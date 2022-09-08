package proj5;
import java.util.Scanner;

/**
 * Title: Project5App.java
 * 
 * 
 * @author Kyunghoon Oh
 *
 */
public class Project5App 
{	
	/**
	 * Project5App
	 * @param args values to be sent to the method
	 */
	public static void main(String[] args) 
	{	
		DiceArray dice1 = new DiceArray(5);
		GUI diceTable = new GUI();
		int keep = 0;
		int[] scoreCard = {0, 0, 0, 0, 0, 0};
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		
		for (int i = 1; i <= 6; i++) 
		{	
			System.out.println("Round " + i);
			dice1.roll();
			
			//This is roll 1 for the dice game
			System.out.println("Roll 1:");
			diceTable.showDice(dice1);
			System.out.println("Which die value do you want to keep?");
			keep = sc.nextInt();
			dice1.keep(keep);
			dice1.roll();
			
			//This is roll 2 for the dice game
			System.out.println("Roll 2:");
			diceTable.showDice(dice1);
			System.out.println("Which die value do you want to keep?");
			keep = sc.nextInt();
			dice1.keep(keep);
			dice1.roll();
			
			//This is roll 3 for the dice game
			System.out.println("Roll 3:");
			diceTable.showDice(dice1);
			
			System.out.println("Which location would you like to record this round?");
			scoreChart(scoreCard);
			
			// User Input taken
			userInput = sc.nextInt();
			while(scoreCard[userInput - 1] != 0) 
			{
				System.out.println("There is already a score for location " + userInput 
						+ ". Which location would you like to record this round?");
				scoreChart(scoreCard);
				userInput = sc.nextInt();
			}
			
			scoreCard[userInput - 1] = dice1.calculateTotal(userInput);
			System.out.println("Round " + i + " complete.");
			scoreChart(scoreCard);
			
			dice1.reset();
		}
		
		int sum = 0;
		for (int i = 0; i < 6; i++) 
		{
			sum += scoreCard[i];
		}
		
		// After 6 rounds, this is output that's displayed.
		System.out.println("\nGame over! Your total score is " + sum);
	}
	
	/**
	 * scoreChart method 
	 * @param score - will display the score chart
	 */
	public static void scoreChart(int[] score) 
	{	
		//Output for the Score Chart
		System.out.println("Scores:");
		
		for (int i = 1; i <= 6; i++) 
		{	
			System.out.println(i + "s: " + score[i - 1] + " points");
		}
	}
}
