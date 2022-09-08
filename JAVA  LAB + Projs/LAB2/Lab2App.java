package lab2;
import java.util.Scanner;

/**
 * <p> Title: Lab 2: Parsing a URL </p>
 * <p> Description: Ask the user to enter a URL and it will display
 * the protocol, domain name and file name specified. </p>
 * @author Kyunghoon Oh
 */

public class Lab2App 
{
    /**
     * <p> Name: main method </p>
     * 
     * @param args values to be sent to the method
     */
	public static void main(String[] args)
	{
		String url;
		int positionOfColon;
		String protocol;
		String restOfUrl;
		String domainName;
		String fileName;
		int positionOfSlash;
		int fileNameLength;
		char firstLetter;
		char lastLetter;
		
		// set up the Scanner object for reading user input
		Scanner scanner = new Scanner(System.in);
		
		// prompt the user to enter a URL
		System.out.println("Please enter a URL:");		
		url = scanner.nextLine();  
		
		positionOfColon = url.indexOf(":"); // after :
		
		protocol = url.substring(0, positionOfColon); // 0~4 http
		
		restOfUrl = url.substring(positionOfColon + 7); // after p
		
		positionOfSlash = restOfUrl.indexOf("/"); // posionofslash  after /
		
		domainName = restOfUrl.substring(0, positionOfSlash); //
		
		fileName = restOfUrl.substring(positionOfSlash + 1);

		fileNameLength = fileName.length();
		
		firstLetter = fileName.charAt(0);
		
		lastLetter = fileName.charAt(fileName.length() - 1);
		
		// output
		System.out.println("The URL is " + url);
		System.out.println("The position of the colon is " + positionOfColon);
		System.out.println("The protocol is " + protocol);
		System.out.println("The rest of the URL is " + restOfUrl);
		System.out.println("The position of the slash is " + positionOfSlash);
		System.out.println("The domainName is " + domainName);
		System.out.println("The file name is " + fileName);
		System.out.println("The length of the filename is " + fileNameLength);
		System.out.println("The first letter of the filename is " + firstLetter);
		System.out.println("The last letter of the filename is " + lastLetter);
	}
}
