package talkwalk;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.*;

public class Problem00_Interview2_TechnicalInteview1_done {

    /*
     * An array of consecutive numbers is chosen and one number is replaced with 0 in random. 
     * Then the array is jumbled, so it does not preserve the order of numbers. 
     * Now the problem is to find the replaced number. I was asked to give multiple solutions with its corresponding time and space complexity. The different ways to proceed with the questions like a mathematical solution, algorithmic solution and so on
     [1, 5, 3, 4, 2, 6]
     after jumping
     [1, 5, 0, 4, 2, 0]
     Expected output 3 and 6
     */

    public static Set<Integer> findReplaceNumbers(int[] myArray) {
        Set<Integer> setArray = new HashSet<>(Arrays.stream(myArray).boxed().collect(Collectors.toSet()));
        Set<Integer> setResult = new HashSet<Integer>();
        if (myArray.length > 0) { 
            for (int arithm_progression = 1; arithm_progression < myArray.length+1; arithm_progression++ ) {
                if ( !setArray.contains(arithm_progression) ) {
                    setResult.add(arithm_progression);
                }
            }
        }
        
        return setResult;
    }
    
    public static void main(String[] args) {
        // TEST QUICK WAY COMMENT DECOMMENT
        //int[] arr = {1, 5, 3, 4, 2, 6};
        int[] arr = {1, 5, 0, 4, 2, 0};
        Set<Integer> output = findReplaceNumbers(arr);
        if (output.size() < 1) {
            System.out.println("No Such Sequences");
        }
        else {
            System.out.println("Jumped numbers are : "+ output.toString());
        }
    }

}
