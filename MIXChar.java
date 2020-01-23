/**
 * 
 */
package q3;

/**
 * <p>Represents a single MIXChar character. </p>
 * <p>This class contains an array of characters
 *  that includes all the MIXChar characters.
 * It also contains a constructor, useful public methods,
 *  such as isMIXChar, toChar, 
 * toString, toMIXChar, ordinal, and toString.</p>
 * 
 * @author Vitoria Postai Martins
 * @version 1.0
 *
 */

public class MIXChar {
    
    
    /**
     * Constant that represents the delta character.
     */
    private static final char DELTA = '\u0394';
    
    /**
     * Constant that represents the sigma character.
     */
    private static final char SIGMA = '\u03A3';
    /**
     * Constant that represents the PI character.
     */
    private static final char PI = '\u03A0';
    
    /**
     * Constant array that contains all the MIXCharacters.
     */
    private static final char[] MIXCHARS = {' ', 'A', 'B', 'C',
            'D', 'E', 'F', 'G', 'H',  'I', DELTA, 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', SIGMA, PI, 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', 
            '6', '7', '8', '9', '.', ',', '(', ')', '+', '-', '*', '/', 
            '=', '$', '<', '>', '@', ';', ':', '\''};
    
    /**
     * Java character that corresponds to the MIXChar character.
     */
    private char javaMIXChar;
    
    /**
     * Converts c to the corresponding MIXChar,
     *  with exception thrown if conversion not possible.
     * @param c The equivalent java character to be created.
     */
    public MIXChar(char c) {
        if (isMIXChar(c)) {
            javaMIXChar = c;
        } else {
            throw new IllegalArgumentException("Character is not a MIX char");
        }
    }
    
    /**
     * Checks if the passed char is a MIXChar character.
     * @param c The character being checked.
     * @return true if c corresponds to a MIXChar character, false otherwise
     */
    public static boolean isMIXChar(char c) {
        for (int i = 0; i < MIXCHARS.length; i++) {
            if (MIXCHARS[i] == c) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Converts this MIXChar character to corresponding Java char.
     * @return the equivalent java character.
     */
    public char toChar() {
        return javaMIXChar;
    }
    
    /**
     * Returns a String with characters corresponding
     *  to those of the input array.
     * @param chars the MIXCharacters to be converted.
     * @return the String equivalent of the passed array of MIXChar characters.
     */
    public static String toString(MIXChar[] chars) {
        String result = "";
        for (MIXChar a : chars) {
            result += a.toChar();
        }
        return result;
    }
    
    /**
     * Returns array of MIXChar characters corresponding to the chars in s.
     * Throws exception if any if the string's characters do not correspond 
     * to MIXChar character
     * @param s the String to be converted to an array of MIXChar characters.
     * @return a MIXChar that is equivalent to the passed String. 
     */
    public static MIXChar[] toMIXChar(String s) {
        MIXChar[] mchars = new MIXChar[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!isMIXChar(s.charAt(i))) {
                throw new IllegalArgumentException("String has at least "
                        + "one non-MIX character");
            } else {
                MIXChar mchar = new MIXChar(s.charAt(i));
                mchars[i] = mchar;
            }
        }
        return mchars;
    }
    
    /**
     * Finds and returns the numerical value of this MIXChar. 
     * @return the numerical value of this MIXChar. If the character is not a 
     * MIXChar, returns -1.
     */
    public int ordinal() {
        for (int i = 0; i < MIXCHARS.length; i++) {
            if (javaMIXChar == MIXCHARS[i]) {
                return i;
            }
        }
        return -1; 
        
    }
    
    /**
     * Converts this MIXChar to a String object and returns it.
     * @return a String that is equivalent to this MIXChar.
     */
    public String toString() {
        return "" + javaMIXChar;
    }
}
