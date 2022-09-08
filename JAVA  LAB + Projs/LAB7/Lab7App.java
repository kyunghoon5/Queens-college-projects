package lab7;



/**
 * <p>Title: The Lab7App class</p>
 *
 * <p>Description: This class will be used to thoroughly test the 
 * various methods in the PokerHand class.  The seven cards specified 
 * will be used to test each method.</p>
 *
 * @author Kyunghoon Oh
 */
public class Lab7App
{
    /**
     * <p> Name: main method </p>
     * 
     * @param args values to be sent to the method
     */
	public static void main(String[] args)
	{
		testFourOfAKind();
		testFlush();
		testThreeOfAKind();
		testPair();
		testLowCard();
    }
    
    /**
     * <p> Name: testFourOfAKind method </p>
     * 
     * <p> Description: tests the fourOfAKind method in the PokerHand class.</p>
     */
	public static void testFourOfAKind()
	{
		
		// cards to be used to test the various methods
		// in the PokerHand class
		Card twoClubs = new Card(2);
		Card twoDiamonds = new Card(15);
		Card twoHearts = new Card(28);
		Card twoSpades = new Card(41);
		Card threeClubs = new Card(3);
		Card fourClubs = new Card(4);
		Card fiveClubs = new Card(5);
		PokerHand pokerHand = new PokerHand(twoClubs, twoDiamonds, twoHearts, twoSpades);
		System.out.println("Testing fourOfAKind method:" + "\n" + pokerHand.toString());
		if (pokerHand.fourOfAKind() == true)
			System.out.println("Four of a kind" + "\n");
		else
			System.out.println("Not four of a kind" + "\n");
		
		pokerHand.replaceCard( 2, threeClubs);
		System.out.println("Replaced the 2 of diamonds with the 3 of clubs:" + "\n" + pokerHand.toString());
		if (pokerHand.fourOfAKind() == true)
			System.out.println("Four of a kind" + "\n");
		else
			System.out.println("Not four of a kind" + "\n");
		
			
			
		
		
		
	}
	
    /**
     * <p> Name: testFlush method </p>
     * 
     * <p> Description: tests the flush method in the PokerHand class.</p>
     */
	public static void testFlush()
	{
		// cards to be used to test the various methods
		// in the PokerHand class
		Card twoClubs = new Card(2);
		Card twoDiamonds = new Card(15);
		Card twoHearts = new Card(28);
		Card twoSpades = new Card(41);
		Card threeClubs = new Card(3);
		Card fourClubs = new Card(4);
		Card fiveClubs = new Card(5);
		PokerHand pokerHand = new PokerHand(twoClubs, twoDiamonds, twoHearts, twoSpades);		
		
		pokerHand.replaceCard( 2, threeClubs);		
		System.out.println("Testing flush method:" + "\n" + pokerHand.toString());
		if (pokerHand.flush() == true)
			System.out.println("Flush" + "\n");
		else
			System.out.println("Not a flush" + "\n");
		
		pokerHand.replaceCard( 2, threeClubs);
		pokerHand.replaceCard( 3, fourClubs);
		pokerHand.replaceCard( 4, fiveClubs);		
		System.out.println("Replaced the 2 of hearts with the 4 of clubs and"
				+ " the 2 of spades with the 5 of clubs:" + "\n" + pokerHand.toString());
		if (pokerHand.flush() == true)
			System.out.println("Flush" + "\n");
		else
			System.out.println("Not a flush" + "\n");
		
		
		
		
	}
	
