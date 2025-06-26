public class NonRepeatingCharacterInString {

    static final int NUM_OF_ASCII = 256;
    static char[] char_counter = new char[NUM_OF_ASCII];


    // calculate count of characters in the given string
    static void countCharactersInString(String str) {
        for (int i = 0; i < str.length(); i++) {
            char_counter[str.charAt(i)]++;
        }
    }


    /* The method returns index of first non-repeating
       character in a string. If all characters are repeating 
       then returns -1 */
    static char firstNonRepeating(String str) {
        countCharactersInString(str); // you can play here with case sensitive and not case sensitive string

        for (int i = 0; i < str.length(); i++) {
            if (char_counter[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return 0; // Signal of error no null in String
    }


    // Driver method
    public static void main(String[] args) {
        //String str = "geeksforgeeks";
        String str = "geeksForgeeks";
        //String str = "geeksTest";
        //String str = "gg ";
        //String str = "";

        if (str.isEmpty()) {
            System.out.println("Input string is empty. Please provide input");
        } else {
            char strChar = firstNonRepeating(str);
            if (strChar == 0) {
                System.out.println("No repeating characters");
            } else {
                System.out.println("The very first non-repeating character is : " + strChar);
            }
        }

    }

}
