package lab4;

/**
 * <p>Title: The Lab4 Application class</p>
 *
 * <p>Description: This class test the various methods in the Card class to see what is returned and
 * determine if the methods work properly. </p>
 *
 * @author <Kyungoon Oh>
 */

public class Lab4App 
{

    /**
     * <p> Name: main method </p>
     * 
     * @param args values to be sent to the method
     */
	public static void main(String[] args)
	{
		Card card1 = new Card(24);
		Card card2 = new Card(7);
		Card card3 = new Card(8);
		Card card4 = new Card(36);
		Card card5 = new Card(50);
		Card card6 = new Card(14);
		Card card7 = new Card(26);
		Card card8 = new Card(38);		
		System.out.println("Card 1: " + card1.toString());		
		System.out.println("Card 1's value is: " + card1.getValue());
		System.out.println("Card 1's suit is: " + card1.getSuit());
		System.out.println("Card 1 is a face card: " + card1.isAFaceCard());		
		System.out.println("Card 2: " + card2.toString());
		System.out.println("Card 2 is a face card: " + card2.isAFaceCard());
		System.out.println("Card 1's point value is: " + card1.getPointValue());
		System.out.println("Card 2's point value is: " + card2.getPointValue());
		System.out.println("Card1 is " + card1.getSuit() + " - " + "Color is red: " + card1.isRed());
		System.out.println("Card3 is " + card3.getSuit() + " - " + "Color is red: " + card3.isRed());
		System.out.println("Card4 is " + card4.getSuit() + " - " + "Color is red: " + card4.isRed());
		System.out.println("Card5 is " + card5.getSuit() + " - " + "Color is red: " + card5.isRed());
		System.out.println(card6.toString());
		System.out.println(card7.toString());
		System.out.println(card8.toString());
		
		if (card1.equalValue(card5))
			System.out.println(card1.toString() + " and " + card5.toString() + " have the same value.");
		else
			System.out.println(card1.toString() + " and " + card5.toString() + " do not have the same value.");
		
		if (card2.equalValue(card3))
			System.out.println(card2.toString() + " and " + card3.toString() + " have the same value.");
		else
			System.out.println(card2.toString() + " and " + card3.toString() + " do not have the same value.");
		
		if (card2.equalSuit(card3))
			System.out.println(card2.toString() + " and " + card3.toString() + " have the same suit.");
		else
			System.out.println(card2.toString() + " and " + card3.toString() + " do not have the same suit.");
		
		if (card1.equalSuit(card5))
			System.out.println(card1.toString() + " and " + card5.toString() + " have the same suit.");
		else
			System.out.println(card1.toString() + " and " + card5.toString() + " do not have the same suit.");
		
		
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	}
}