/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.List;

public class ClockGUI {

   /*
   * Method to Show Both Clocks in Grid Layout i.e. in Natural order as given in
   * file and in sorted order
   */  
   public void showBothClocksInGridLayout(Clock[] clockNaturalOrder, Clock[] clockSortedOrder, int clockCount) {

       //Creating frame class object to store both the list
       JFrame clocksFrame= new JFrame("Clock");

       //AWT list to store natural order array
       List naturalOrderList=new List(clockCount);

       /*
       * Setting various parameters of list i.e. x coordinate=100, y coordinate=100
       * width=75 and height=300
       */
       naturalOrderList.setBounds(100,100, 75,300);

       //AWT list to store sorted order array
       List sortedOrderList=new List(clockCount);

       /*
       * Setting various parameters of list i.e. x coordinate=100, y coordinate=100
       * width=75 and height=300
       */
       sortedOrderList.setBounds(100,100, 75,300);

       /*
       * Adding each list item into the natural order list and sorted order list from
       * the arrays clockNaturalOrder and clockSortedOrder respectively
       */       for(int i=0;i<clockCount;i++) {

           naturalOrderList.add(clockNaturalOrder[i].toString());

           sortedOrderList.add(clockSortedOrder[i].toString());
       }

       //Adding natural order list to frame
       clocksFrame.add(naturalOrderList);
      
       //Adding sorted order list to frame
       clocksFrame.add(sortedOrderList);
      
       //Setting size of the diplay frame
       clocksFrame.setSize(400,400);
      
       /*
       * Setting layout of the frame as a 1x2 grid layout to display our list in table
       * format
       */
       clocksFrame.setLayout(new GridLayout(1,2));
       //closing Jframe
       clocksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       //Making visible our frame
       clocksFrame.setVisible(true);
   }
}