import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;

   public class EditMenuHandler implements ActionListener {
	   TreeMap<Date212, String> treeMap = new TreeMap<>();
       DateGUI dGUI;
       private Date212 d;
       public EditMenuHandler (DateGUI d) {
       dGUI = d;
       }
       public void actionPerformed(ActionEvent event) {
       String menuName = event.getActionCommand();
       String input = null;
       if (menuName.equals("Insert")) {
       input = JOptionPane.showInputDialog("insert date in the format yyyymmdd: ");
      
       try {
           d = new Date212(input);
           dGUI.sorted.append(d);
           //dGUI.unsorted.append(d);
       }
       catch(Date212Exception d) {
           System.out.println("Date: "+ d );
           JOptionPane.showMessageDialog(null, d);
       }
       dGUI.displaySorted();
       //dGUI.displayUnsorted();
      
       }
       } //actionPerformed
   }