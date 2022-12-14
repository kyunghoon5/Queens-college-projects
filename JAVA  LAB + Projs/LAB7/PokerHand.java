package lab7;

/**
 * <p>Title: The PokerHand class</p>
 *
 * <p>Description: This class represents a four card hand of cards.
 * The cards in a poker hand can make four of a kind, a flush, three of a
 * kind, a pair as well as find the lowest card in the hand.</p>
 *
 * @author Kyunghoon Oh
 */
public class PokerHand
{
    // instance variables
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    /**
     * parameterized constructor --
     * puts 4 cards into the poker hand
     * @param c1 a reference to a Card object
     * @param c2 a reference to a Card object
     * @param c3 a reference to a Card object
     * @param c4 a reference to a Card object
     */
    
    public PokerHand(Card c1, Card c2, Card c3, Card c4)
    {
    	card1 = c1;
    	card2 = c2;
    	card3 = c3;
    	card4 = c4;
    }



    /**
     * fourOfAKind method --
     * determines if the four cards have the same value
     * @return true if four of a kind exists, false otherwise
     */
	public boolean fourOfAKind()
	{
		if (card1.equalValue(card2) && card1.equalValue(card3) && card1.equalValue(card4) && card2.equalValue(card3) &&
				card2.equalValue(card4) && card3.equalValue(card4))
			return true;
		else
			return false;
	}


	/**
     * flush method --
     * determines if the four cards are of the same suit
     * @return true if a flush exists, false otherwise
     */
	public boolean flush()
	{
		if (card1.equalSuit(card2) && card1.equalSuit(card3) && card1.equalSuit(card4) && card2.equalSuit(card3) &&
				card2.equalSuit(card4) && card3.equalSuit(card4))
			return true;
		else
			return false;
	}



    /**
     * threeOfAKind method --
     * determines the different ways that three of a kind may exist with 4 cards
	 * assumes that four of a kind has already been tested
     * @return true if three of a kind exists, false otherwise
     */
	public boolean threeOfAKind()
	{
		if (card1.equalValue(card2) || card1.equalValue(card3) || card1.equalValue(card4) && card2.equalValue(card3)
				&& card2.equalValue(card4) || card3.equalValue(card4))
			return true;
		else
			return false;
	}
	



    /**
     * pair method --
     * determines the different ways that a pair that may exist with 4 cards
	 * assumes that four of a kind and three of a kind have already been tested
     * @return true if a pair exists, false otherwise
     */
	public boolean pair()
	{
		if (card1.equalSuit(card2) && card1.equalSuit(card3) && card1.equalSuit(card4) && card2.equalSuit(card3) &&
				card2.equalSuit(card4) && card3.equalSuit(card4))
			return false;
		else
			return true;
	}


	 
	 /**
     * lowCard method --
     * finds the card with the lowest value -- if two cards have the 
     * same value, it should return the first card it finds with that value
     * @return a reference to the card with the lowest value
     */
	public Card lowCard() // important
	{
		int card1Val = card1.getValue();
		int card2Val = card2.getValue();
		int card3Val = card3.getValue();
		int card4Val = card4.getValue();
		
		
		
		if (card1Val <= card2Val && card1Val <= card3Val && card1Val <= card4Val)
			return card1;
		else if (card2Val <= card1Val && card2Val <= card3Val && card2Val <= card4Val)
			return card2;
		else if (card3Val <= card1Val && card3Val <= card2Val && card3Val <= card4Val)
			return card3;
		else
			return card4;
		
		
			
	}
	


     /**
     * replaceCard method --
     * replaces the card number with the specified card
     * @param whichCard the number of the card to be replaced
	 * @param otherCard the card to be placed into the poker hand
     */
	public void replaceCard(int whichCard, Card otherCard)
	{
		if (whichCard == 1)
			card1 = otherCard;
		else if (whichCard == 2)
			card2 = otherCard;
		else if (whichCard == 3)
			card3 = otherCard;
		else if (whichCard == 4)
			card4 = otherCard;
	}


    /**
     * toString method
     * @return a reference to a String which contains the value and suit of each
     * of the 4 cards
     */
    public String toString()
    {
        return new String((card1.toString() + "\n" + card2.toString() + "\n" +
                card3.toString() + "\n" + card4.toString()));
    }
}
