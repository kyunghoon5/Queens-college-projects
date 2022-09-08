import javax.swing.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame;
import java.awt.*;
import java.util.StringTokenizer;
import java.awt.event.*;
import java.io.*;
import java.util.TreeMap;
import java.util.Set;
import java.util.Comparator;

public class DateGUI extends JFrame {
    private static Date212 date;
    public static StringTokenizer myTokens;
    public static String line;
    public static TextFileInput inFile;
    public static TextArea unsortedList = new TextArea();
    public static TextArea sortedList = new TextArea();
    public static Container myContentPane;
    public static JFrame dateFrame;
    private static Date212 rDate;
    private static Date212 iDate;
    private String[] hi;
    TreeMap <Date212, Integer> Dates = new TreeMap <Date212, Integer>( new DateComparator() );
            //Key,value

    /*
        Some variables are declared here, some are initliazed here to provide global support for the methods.
    */
    

   public DateGUI(String title, int height, int width) {
        setTitle(title);
        setSize(height,width); //height and width
        setLocation (400,200);
        setLayout(new GridLayout(1, 2));
        createDosMenu();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
   } //DateGUI constructor.
   private void createDosMenu() {
      JMenuItem   item;
      JMenuBar    menuBar = new JMenuBar();
      JMenu       fileMenu = new JMenu("File"); //Name of the menu in the bar
      JMenu       editMenu = new JMenu("Edit");
      EditMenuHandler emh = new EditMenuHandler(this);
      FileMenuHandler fmh = new FileMenuHandler(this); //The FileMenuHandler which holds the menu bar options amongst more and passes in DateGUI-"this".

        item = new JMenuItem("Open");    //Open is a menu item.
        item.addActionListener( fmh );
        fileMenu.add( item ); //The process of acutally adding the item to the menu!

    fileMenu.addSeparator();           //add a horizontal separator line between "Open" and "Quit".
  
    item = new JMenuItem("Quit");       //Quit is a menu item.
        item.addActionListener( fmh );
        fileMenu.add( item );
        menuBar.add(fileMenu);

    item = new JMenuItem("Insert");    //Insert is a menu item.
        item.addActionListener( emh );
        editMenu.add( item ); //The process of acutally adding the item to the menu!
      
        menuBar.add(editMenu);
      setJMenuBar(menuBar); //Like the "setVisible", it makes the menuBar visible.

  
   } //CreateDosMenu method

  
    public class EditMenuHandler implements ActionListener {
         String dateInput;

    public EditMenuHandler(JFrame jf) { //Works on the JFrame passed in.
        dateFrame = jf;
    }//EditMenuHandler constructor method
  
    public void actionPerformed(ActionEvent event) {

        String menuName = event.getActionCommand();
            if (menuName.equals("Insert")) dateInput = JOptionPane.showInputDialog(null, "Enter a new date in the 8 digit format (yyyyMMdd), as in the file.");

        inputDate(dateInput);
    } //actionPerformed

     public void inputDate(String d){
         int p = 0; //For the purpose of value in treeMap.
         myContentPane = dateFrame.getContentPane();

            myContentPane.add(unsortedList);
            myContentPane.add(sortedList);
                  
            try{
                    iDate = new Date212(d);
                    
                    Dates.put(iDate, ++p);

                    // Set<Date212> keys = Dates.keySet();
                    // for(Date212 key:keys){
                    //     System.out.println(key+" ==> "+Dates.get(key));
             } catch(Date212Exception e){
                System.out.println(e);
                 }

                 Set<Date212> value = Dates.keySet();
                    sortedList.append("\n");
                    for(Date212 key:value) sortedList.append(key+ "\n");
                 //Using the Set method, we run the for loop(enhanced) which basically says for every Date212 key with a value, the key should be outputted.

        dateFrame.setVisible(true); //to set it visible again.
        }// inputDate method
}//EditMenuHandler method

    public class DateComparator implements Comparator <Date212> {
        public int compare(Date212 num1, Date212 num2) {
           return num1.compareTo(num2);
        }
     }

   public class FileMenuHandler implements ActionListener { //A action listener to respond to the client's request.

        public FileMenuHandler (JFrame jf) { //The constructor for the class which accepts a JFrame jf, which is set equal to the frame created.
            dateFrame = jf;
        }//FileMenuHandler constructor method

        public void actionPerformed(ActionEvent event){
            String menuName;

            menuName = event.getActionCommand(); //Waits for the action
                if (menuName.equals("Open"))
                    openFile( ); //Calls the method...
                else if (menuName.equals("Quit")) //If Quit is selected then program is exited.
                     System.exit(0); //Exits the programs
        } //actionPerformed method

   /**
   This method listens for the event and includes the "openFile" and "readSource" methods.
    */

        private void openFile() {
            JFileChooser chooser;
            int status;

        chooser = new JFileChooser(); //GUI for choosing a file.
        status = chooser.showOpenDialog(null);
    
            if (status == JFileChooser.APPROVE_OPTION) //If file successfully is selected then call "readSource method" with the file chosen.
                readSource(chooser.getSelectedFile());
            else
                JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile method

     /**
   This method takes care of the opening the file.
    */

    private void readSource(File chosenFile) {
       String chosenFileName = chosenFile.getAbsolutePath(); //Store the fileName as a string. **"getAbsolutePath" to get the full location of the inputted file.
        int p = 0; //For the purpose of value in treeMap.
       myContentPane = dateFrame.getContentPane();

            myContentPane.add(unsortedList);
            myContentPane.add(sortedList);
            //Adding of the textAreas to the contentPane.
     
        inFile = new TextFileInput(chosenFileName);
        line = inFile.readLine(); //Starts the process of reading the file.

      
        while (line != null) {//While there is a line.

                myTokens = new StringTokenizer(line, ",");
          
            while (myTokens.hasMoreTokens()) { //While there is more tokens on the line.
              
                String[] hi = new String [myTokens.countTokens()];
              
                    for(int i =0; i< hi.length; i++){
                  
                        try{
                            hi[i]= myTokens.nextToken();
                            rDate = new Date212(hi[i]);
                                unsortedList.append(rDate + "\n");
                                Dates.put(rDate, ++p);
                                        //Key,value
                            // Set<Date212> keys = Dates.keySet();
                            // for(Date212 key:keys){
                            //     System.out.println(key+" ==> "+Dates.get(key));
                            //     // unsortedList.append(rDate.toString() + "\n");
                            // }
                        } catch(Date212Exception e){
                                System.out.println(e);
                            }
                    }
            }
            line = inFile.readLine(); //Read next line.
        }
             inFile.close(); // FileInput closed

             Set<Date212> value = Dates.keySet(); //Returns a set view of keys in this treeMap.
                for(Date212 key:value) sortedList.append(key+ "\n");
        //Using the Set method, we run the for loop(enhanced) which basically says for every Date212 key with a value, the key should be outputted.

        dateFrame.setVisible(true); //to set it visible again.

    System.out.println(chosenFileName + "has been read");
        }//readSource method

        /*
            This method reads the file using fileInput and String Tokenizer; Appends onto the linked list and onto the contentPanes.
            Using a try catch block, it see if the date can be added, if not then catch the error and output it
    */
  
}//FileMenuHandler method
  
}//Class DateGUI