    /**
     * <p> Name: testThreeOfAKind method </p>
     * 
     * <p> Description: tests the threeOfAKind method in the PokerHand class.</p>
     */
	public static void testThreeOfAKind()
	{
		// cards to be used to test the various methods
		// in the PokerHand class
		Card twoClubs = new Card(2);
		Card twoDiamonds = new Card(15);
		Card twoHearts = new Card(28);
		Card twoSpades = new Card(41);
		Card threeClubs = new Card(3);
		Card fourClubs = new Card(4);
		Card fiveClubs = new Card(5);
		PokerHand pokerHand = new PokerHand(twoClubs, twoDiamonds, twoHearts, twoSpades);
		pokerHand.replaceCard( 2, threeClubs);
		pokerHand.replaceCard( 3, fourClubs);
		pokerHand.replaceCard( 4, fiveClubs);
		System.out.println("Testing threeOfAKind method:" + "\n" + pokerHand.toString());
		if (pokerHand.threeOfAKind() == true)
			System.out.println("Three of  a kind" + "\n");
		else
			System.out.println("Not three of  a kind" + "\n");
		pokerHand.replaceCard( 2, twoDiamonds);
		pokerHand.replaceCard( 3, twoHearts);
		pokerHand.replaceCard( 4, fiveClubs);
		System.out.println(pokerHand.toString());
		if (pokerHand.threeOfAKind() == true)
			System.out.println("Three of  a kind" + "\n");
		else
			System.out.println("Not three of  a kind" + "\n");
		pokerHand.replaceCard( 2, twoDiamonds);
		pokerHand.replaceCard( 3, threeClubs);
		pokerHand.replaceCard( 4, twoHearts);
		System.out.println(pokerHand.toString());
		if (pokerHand.threeOfAKind() == true)
			System.out.println("Three of  a kind" + "\n");
		else
			System.out.println("Not three of  a kind" + "\n");
		pokerHand.replaceCard( 2, threeClubs);
		pokerHand.replaceCard( 3, twoDiamonds);
		pokerHand.replaceCard( 4, twoHearts);
		System.out.println(pokerHand.toString());
		if (pokerHand.threeOfAKind() == true)
			System.out.println("Three of  a kind" + "\n");
		else
			System.out.println("Not three of  a kind" + "\n");
		pokerHand.replaceCard( 1, threeClubs);
		pokerHand.replaceCard( 2, twoClubs);
		pokerHand.replaceCard( 3, twoDiamonds);
		pokerHand.replaceCard( 4, twoHearts);
		System.out.println(pokerHand.toString());
		if (pokerHand.threeOfAKind() == true)
			System.out.println("Three of  a kind" + "\n");
		else
			System.out.println("Not three of  a kind" + "\n");
		
		
		
	}
	
    /**
     * <p> Name: testPair method </p>
     * 
     * <p> Description: tests the pair method in the PokerHand class.</p>
     */
	public static void testPair()
	{
		// cards to be used to test the various methods
		// in the PokerHand class
		Card twoClubs = new Card(2);
		Card twoDiamonds = new Card(15);
		Card twoHearts = new Card(28);
		Card twoSpades = new Card(41);
		Card threeClubs = new Card(3);
		Card fourClubs = new Card(4);
		Card fiveClubs = new Card(5);
		PokerHand pokerHand = new PokerHand(twoClubs, twoDiamonds, twoHearts, twoSpades);
		pokerHand.replaceCard( 2, threeClubs);
		pokerHand.replaceCard( 3, fourClubs);
		pokerHand.replaceCard( 4, fiveClubs);
		System.out.println("Testing pair method:" + "\n" + pokerHand.toString());
		if (pokerHand.pair() == true)
			System.out.println("pair" + "\n");
		else
			System.out.println("Not a pair" + "\n");
		pokerHand.replaceCard( 2, twoDiamonds);
		pokerHand.replaceCard( 3, fourClubs);
		pokerHand.replaceCard( 4, fiveClubs);
		System.out.println(pokerHand.toString());
		if (pokerHand.pair() == true)
			System.out.println("pair" + "\n");
		else
			System.out.println("Not a pair" + "\n");
		pokerHand.replaceCard( 2, fourClubs);
		pokerHand.replaceCard( 3, twoDiamonds);
		pokerHand.replaceCard( 4, fiveClubs);
		System.out.println(pokerHand.toString());
		if (pokerHand.pair() == true)
			System.out.println("pair" + "\n");
		else
			System.out.println("Not a pair" + "\n");
		pokerHand.replaceCard( 2, fourClubs);
		pokerHand.replaceCard( 3, fiveClubs);
		pokerHand.replaceCard( 4, twoDiamonds);
		System.out.println(pokerHand.toString());
		if (pokerHand.pair() == true)
			System.out.println("pair" + "\n");
		else
			System.out.println("Not a pair" + "\n");
		pokerHand.replaceCard( 1, fiveClubs);
		pokerHand.replaceCard( 2, twoClubs);
		pokerHand.replaceCard( 3, twoDiamonds);
		pokerHand.replaceCard( 4, fourClubs);
		System.out.println(pokerHand.toString());
		if (pokerHand.pair() == true)
			System.out.println("pair" + "\n");
		else
			System.out.println("Not a pair" + "\n");
		pokerHand.replaceCard( 1, fiveClubs);
		pokerHand.replaceCard( 2, twoClubs);
		pokerHand.replaceCard( 3, fourClubs);
		pokerHand.replaceCard( 4, twoDiamonds);
		System.out.println(pokerHand.toString());
		if (pokerHand.pair() == true)
			System.out.println("pair" + "\n");
		else
			System.out.println("Not a pair" + "\n");
		pokerHand.replaceCard( 1, fiveClubs);
		pokerHand.replaceCard( 2, fourClubs);
		pokerHand.replaceCard( 3, twoClubs);
		pokerHand.replaceCard( 4, twoDiamonds);
		System.out.println(pokerHand.toString());
		if (pokerHand.pair() == true)
			System.out.println("pair" + "\n");
		else
			System.out.println("Not a pair" + "\n");
		
		
		
	}
	
