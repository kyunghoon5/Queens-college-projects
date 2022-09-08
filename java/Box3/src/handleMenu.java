import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class handleMenu implements ActionListener {
    JFrame jf;
   static UnsortedDateList list_unsort = new UnsortedDateList();
   static SortedDateList list_sort = new SortedDateList();
   public handleMenu (JFrame j) {
      jf = j;
   }
   public void actionPerformed(ActionEvent e) {
         String menus;
      menus = e.getActionCommand();
      if (menus.equals("Open"))
         try {
             openFile( );
      } catch (FileNotFoundException ex) {
      } catch (IOException ex) {
      }
      else if (menus.equals("Quit"))
         System.exit(0);
    }

    private void openFile( ) throws FileNotFoundException, IOException {
        BufferedReader buffread = new BufferedReader(
                  new InputStreamReader(
        new FileInputStream("inp.txt")));
         jf.setLayout(new GridLayout(1, 2));
       TextArea datesUnsort = new TextArea();
       TextArea datesSort = new TextArea();
       jf.getContentPane().add(datesUnsort);
       jf.getContentPane().add(datesSort);
       String lin = buffread.readLine();
        while (lin != null) {
            StringTokenizer tok = new StringTokenizer(lin, ",");
            while (tok.hasMoreTokens()) {
             String str = tok.nextToken();
                Date212 da = new Date212(str);
                list_unsort.add(da);
                list_sort.add(da);
          }
            lin = buffread.readLine();
          
        }
        datesUnsort.append("Unsorted Dates: " + "\n");
        datesUnsort.append(list_unsort.toString());
        datesSort.append("Sorted Dates: " + "\n");
        datesSort.append(list_sort.toString());
        jf.setVisible(true);
    } //openFile

     
   }