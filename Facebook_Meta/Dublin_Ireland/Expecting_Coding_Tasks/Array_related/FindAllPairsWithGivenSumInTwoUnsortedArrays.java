import java.util.HashMap;

// CREDITS http://www.geeksforgeeks.org/given-two-unsorted-arrays-find-pairs-whose-sum-x/


public class FindAllPairsWithGivenSumInTwoUnsortedArrays {
	// Function to find all pairs in both arrays
    // whose sum is equal to given value x
    public static void findPairs(int arr1[], int arr2[],
                                 int n, int m, int x)
    {
        // Insert all elements of first array in a hash
        HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
         
        for (int i = 0; i < n; i ++)
            s.put(arr1[i], 0);
      
        // Subtract sum from second array elements one
        // by one and check it's present in array first
        // or not
        for (int j = 0; j < m; j ++)
            if (s.containsKey(x - arr2[j]))
                System.out.println(x - arr2[j] + " " + arr2[j]);
    }
     
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
        int arr1[] = {1, 0, -4, 7, 6, 4};
        int arr2[] = {0 ,2, 4, -3, 2, 1};
        int x = 8;
         
        findPairs(arr1, arr2, arr1.length, arr2.length, x);
      
    }

}
