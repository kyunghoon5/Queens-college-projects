/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
//Define the class name Project2
public class Project2
{
     //main method
     public static void main(String[] args)
     {
          //Defining sorted and unsorted clock lists objects
          SortedClockList sortedClcokList = new SortedClockList();
          UnsortedClockList unsortedClcokList = new UnsortedClockList();
          //define file object with the input text file
          File file = new File("Project1.txt");
          //Read date in the file and save into the string array
          try
          {
               //define the scanner object for that file
        	  @SuppressWarnings("resource")
               Scanner scanner = new Scanner(file);
               //Read line by line in the file
               while (scanner.hasNext())
               {
            	   
            	   
            	   StringTokenizer st = new StringTokenizer(scanner.nextLine(), ":");
                   if(st.countTokens()<3) {
                   
                	   StringBuilder br = new StringBuilder();
                	   while(st.hasMoreTokens()) {
                		  String token = st.nextToken();
                		   
                	   
                       System.out.println(token.length()+":"+token);
                	   }
                   }
                   else
                   {
                       Clock clock = new Clock(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                       sortedClcokList.add(clock);
                       unsortedClcokList.add(clock);
                   }
               }
               //call the Construtor with the objects
               new ClockGUI(sortedClcokList, unsortedClcokList);
          }
          //If the input text file is not exits
          //Display and error message
          catch(FileNotFoundException e) {
         	 System.out.println(e.getMessage());
          }
          //If the input text file is invalid
          catch (Exception e)
          {
               //print the message
               System.out.println("Invalid file format!");

          }          
          

     }

}