/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project1 {

   public static void main(String[] args) {

       //Array to store clock objects in natural order i.e. in the order it present in the file
       Clock clockNaturalOrder[]=new Clock[100];

       //Array to store clock objects in sorted order after performing selection sort
       Clock clockSortedOrder[]=new Clock[100];

       //Initializing clockCount to 0
       int clockCount=0;


       try {
           /*
           * Creating scanner object with the given file The clock contents are present in
           * input.txt file at the same path where this Project1.java file is present
           */
           Scanner scanner = new Scanner(new File("project1.txt"));

           //Read each line content from the file
           while(scanner.hasNextLine()) {

               //Reading line from the file
               String clockLine=scanner.nextLine();
               //Creating tokens of the line by splitting it using colon :
               StringTokenizer clockTokens = new StringTokenizer(clockLine, ":");

               //If no of token count is less than three then display that clock string
               if(clockTokens.countTokens()<3) {
                   System.out.println(clockLine);
               }
               //Otherwise perform following steps
               else {
                   //Create clock class object
                   Clock clock=new Clock(Integer.parseInt(clockTokens.nextToken()),Integer.parseInt(clockTokens.nextToken()),Integer.parseInt(clockTokens.nextToken()));
                   //Store this object in both the arrays
                   clockNaturalOrder[clockCount]=clock;
                   clockSortedOrder[clockCount]=clock;
                   //Increment clockCount
                   clockCount++;
               }      
           }

           //Closing scanner to save it from leaking of the memory
           scanner.close();

           //Invoke method to convert the clockSortedOrder values in sorted form
           //As initially while taking the input we have stored it in natural order
           convertClockArrayInSortedOrder(clockSortedOrder, clockCount);

           //Creating clockGUI class object
           ClockGUI clockGUI=new ClockGUI();

           //Invoking ClockGUI class showBothClocksInGridLayout method to display in Grid Layout
           clockGUI.showBothClocksInGridLayout(clockNaturalOrder, clockSortedOrder, clockCount);


       } catch (FileNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
   }

   //Sort the array using sorted array in ascending order
   private static void convertClockArrayInSortedOrder(Clock[] clockSortedOrder, int clockCount) {

       //Iterate the loop till clockCount-1 values
       for (int i = 0; i < clockCount-1; i++) {

           //Initialize the smallest index as first element index
           int smallestIndex = i;

           /*
           * Iterating from i+1 to clockCount to find smallestIndex in each subarray The
           * As our array does not contains elements of a normal primitive data type
           * it is having clock objects. To compare the elements I am first comparing hours
           * if hours are equal then comparing minutes and in the last if minutes are equal then
           * comparing seconds to find the smallest index element
           */          
           for (int j = i+1; j < clockCount; j++) {
               if (clockSortedOrder[j].getHours() < clockSortedOrder[smallestIndex].getHours()) {
                   smallestIndex = j;
               }
               else if(clockSortedOrder[j].getHours() == clockSortedOrder[smallestIndex].getHours()){
                   if(clockSortedOrder[j].getMinutes()<clockSortedOrder[smallestIndex].getMinutes()){
                       smallestIndex=j;
                   }
                   else if(clockSortedOrder[j].getMinutes()==clockSortedOrder[smallestIndex].getMinutes()){
                       if(clockSortedOrder[j].getSeconds()<clockSortedOrder[smallestIndex].getSeconds())
                           smallestIndex=j;
                   }
               }
           }
           //Swap the element at minimum index to the first element
           Clock tempClock = clockSortedOrder[smallestIndex];
           clockSortedOrder[smallestIndex] = clockSortedOrder[i];
           clockSortedOrder[i] = tempClock;
       }
   }
}