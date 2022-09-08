import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DateGUI extends JFrame{
   JFrame fr;
   TextArea datesUnsort, datesSort;
   public DateGUI(String tit, int hgh, int wdt) {
      setTitle(tit);
      setSize(hgh,wdt);
      setLocation (400,200);
      createFileMenu();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
}
   // Creating file menu
   private void createFileMenu( ) {
      JMenuItem   itm;
      JMenuBar    barOfMenu = new JMenuBar();
      JMenu       menuOfFile = new JMenu("File");
      handleMenu fmh = new handleMenu(this);

      itm = new JMenuItem("Open");
      itm.addActionListener( fmh );
      menuOfFile.add( itm );

      menuOfFile.addSeparator();       
  
      itm = new JMenuItem("Quit");     
      itm.addActionListener( fmh );
      menuOfFile.add( itm );

      setJMenuBar(barOfMenu);
      barOfMenu.add(menuOfFile);
  
   }

}