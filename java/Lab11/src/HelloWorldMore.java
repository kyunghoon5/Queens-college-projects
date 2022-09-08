        
import javax.swing.*;
public class HelloWorldMore {
    /**
     * Create the GUI and show it.  
     */
	

	      public static void main(String args[]){
	      String input = JOptionPane.showInputDialog(null,"Enter a string");
			int countDigit =0;
			
			for(int i =0; i< input.length(); i++) {
	 			if(Character.isDigit(input.charAt(i))){
				countDigit++;
	}
	}
	 JOptionPane.showMessageDialog(null, "The number of digits:" + countDigit);
	}
	}

