

import java.util.Arrays;
import java.util.List;

/*
 *  This task was present during FDLV Luxembourg screening and T.D. based popular testing
 *  Geeks for Geeks has an error https://www.geeksforgeeks.org/find-the-largest-pair-sum-in-an-unsorted-array/
 *  That they are not going to correct it (check out the comments)
 */

public class LargestPairSum {

    public static int findMaxSum(List<Integer> list) {
        int[] arr = list.stream().mapToInt(i->i).toArray();
        int j = arr[0] > arr[1] ? 0 : 1;
        int max = arr[0] + arr[1];
        for (int i = 2; i < arr.length; i++) {
            int sum = arr[j] + arr[i];
            if (sum > max) {
                max = sum;
                if (arr[j] < arr[i]) {
                    j = i;
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 3, 2);
        System.out.println(findMaxSum(list));
    }

}
