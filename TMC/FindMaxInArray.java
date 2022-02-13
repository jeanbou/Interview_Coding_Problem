package tmc;

import java.util.Arrays;

// CREDITS: https://www.geeksforgeeks.org/java-program-for-program-to-find-largest-element-in-an-array/
public class FindMaxInArray {
    public static int findMax(int[] arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}