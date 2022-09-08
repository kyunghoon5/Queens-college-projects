import javax.swing.*;

public class Question4 {

    public static void main(String[] args) {
        String s;
        int count = 0;
        while (true) {
            s = JOptionPane.showInputDialog("Enter a string(STOP to exit): ");
            if (s.equals("STOP"))
                break;

            boolean foundNonLetter = false;
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isLetter(s.charAt(i))) {
                    foundNonLetter = true;
                }
            }

            if (!foundNonLetter) {
                ++count;
            }
        }

        JOptionPane.showMessageDialog(null, count + " strings contains only letters");
    }
}