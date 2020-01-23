package q3;

import java.util.Scanner;

/**
 * <p>The TestMIXChar tests the MIXChar Class and the Message Class.</p>
 * <p>This class reads a message from the user, checks if it is valid, creates 
 * a Message object, and prints the encoded version.</p>
 *
 * @author Vitoria Postai Martins
 * @version 1.0
 */
public class TestMIXChar {
    
    //the following are for reference, you may want to move them or copy them 
    //to another class.
//    private static final char DELTA = '\u0394';
//    private static final char SIGMA = '\u03A3';
//    private static final char PI = '\u03A0';
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message;
        boolean isMixString = true;
        do {
            isMixString = true;
            System.out.println("Please enter your message: ");
            message = scan.nextLine();
            for (int i = 0; i < message.length() && isMixString; i++) {
                char c = message.charAt(i);
                if (!MIXChar.isMIXChar(c)) {
                    isMixString = false;
                    System.out.println("Message has to contain"
                            + " only MIX Characters.");
                }
                
            }
            
        }
        while (!isMixString);
        scan.close();
        Message m = new Message(message);
        System.out.println(m.toLongs());
        System.out.println(m.toString());
        
        System.out.println("Question three was called and ran sucessfully.");
    }
    
}
