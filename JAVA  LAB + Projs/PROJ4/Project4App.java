package proj3;
import java.util.Scanner;
/**
 * <p>Title: Project4 Application class</p>
 * 
 * <p>Description: proj4 class is to create a math game for children to play.
 * n order for the game to allow the student to get enough practice, the game will 
 * ask the student 10 questions.  If the student gets the first 10 questions correct,
 *  the game should end.  Otherwise, the game should continue until one of two 
 *  things happen: 1) the student’s percent of correct answers reaches at least 85%, 
 *  or 2) the student has completed 20 questions. When the game ends, the student should 
 *  be told the number of addition questions he/she got correct and incorrect as well as 
 *  the number of subtraction questions he/she got correct and incorrect.  It should also 
 *  give a score which is the percent of questions he/she got correct.
 *  Use correct loop.</p>
 * 
 * 
 * @author Kyunghoon Oh
 */

public class Project4App {
	
	private static Scanner scanner;
	/**
	 * <p> Name: main method </p>
	 *  
	 * @param args values to be sent to the method
	 */	
	public static void main(String[] args)
	{
		
		
		//Declaring int variables to store values of correct/wrong problems
	    int numCorrect = 0;
	    
	    int totalQuestions = 0;
	    double percent = 0;
	    int subNumCorrect = 0;
	    int subNumWrong = 0;
	    int addNumCorrect = 0;
	    int addNumWrong = 0;	    
	    scanner = new Scanner(System.in);
	    
        do {
        	Question theQuestion = new Question();
	    
            System.out.println("What is the result?" + "\n" + theQuestion.toString());
            int result = scanner.nextInt();

	        // Checks if the question is addition/subtraction and correct/wrong, then increases the variables 1 

	        if((theQuestion.getOperator() == '+') && (result == theQuestion.determineAnswer()))
	            addNumCorrect += 1;
	        else if(theQuestion.getOperator() == '+' && (result != theQuestion.determineAnswer()))
	            addNumWrong += 1;

	        if((theQuestion.getOperator() == '-') && (result == theQuestion.determineAnswer()))
	            subNumCorrect += 1;
	        else if((theQuestion.getOperator() == '-') && (result != theQuestion.determineAnswer()))
	            subNumWrong += 1;

	        //Determines if the users answer is correct or not, and displays a message accordingly
	        //As well as keeping count of how many correct/wrong answers are attempted by the user and storing them
	        //in the variable numCorrect/numWrong
	        if(result == theQuestion.determineAnswer()) {
	            numCorrect += 1; 
	            System.out.println("Congratulations, you got it correct!");
	        }
	        else if(result != theQuestion.determineAnswer()) {
	            
	            System.out.println("The correct answer for " + theQuestion.toString()
	                + " is " + theQuestion.determineAnswer());

	        }
	        //Increasing value of totalQuestions by one every loop
	        totalQuestions++;

	        //Multiplying the number of correct problems by 100 and dividing the product by the number of
	        //total questions. Then rounding the quotient to get the percentage of correct answers
	        percent = Math.round((double)(numCorrect * 100) / (totalQuestions));
	    } while(totalQuestions < 10 || percent <= 85.0 && totalQuestions < 20);
	    //Progress report displaying how many addition and subtraction problems the user got correct and wrong
	    //Then determines the percentage of correct problems the user entered


	    System.out.println("\nProgress Report:" + "\nAddition:\nYou got " + addNumCorrect
	        + " correct and " + addNumWrong + " incorrect.");
	    System.out.println("Subtraction:\nYou got " + subNumCorrect
	        + " correct and " + subNumWrong + " incorrect.");	    
	    System.out.println("The percent correct is " + percent + "%");

	}

}
