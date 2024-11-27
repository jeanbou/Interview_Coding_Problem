public class FindNumberOfPairsWithTheGivenDifferenceEqualToKInSortedArray {

    // Credits: Devesh Agrawal
    // PROBLEM: Find number of pairs with the given difference equal to K _IN THE SORTED ARRAY_

    static boolean findPair(int[] arr, int n) {

        int size = arr.length;

        // Initialize positions of two elements
        int i = 0, j = 1;

        // Search for a pair
        while (i < size && j < size) {
            if (i != j && arr[j] - arr[i] == n) {
                System.out.print("Pair Found: " + "( " + arr[i] + ", " + arr[j] + " )");
                return true;
            } else if (arr[j] - arr[i] < n) j++;
            else i++;
        }

        System.out.print("No such pair");
        return false;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] arr = {1, 8, 30, 40, 100};
        int n = 60;
        findPair(arr, n);
    }

}
