/**
 * Kyunghoon Oh
 * CS 212 Lab
 */

	 
import java.awt.Font;


import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.File;
import java.util.Comparator;

import java.util.Scanner;

import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.BufferedReader;
import javax.swing.JFileChooser;

import javax.swing.JFrame;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ClockGUI extends JFrame {
	TreeMap <Clock, String> treeMap = new TreeMap <>();
      // defining all required components

      // declaring one UnsortedList and one SortedList

      private UnsortedClockList unsortedList;
     
     private SortedClockList sortedList;
      
      // text areas to display unsorted and sorted texts

      JTextArea unsortedText, sortedText;

      // new variables for menu components

      JMenuItem openFile, quit, insert;

      /**

      * method to load dates from an input file, and fill the two lists, and then

      * update the text areas

      */

      public void loadFromFile(String filename) {
    	   
            // initializing lists
    	  
          Scanner bufferedScanner = null;
            unsortedList = new UnsortedClockList();
            
            sortedList = new SortedClockList();

            try {
            	 String line;
                 int hours;
                 int minutes;
                 int seconds;
                 bufferedScanner  = new Scanner(new BufferedReader(new FileReader(filename)));
            	
                 //define the scanner object for that file
          	  
                 
                 //Read line by line in the file
                 
                 while ((line = bufferedScanner.nextLine()) != null)
                 {
                	 
              	   StringTokenizer st = new StringTokenizer(line, ":");
              	   
              		   
              	   
              	 if(st.countTokens()!=3)
                 {
                	System.out.println(line);
              	   }
                     else
                     {
                    	 hours = Integer.parseInt(st.nextToken());
                         minutes = Integer.parseInt(st.nextToken());
                         seconds = Integer.parseInt(st.nextToken());
                         try {          
                        	 Clock clock = new Clock(hours, minutes, seconds);
                         sortedList.add(clock);
                         unsortedList.add(clock);
                        
                     }  catch(IllegalClockException exc) {
                         System.out.println(exc.getMessage() + hours + ":" + minutes + ":" + seconds);
                     
                 }
                 }
                 
                 }
            }
            
           //If the input text file is invalid
           catch (Exception e)
            
           {               

           }     

            // appending all dates to the both text fields

            unsortedText.setText(unsortedList.toString());
           
            sortedText.setText(sortedList.toString());

      }
     
      public class ClockComparator implements Comparator <Clock> {
          public int compare(Clock num1, Clock num2) {
             return num1.compareTo(num2);
          }
       }

      public ClockGUI(String inputFileName) {

            /**

            * using a GridLayout with 1 row and 2 columns to display elements

            */

            setLayout(new GridLayout(1, 2, 10, 10));

            // initializing ui components
            JTextArea left = new JTextArea();

    		// making it not editable (by user)
    		unsortedText = new JTextArea();

            unsortedText.setLineWrap(true);

            // using a bigger font size

            unsortedText.setFont(new Font("SansSerif", Font.PLAIN, 15));

            sortedText = new JTextArea();

            sortedText.setLineWrap(true);

            sortedText.setFont(new Font("SansSerif", Font.PLAIN, 15));
            

    		//Adding the text area
    		
            add(unsortedText);

            add(sortedText);

            /**

            * setting up menu bar

            */

            JMenuBar menuBar = new JMenuBar();

            JMenu fileMenu = new JMenu("File");
            JMenu editmenu = new JMenu("Edit");

            openFile = new JMenuItem("Open");
            insert = new JMenuItem("Insert");

            quit = new JMenuItem("Quit");

            fileMenu.add(openFile);
            editmenu.add(insert);

            fileMenu.add(quit);

            menuBar.add(fileMenu);
            menuBar.add(editmenu);

            setJMenuBar(menuBar);

            /**

            * Creating a FileMenuHandler, setting this object as the event handler

            * for opening file option and quit option

            */

            FileMenuHandler handler = new FileMenuHandler();
            EditMenuHandler o = new EditMenuHandler(this);
            
            
            openFile.addActionListener(handler);
            insert.addActionListener(o);

            quit.addActionListener(handler);

            setSize(600, 400);

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            setTitle("Clock");

            setVisible(true);

            // loading time from file, adding to lists, displaying on text fields

            loadFromFile(inputFileName);

      }

     

	/**

      * inner class representing action listener for file operations in menu bar

      */

      class FileMenuHandler implements ActionListener {

            @Override

            public void actionPerformed(ActionEvent e) {

                  // finding source of action

                  if (e.getSource().equals(openFile)) {

                       // creating and displaying a file opening dialog

                       JFileChooser fileChooser = new JFileChooser(

                                   System.getProperty("user.dir"));

                       int choice = fileChooser.showOpenDialog(ClockGUI.this);

                       // checking if a file has been chosen correctly

                       if (choice == JFileChooser.APPROVE_OPTION) {

                             // getting selected file

                             File f = fileChooser.getSelectedFile();

                             // loading time from file

                             loadFromFile(f.getAbsolutePath());

                       }

                  } else if (e.getSource().equals(quit)) {

                       System.exit(0);

                  }

            }

      }
      class EditMenuHandler implements ActionListener {
    	  
    		ClockGUI gui;
    		private String str;
    		public EditMenuHandler (ClockGUI gui) {
    			this.gui=gui;
    		}
    		
    		public void actionPerformed(ActionEvent event) {
    			unsortedList = new UnsortedClockList();
    			
                sortedList = new SortedClockList();
    			String menuName =event.getActionCommand();
    			if(menuName.equals("Insert")) {
    				try {
    					int hours;
    	                 int minutes;
    	                 int seconds;
    					
    	                 
    					str=JOptionPane.showInputDialog(null,"Enter a new hours with the format hh:mm:ss,all digits");
    					for(int i=0;i<str.length();i++) {
    						if(Character.isDigit(str.charAt(i))==false)
    							throw new IllegalClockException("character entered invalid,try again.");
    					}
    					if(str.length()!=6)
    						throw new IllegalClockException("character entered invalid,try again.");
    					hours = Integer.parseInt(str.substring(0, 2));
    					if(hours>23||hours<0)
    						throw new IllegalClockException("character entered invalid,try again.");    					
    					minutes = Integer.parseInt(str.substring(2, 4));
    					if(minutes>59)
    						throw new IllegalClockException("character entered invalid,try again.");
    					seconds = Integer.parseInt(str.substring(4, 6));
    					if(seconds>59)
    						throw new IllegalClockException("character entered invalid,try again.");    
    					
    					System.out.println(hours+":"+minutes+":"+seconds);
    					
    				}
    				catch(IllegalClockException e) {
    					System.out.println(e);
    				}
    				
    				
    			}
    		}
    		
    	}


}