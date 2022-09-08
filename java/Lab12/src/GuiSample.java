import javax.swing.*;
import java.awt.*;
public class GuiSample{
   public static void main(String[] args) {
      initialize();
   } 
   
   public static void initialize() {
	   //1. create JFrame
	   JFrame  myFrame=new JFrame("GUI Sample");
	   //add closing window event
	   myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   //2. create layout for multiple component. you don't have to create layout if there is only a component
	   GridLayout layout = new GridLayout(1,2);
	   //3. set layout to JFrame
	   myFrame.setLayout(layout);
	   //4. create components
       JTextArea ta1 = new JTextArea(14,20);
       JTextArea ta2 = new JTextArea(14,20);
       //5. get Container from JFrame
       Container con = myFrame.getContentPane();
       //6. add components to Container
       con.add(ta1);
       con.add(ta2);
       //add strings to JTextArea
       ta1.append("left\n JTextArea");
       ta2.append("right\n JTextArea");
       //7. invoke setSize() and setVisible() to show components
       myFrame.setSize(400,400); //you can invoke myFrame.pack() instead of setSize()
       myFrame.setVisible(true);
       
   }
} //class