    /**
     * <p> Name: testLowCard method </p>
     * 
     * <p> Description: tests lowCard method in the PokerHand class.</p>
     */
	public static void testLowCard()
	{
		// cards to be used to test the various methods
		// in the PokerHand class
		Card twoClubs = new Card(2);
		Card twoDiamonds = new Card(15);
		Card twoHearts = new Card(28);
		Card twoSpades = new Card(41);
		Card threeClubs = new Card(3);
		Card fourClubs = new Card(4);
		Card fiveClubs = new Card(5);
		PokerHand pokerHand = new PokerHand(twoClubs, twoDiamonds, twoHearts, twoSpades);
		pokerHand.replaceCard( 1, twoClubs);
		pokerHand.replaceCard( 2, threeClubs);
		pokerHand.replaceCard( 3, fourClubs);
		pokerHand.replaceCard( 4, fiveClubs);
		System.out.println("Testing lowCard method:" + "\n" + pokerHand.toString());
		System.out.println("The low card is " + pokerHand.lowCard() + "\n");		
		pokerHand.replaceCard( 1, threeClubs);
		pokerHand.replaceCard( 2, twoClubs);
		pokerHand.replaceCard( 3, fourClubs);
		pokerHand.replaceCard( 4, fiveClubs);
		System.out.println(pokerHand.toString());
		System.out.println("The low card is " + pokerHand.lowCard() + "\n");
		pokerHand.replaceCard( 1, threeClubs);
		pokerHand.replaceCard( 2, fourClubs);
		pokerHand.replaceCard( 3, twoClubs);
		pokerHand.replaceCard( 4, fiveClubs);
		System.out.println(pokerHand.toString());
		System.out.println("The low card is " + pokerHand.lowCard() + "\n");
		pokerHand.replaceCard( 1, threeClubs);
		pokerHand.replaceCard( 2, fourClubs);
		pokerHand.replaceCard( 3, fiveClubs);
		pokerHand.replaceCard( 4, twoClubs);
		System.out.println(pokerHand.toString());
		System.out.println("The low card is " + pokerHand.lowCard() + "\n");
		pokerHand.replaceCard( 1, threeClubs);
		pokerHand.replaceCard( 2, twoDiamonds);
		pokerHand.replaceCard( 3, fiveClubs);
		pokerHand.replaceCard( 4, twoClubs);
		System.out.println(pokerHand.toString());
		System.out.println("The low card is " + pokerHand.lowCard() + "\n");
		
		
		
	}
}