package proj5;

/**
 * <p>Title: Project5</p>
 * 
 * <p>Description:
 *  To practice writing code that uses arrays of primitives, to practice using conditional statement and for loop.
 *  to gain experience in developing program logic.
 * @author Kyunghoon Oh
 *
 */

public class DiceArray 
{
    //instance variables
    private int[] dice;
    private boolean[] diceToRoll;

    /**
     * Name: Parameterized Constructor 
     * Description: Receives the number of dice, and instantiates both instances variables. 
     * @param numDice the number of dice to be used
     */
    public DiceArray(int numDice)
    {
        dice = new int[numDice];
        diceToRoll = new boolean[numDice];

        for(int i = 0; i < dice.length; i++)
        {   
            dice[i] = -1;
            diceToRoll[i] = true;
        }   
    }

    /**
     * Name: toString method 
     * Description: Create and return a string with the values of the dice, and whether or not they are kept.
     * @return a String with the values of the die and whether or not they are true or false
     */
    public String toString()
    {
        String output = "";
        for(int i = 0; i < dice.length; i++)
        {
            output += dice[i] + " ";
        }
        output += "\n";
        for(int i = 0; i < dice.length; i++)
        {   
            if (diceToRoll[i] == true)
                output += "T" + " ";
            else
                output += "F" + " ";
        }

        return output;
    }

    /**
     * Name: roll method 
     * Description: Rolls dice based on which ones are set to 'true'. 
     */
    public void roll()
    {
        for (int i = 0; i < dice.length; i++)
        {   
            if (diceToRoll[i] == true)
                dice[i] = (int)(Math.random() * 6 + 1);
        }   
    }

    /**
     * Name: getDice method 
     * Description: Return the reference of the array dice.
     * @return the value of the reference of the array.
     */
    public int[] getDice()
    {
    	int[] diceCopy = new int[dice.length];
    	for(int i = 0; i < dice.length; i++)
    		diceCopy[i] = dice[i];
    	return diceCopy;
    }

    /**
     * Name: reset method 
     * Description: Sets all the diceToRoll values to true, allowing them all to be 
     * rolled the next time the roll method is called. 
     */
    public void reset()
    {
        for (int i = 0; i < dice.length; i++)
            diceToRoll[i] = true;
    }

    /**
     * Name: keep method 
     * Description: Will accept an int that indicates which of the dice value that should be kept. 
     * @param diceVal the value to be compared to the dice values
     */
    public void keep(int diceVal)
    {
        for(int i = 0; i < dice.length; i++)
        {
            if(dice[i] == diceVal)
                diceToRoll[i] = false;
            else
                diceToRoll[i] = true;
        }
    }

    /**
     * Name: calculateTotal method 
     * Description: Will accept an int indicating which of the values to calculate a total for. 
     * @param val the value of the dice values to be added together
     * @return an int of the sum of the values
     */ 
    public int calculateTotal(int val)
    {
        int sum = 0;

        for(int i = 0; i < dice.length; i++)
        {
            if (dice[i] == val)
                sum = sum + val;
        }

        return sum;
    }


}
