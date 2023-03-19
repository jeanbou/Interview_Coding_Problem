package talkwalk;

public class Problem02_MaxSubarray_Interview3_TechnicalInteview2_preparation {

    // Find max sub-array sum in an array of Integers i.e [1,2,5,-5,-7,1,0,-2]
    // max sub-array sum is: 8 , sub-array [1,2,5]

    /* ANOTHER DESCRIPTION OF THE SAME PROBLEM BY ANOTHER GUY
    The all-time interview question champion "Maximum Contiguous SubArray Sum" 
    (don't give him the optimal solution for a question that's given in every interview, 
    otherwise he will get upset lol)
    
    [- 10, 1, 2, 5, 1, -1, 7, -1, -2, -2, -2, -2, -2]
    
    CREDITS: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    */
    public static void printMaxSubArrayAntItsSum(int a[]) {
        int global_sub_arr_max = 0;
        int curr_max_val = 0;
        int start = 0;
        int end = 0;
        int prev_start = 0;
  
        for (int i = 0; i < a.length; i++) {
            curr_max_val += a[i];
            if (global_sub_arr_max < curr_max_val ) {
                global_sub_arr_max = curr_max_val;
                start = prev_start;
                end = i;
            }
            if (curr_max_val < 0) {
                curr_max_val = 0;
                prev_start = i + 1;
            }
        }

        System.out.println("Maximum contiguous sum is " + global_sub_arr_max);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

    // During the interview it is requested to code this algorithm without the sub-array itself
    public static void printMaxSubArraySum(int array[]) {
        int global_sub_arr_max = 0;
        int curr_max_val = 0;
        for (int a : array) {
            curr_max_val += a;
            global_sub_arr_max = Math.max(global_sub_arr_max,curr_max_val);
            if (curr_max_val < 0) {
                curr_max_val = 0;
            }
        }
        System.out.println("Maximum contiguous sum of subarray is " + global_sub_arr_max);
    }

    // During the interview it is requested to code inefficient algorithm too
    // No idea why: do what French boss ask to do kind a "test"
    public static void inefficientPrintMaxSubArraySum(int array[]) {
        int n = array.length;
        int global_sub_arr_max = 0;
        for (int i = 0; i < n; i++) {
            int curr_max_val = 0;
            for (int j = i; j < n; j++) {
                curr_max_val += array[j];
                global_sub_arr_max = Math.max(global_sub_arr_max,curr_max_val);
            }
        }
        System.out.println("Inefficient maximum sum of subarray is " + global_sub_arr_max);
    }

    public static void main(String[] args) {
        int[] arr = {-10, 1, 2, 5, 1, -1, 7, -1, -2, -2, -2, -2, -2};
        //int[] arr = {-10, 1, -2, 7, -1, -2, -2, -2, -2, -2};
        //int[] arr = { 1, 2, 5, -5, -7, 1, 0, -2};
        printMaxSubArrayAntItsSum(arr);
        printMaxSubArraySum(arr);
        inefficientPrintMaxSubArraySum(arr);
    }

}
