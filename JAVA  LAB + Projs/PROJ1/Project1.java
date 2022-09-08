package proj1;
import java.util.Scanner;

/**
 * <p>Project1: Debugging Program Logic</p>
 *
 * <p>Description: Fix program error in the code </p>
 *
 * @author KYUNGHOON OH
 */

public class Project1
{
    /**
     * <p> Name: main method </p>
     * 
     * @param args values to be sent to the method
     */
	public static void main(String[] args)
	{
		String fullName;
		int posOfSpace;
		String firstName;
		String lastName;
		int firstNameLength;
		int lastNameLength;
		int fullNameLength;
		char firstInitial;
		char lastInitial;
		double midterm;
		double finalExam;
		double average;
		
		// set up the Scanner object for reading user input
		Scanner scanner = new Scanner(System.in);
		
        // ask the user for their full name
		System.out.println("Please enter your first name, followed by a space, followed by your last name:"); 
		fullName = scanner.nextLine();  

		System.out.println("Please enter your midterm grade:"); 
		midterm = Double.parseDouble(scanner.nextLine());

		System.out.println("Please enter your final exam grade:"); 
		finalExam = Double.parseDouble(scanner.nextLine());

		posOfSpace = fullName.indexOf(" ");
		//if you start from 1 it will be o, so you have to start from 0,
		//and if you use posOfSpace -1, it will not count till "e"
		firstName = fullName.substring(0, posOfSpace); 
	    //  substring(5) is starting from e,so you have to change posOfSpace + 1 that will count from  LastName.		
		lastName = fullName.substring(posOfSpace + 1); 
		
		System.out.println("Name: " + lastName + ", " + firstName + "\n"); //lastname and firstname
		
		firstNameLength = firstName.length(); //should be firstname not lastName
		lastNameLength = lastName.length();
		// it should be firstname.length + lastname.length.
		//if you put fullname.length it will count including "," "space".
		fullNameLength = firstName.length() + lastName.length(); 
		// firstNameLength should be instead of 4
		System.out.println("There are " + firstNameLength + " letters in my first name");
		System.out.println("There are " + lastNameLength + " letters in my last name");
		// fullNameLength should be instead of 11
		System.out.println("There are " + fullNameLength + " letters in my full name\n"); 
		
		firstInitial = firstName.charAt(0); // firstName not fullName
		lastInitial = lastName.charAt(0); //  lastName not fullName and charAt(0)will count T 
		
		System.out.println("First initial: " + firstInitial); //add firstInitial systemout
		System.out.println("Last initial: " + lastInitial + "\n"); 
		
		average = (midterm + finalExam) / 2; // put () if not, finalexam and 2 will divide first.
		
		System.out.println("Midterm: " + midterm);
		System.out.println("Final Exam: " + finalExam); // finalExam not midterm
		System.out.println("\nAverage: " + average);
	}
}
