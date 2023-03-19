package talkwalk;

import java.util.HashMap;

public class Problem01_Frequency_Interview3_TechnicalInteview2_preparation {

    /*
    Print repeating words and their frequency in a given string. 
    ignore case and extra spaces and comma.
    "Here is a string of words, Words are repeated here"

    Here: 2
    is: 1
    words: 2
    
    ANOTHER DESCRIPTION OF THE SAME PROBLEM by another guy
    In a given string (sentence) extract all the words 
    that were repeated and how many time they were repeated, 
    your search must ignore the case.
    */

    public static void printRepeatingWordsAndTheirFreauencies(String s) {
        String[] splited = s.replaceAll(",", "").toLowerCase().split("\\s+"); // thinks about better splitting using only word such as '[^a-z]', and you will gain extra points
        HashMap <String, Integer> hm = new HashMap<String, Integer>();
        for (String s_key : splited) {
            if ( !s_key.isEmpty() ) { // empty strings in array skept, but you may not use it if you splitting is well done
                hm.put(s_key,hm.getOrDefault(s_key, 1)); // usage of getOrDefault is very important trick that adds you extra point
            }
        }
        hm.forEach((k,v) -> System.out.println(k+": "+v));
    }

    public static void main(String[] args) {
        printRepeatingWordsAndTheirFreauencies("Here is a string of   words  , Words are repeated here");
    }

}
