package proj3;


/**
 * <p>Title: Project3 Application class</p>
 *
 * <p>Description: This class test the various methods in the Question class to see what is returned and
 * determine if the methods work properly. </p>
 *
 * @author Kyungoon Oh
 */

public class Project3App {
	
	 /**
     * <p> Name: main method </p>
     * 
     * @param args values to be sent to the method
     */
	public static void main(String[] args)
	{
		for (int i = 1; i < 16; i++)//generate 15 questions using for loop
		{	
			Question qS = new Question();
			System.out.println("Question " + i  +  ": " + qS.toString() + qS.determineAnswer());
		}
	}
}
		 
		 
		 
			 			 
		 
		 
		
	


