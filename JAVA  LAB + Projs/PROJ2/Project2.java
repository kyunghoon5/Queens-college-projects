package proj2;
import cardgames.*;

/**
 * <p>Project2: Understanding Program Logic</p>
 *
 * <p>Description: to understand and develop program logic and use
 * an appropriate if statements to determine value of the
 * highest card, to identify a pair or not a pair among the
 * three cards.Also, fine sum and display an appropriate message
 * the player wins when sum is 25 or higher otherwise the computer
 * wins. </p>
 *
 * @author KYUNGHOON OH
 */

public class Project2 
{
    /**
     * <p> Name: main method </p>
     * 
     * @param args values to be sent to the method
     */
	public static void main(String[] args)
	{
		GUI theWindow = new GUI();
		
		Deck theDeck = new Deck();
		theDeck.shuffleDeck();		
				
		Card card1 = theDeck.dealCard();
		Card card2 = theDeck.dealCard();
		//add card3
		Card card3 = theDeck.dealCard();		
		
		theWindow.showCard(card1);
		theWindow.showCard(card2);
		theWindow.showCard(card3);		
		
		System.out.println("Card 1 is: " + card1.toString());
		System.out.println("Card 2 is: " + card2.toString());
		System.out.println("Card 3 is: " + card3.toString());
		
			//Use ||(or) to identify a pair among the three cards.
		if (card1.getValue() == card2.getValue() || card1.getValue()
				== card3.getValue() || card2.getValue() == card3.getValue()) 
			System.out.println("Pair");
		else
			System.out.println("Not a pair");
		//Use If statement with getValue to determine and display the value of the highest card.
		//Also, used >= or <= to determine for two cards have the same highest value		
		if (card1.getValue() >= card2.getValue() && card1.getValue() >= card3.getValue())
			System.out.println("The highest value is " + card1.getValue());
		else if	(card2.getValue() >= card3.getValue() && card2.getValue() >= card1.getValue())
		    System.out.println("The highest value is " + card2.getValue());
		else if (card3.getValue() >= card2.getValue() && card3.getValue() >= card1.getValue())
			System.out.println("The highest value is " + card3.getValue());
		//Use getPoinValue to calculate the sum of the three cards.
		//important thing is that have to use () between card1 and card3.
		//if not it will calculate each getpointvalue.
		System.out.println("The sum is " + (card1.getPointValue() + card2.getPointValue() + card3.getPointValue()));
		//Use if statement with getpointvalue to display an message when the sum is 25 or higher the player wins
		//otherwise the computer wins.
		if ((card1.getPointValue() + card2.getPointValue() + card3.getPointValue()) >= 25)
			System.out.println("You win!");
		else
			System.out.println("Computer wins.");		
		

	}
}