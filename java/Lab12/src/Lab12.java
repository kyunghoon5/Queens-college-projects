import javax.swing.*;
import java.awt.*;
public class Lab12{
   
   static TextFileInput inFile;
   static String inFileName = "numbers.txt";
   static JFrame myFrame;
   static Container cPane;
   static TextArea even, odd;
   
   public static void main(String[] args) {
      initialize();
      readNumbersFromFile(inFileName);
      
   }   
   public static void initialize() {
      inFile = new TextFileInput(inFileName);
      even = new TextArea();
      odd = new TextArea();
      myFrame=new JFrame();
      myFrame.setSize(400,400);
      myFrame.setLocation(200, 200);
      myFrame.setTitle("CCCC");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //create layout
      GridLayout layout = new GridLayout(1,2); //1 row & 2 columns
      //set layout to JFrame
      myFrame.setLayout(layout);
      //get Container from JFrame
      Container con =  myFrame.getContentPane();
      //add components to Container
      con.add(even);
      con.add(odd);
   }
   public static void readNumbersFromFile(String fileName){
      /*
       * Add code to this method so...
       * - the two text areas are added to the content pane of the JFrame
       *   (see the code in the PowerPoint on GUIs)
       * - numbers are read from the file, and even numbers are put in 
       *   the TextArea "even", odd numbers in "odd".
       * - At end of file, the JFrame is made visible.
       */
      String line;
      line = inFile.readLine();
      while (line != null) {
          //convert String number to int number
    	  int num = Integer.parseInt(line);
    	  //check number is odd or even
    	  if(num%2 == 1) { //if odd
    		  //append number to odd TextArea
    		  odd.append(num + "\n");
    	  }else { //if even
    		  //append number to even TextArea
    		  even.append(num +"\n");
    	  }
    	  //read next line
          line = inFile.readLine();
       } //while
      //show JFrame
      myFrame.setVisible(true);
      
   } //readSSNsFromFile
   
      
   
   
   
} //SSN

