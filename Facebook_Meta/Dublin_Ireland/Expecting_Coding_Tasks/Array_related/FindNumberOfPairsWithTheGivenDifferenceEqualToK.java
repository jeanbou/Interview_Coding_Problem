import java.util.Arrays;
import java.util.HashMap;

class FindNumberOfPairsWithTheGivenDifferenceEqualToK {

    // Credits: // http://www.geeksforgeeks.org/count-pairs-difference-equal-k/
    // PROBLEM: Find number of pairs with the given difference equal to K

    // The function assumes that the array is sorted
    // Not used in this code
    static int countPair(int[] arr, int n) {
        int size = arr.length;
        int counter = 0;
        // Initialize positions of two elements
        int i = 0, j = 1;

        // Search for a pair
        while (i < size && j < size) {
            if (i != j && arr[j] - arr[i] == n) {
             /*System.out.print("Pair Found: "+
                              "( "+arr[i]+", "+ arr[j]+" )");
             return true;
             */
                counter++;
            } else if (arr[j] - arr[i] < n) j++;
            else i++;
        }

        return counter;
    }

    // Optimized algorithm
    static int countPairsWithDiffKOpt(int[] arr, int k) {
        int count = 0;  // Initialize count

        // Initialize empty hashmap.
        int size = arr.length;
        int max = 2000000;
        HashMap<Integer, Boolean> hashmap = new HashMap<Integer, Boolean>(max);

        for (int i = 0; i < max; i++) {
            hashmap.put(i, (i < size && i == arr[i]));
        }

        // Insert array elements to hashmap
        for (int i = 0; i < size; i++)
            hashmap.put(arr[i], true);

        for (int i = 0; i < size; i++) {
            int x = arr[i];
            if (x - k >= 0 && hashmap.get(x - k)) count++;
            if (x + k < max && hashmap.get(x + k)) count++;
            hashmap.put(x, false);
        }
        return count;
    }

    // Returns count of pairs with difference k in arr[] of size n.
    // General (first try) algorithm
    static int countPairsWithDiffKGen(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);  // Sort array elements quick sort

        int l = 0;
        int r = 0;
        while (r < n) {
            if (arr[r] - arr[l] == k) {
                count++;
                l++;
                r++;
            } else if (arr[r] - arr[l] > k) l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return count;
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] arr = {1, 8, 30, 40, 100};
        int[] arr2 = {1, 5, 3, 4, 2};
        int n = 60;

        System.out.println("Count for arr1, optimized algorithm : " + countPairsWithDiffKOpt(arr, n));
        System.out.println("Count for arr1, general algorithm : " + countPairsWithDiffKGen(arr, n));

        n = 3;
        System.out.println("Count for arr1, optimized algorithm : " + countPairsWithDiffKOpt(arr, n));
        System.out.println("Count for arr1, general algorithm : " + countPairsWithDiffKGen(arr, n));

        n = 60;
        System.out.println("Count for arr2, optimized algorithm : " + countPairsWithDiffKOpt(arr2, n));
        System.out.println("Count for arr2, general algorithm : " + countPairsWithDiffKGen(arr2, n));

        n = 3;
        System.out.println("Count for arr2, optimized algorithm : " + countPairsWithDiffKOpt(arr2, n));
        System.out.println("Count for arr2, general algorithm : " + countPairsWithDiffKGen(arr2, n));
    }
}
