/**
 * 
 */
package q3;

/**
 * <p>The Message represents a Message Object.</p>
 * <p>This class stores the encoded message in a long array,
 * keeps track of the number of characters the message contains with
 * a count variable, stores the message in a MIXChar array, and
 * keeps track of the number of remaining characters when 
 * the number of characters is divided by eleven with the remainder
 * variable.</p>
 * @author Vitoria Postai Martins
 * @version 1.0
 *
 */
public class Message {
    /**
     * Stores the converted longs.
     */
    private long[] a;
    
    /**
     * Counts the number of characters in the message.
     */
    private int count;
    
    /**
     * Holds the message in a MIXChar array.
     */
    private MIXChar[] message;
    
    /**
     * Stores the remainder, or the number that is left 
     * when the length of the message is divided by 11.
     */
    private int remainder;
    
    /**
     * Number of characters to be converted and stored in each 
     * long.
     */
    private final int charsInALong = 11;
    
    /**
     * The base number the MIXChar characters are in.
     */
    private final int base = 56;
    
    
    
    /**
     * Creates a new Message object.
     * @param m the MIXChar array to be converted to a message.
     */
    public Message(MIXChar[] m) {
        count = m.length;
        message = m;
        int aNum;
        remainder = count % charsInALong;
        if (remainder == 0) {
            aNum = count / charsInALong;
        } else {
            aNum = (count / charsInALong) + 1;
        }
        
        a = new long[aNum];
        
        makeLongs(m);
    }
    
    /**
     * Creates a new Message object.
     * @param s the String object to be converted to a message.
     */
    public Message(String s) {
        count = s.length();
        message = MIXChar.toMIXChar(s);
        int aNum;
        remainder = count % charsInALong;
        if (remainder == 0) {
            aNum = count / charsInALong;
        } else {
            aNum = (count / charsInALong) + 1;
        }
        
        a = new long[aNum];
        makeLongs(message);
        
        
    }
    
    /**
     * Returns a String corresponding to the characters in the message.
     * @return the message in a String object.
     */
    public String toString() {
        return MIXChar.toString(message);
    }
    
    /**
     * Converts the longs stored in the long array to a String object, 
     * which is then returned.
     * @return a String object with the values stored in the long array.
     */
    public String toLongs() {
        String result = "";
        for (long l : a) {
            result += Long.toUnsignedString(l) + "\n";
        }
        return result;
    }
    
    /**
     * Helper method to convert the MIXChar message into longs, which 
     * will represent the encoded message.
     * @param m the MIXChar array that represents a message.
     */
    private void makeLongs(MIXChar[] m) {
        int k = 0;
            if (remainder == 0) {
                for (int i = 0; i < a.length; i++) {
                    a[i] = 0;
                    for (int j = 0; j < charsInALong; j++, k++) {
                        a[i] = a[i] * base + m[k].ordinal();
                    }
                }
            } else {
                for (int i = 0; i < a.length - 1; i++) {
                    a[i] = 0;
                    for (int j = 0; j < charsInALong; j++, k++) {
                        a[i] = a[i] * base + m[k].ordinal();
                    }
                }
                a[a.length - 1] = 0;
                for (int i = 0; i < remainder; i++, k++) {
                    a[a.length - 1] = a[a.length - 1] * base + m[k].ordinal();
                }
            }
    }
}
