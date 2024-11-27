import java.util.Arrays;

public class FindIsThereSumOfTwoElementsInArrayEqualToGivenValueX {

    // PROBLEM
    // Find if exists the sum of two elements in Array equals to the given value X

    static boolean isFoundSumEqX(int[] arr, int X) {

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;//length of Array B.
        while (i < j) {
            if (arr[i] + arr[j] == X) {
                return true;
            } else if (arr[i] + arr[j] > X) {
                j--;
            } else if (arr[i] + arr[j] < X) {
                i++;
            }
        }

        return false;
    }

    // Driver main program to test above function
    public static void main(String[] args) {
        int[] B = {1, 3, 4, 4, 5, 8};
        // Test case 1 - 2
        int X = 2;
        System.out.println("TEST 1 : " + isFoundSumEqX(B, X));
        // Test case 2 - 8
        X = 8;
        System.out.println("TEST 2 : " + isFoundSumEqX(B, X));
    }

}
