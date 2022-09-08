package lab3;
// The import statement allows program to use the cardgames.jar file
import cardgames.*;

/**
 * <p>Title: </p>
 * 
 * <p>Description: </p>
 * 
 * @author Kyunghoon Oh
 */

public class Lab3App {

    /**
     * <p> Name: main method </p>
     * 
     * @param args values to be sent to the method
     */
	public static void main(String[] args)
	{
		GUI theWindow = new GUI();
		Deck theDeck = new Deck();
		Card card1;
		theDeck.shuffleDeck();
		card1 = theDeck.dealCard();
		theWindow.showCard(card1);
		int ww = card1.getValue();
		int wb = card1.getPointValue();
		System.out.println(card1.toString());
		System.out.println("The value of card1 is " + ww);
		System.out.println("The point value of card1 is " + wb);
	}
}
