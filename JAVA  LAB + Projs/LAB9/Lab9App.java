package lab9;

/**
 * <p>Title: The Lab9App class</p>
 *
 * <p>Description: COMPLETE THIS</p>
 * 
 * @author Kyunghoon Oh
 */
public class Lab9App {
	/**
	 * <p> Nmae: main method </p>
	 * 
	 * 
	 * @param args values to be sent to the method
	 */

	public static void main(String[] args)
	{
		// create and shuffle the deck
		Deck theDeck = new Deck();
		theDeck.shuffleDeck();
		
		// instantiate a Hand object
		Hand myHand = new Hand();
		
		// insert 7 cards in the hand
		Card theCard;
		for (int i = 0; i < 7; i++)
			
		{
			theCard = theDeck.dealCard();
			myHand.insertCard(theCard);
			
		}
		System.out.println("Display the cards in the hand:");
		System.out.println(myHand.toString());
		System.out.println("Get a copy of the cards array, and display the contents of the copy:");
		
		Hand myHandCopy = myHand;
		Card[] copy1 = myHandCopy.getCards();		
		for(int i = 0; i < copy1.length; i++)			
		{			
			System.out.println(copy1[i].toString());
		}
		
		System.out.println("\nChanging the first card in the copy to the 4 of hearts:");		
		Card card1 = new Card(30);
		copy1[0] = card1;
		for(int i = 0; i < copy1.length; i++)
		{
			System.out.println(copy1[i].toString());
		}
		System.out.println("\nDisplay the cards in the hand:");
		System.out.println(myHand.toString());
		
		Card card2 = theDeck.dealCard();
		myHand.replaceCard(0, card2);
		System.out.println("\nReplacing the card in position 0 with a deck card and display the cards in the hand:"
				+ "\n" + myHand.toString());
		
		Card card3 = new Card(40);
		if(myHand.searchCard(card3))
			System.out.println("The hand has the Ace of spades.");
		else
			System.out.println("The hand does not have the Ace of spades.");
		
		int faceCard = myHand.findNumFaceCards();
		System.out.println("\nThere are " + faceCard + " face card(s) in the hand.");
		
		Card card4 = theDeck.dealCard();
		myHand.replaceLowCard(card4);
		System.out.println("\nRplacing the lowest card with a deck card and display the cards in the hand:"
				+ "\n" + myHand.toString());		
		
	}
	
}
