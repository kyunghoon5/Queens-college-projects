
import java.awt.GridLayout;
import javax.swing.*;        

public class Lab11 {
    
   public static void main(String[] args) {
        createAndShowGUI();
   }
   
   private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize( 100,100);//width, height);
        frame.setLocation(200,200);//x, y);
        frame.setLayout(new GridLayout(2,1));

        JTextArea textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);
        JLabel label = new JLabel("The sum of the numbers in the matrix is: ");
        frame.getContentPane().add(label);

        textArea.setText("The matrix should print here");
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        readAndDisplayMatrix(frame, textArea, label);
    }
   
   private static void readAndDisplayMatrix(JFrame myFrame, JTextArea myText,
                                            JLabel myLabel) {
   /*
    * Fill in this method.   
    * It should fill the text area with the matrix (as you did to a
    * message dialog in a previous lab, calculate the sum (code from
    * a previous lab) and set the text of the label to show the sum.
    * Re-display the JFrame using the setVisible(true) method. The
    * matrix is given here.
    */
   
	   int[][] myMatrix = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
	   //clear JTextArea
	   myText.setText("");
	   //display all elements & calculate sum
	   int sum = 0;
	   for(int i = 0; i < myMatrix.length ; i++) {  //for rows
		   for(int j = 0; j < myMatrix[i].length; j++) { //for columns
			   sum += myMatrix[i][j]; //calculate sum
			   myText.append(myMatrix[i][j]+ " "); //append element
		   }
		   //move next line
		   myText.append("\n");
	   }
	   //append sum into JLabel
	   myLabel.setText(myLabel.getText()+" "+sum);
	   //resize jFrame
	   myFrame.pack();
	      
   }

        
}