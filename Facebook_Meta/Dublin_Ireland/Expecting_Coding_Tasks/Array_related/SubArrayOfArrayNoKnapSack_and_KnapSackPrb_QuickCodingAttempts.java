public class SubArrayOfArrayNoKnapSack_and_KnapSackPrb_QuickCodingAttempts {
/*
	//static int[] values = new int[] {894, 260, 392, 281, 27};
	//static int[] weights = new int[] {8, 6, 4, 0, 21};
	static int W = 30;
	
	static int[] values = {1, 1, 1, 1, 1, 1, 1, 1};
	static int[] weights = new int[] {15, 2, 4, 8, 9, 5, 10, 23};

	private static int knapsack(int i, int W) {
	    if (i < 0) {
	        return 0;
	    }
	    if (weights[i] > W) {
	        return knapsack(i-1, W);
	    } else {
	        return Math.max(knapsack(i-1, W), knapsack(i-1, W - weights[i]) + values[i]);
	    }
	}


	public static void main(String[] args) {
		//System.out.println(knapsack(values.length - 1, W));
		System.out.println(knapsack(values.length - 1, 33));
	}


}*/


    public static void main(String[] args) {
        SubArrayOfArrayNoKnapSack_and_KnapSackPrb_QuickCodingAttempts arraysum = new SubArrayOfArrayNoKnapSack_and_KnapSackPrb_QuickCodingAttempts();
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 42;
        arraysum.subArraySum(arr, n, sum);
    }

    /* Returns true if the there is a subarray of arr[] with sum equal to
    'sum' otherwise returns false. Also, prints the result */
    int subArraySum(int[] arr, int n, int sum) {
        int curr_sum, i, j;

        // Pick a starting point
        for (i = 0; i < n; i++) {
            curr_sum = arr[i];

            // try all subarrays starting with 'i'
            for (j = i + 1; j <= n; j++) {
                if (curr_sum == sum) {
                    int p = j - 1;
                    System.out.println("Sum found between indexes " + i + " and " + p);
                    return 1;
                }
                if (curr_sum > sum || j == n) break;
                curr_sum = curr_sum + arr[j];
            }
        }

        System.out.println("No subarray found");
        return 0;
    }
}


/*

// Returns true if the there is a subarray of arr[] with sum equal to
// 'sum' otherwise returns false.  Also, prints the result
    int subArraySum(int arr[], int n, int sum) 
    {
        int curr_sum = arr[0], start = 0, i;
 
        // Pick a starting point
        for (i = 1; i <= n; i++) 
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i-1)
            {
                curr_sum = curr_sum - arr[start];
                start++;
            }
             
            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) 
            {
                int p = i-1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                return 1;
            }
             
            // Add this element to curr_sum
            if (i < n)
            curr_sum = curr_sum + arr[i];
             
        }
 
        System.out.println("No subarray found");
        return 0;
    }
 
    public static void main(String[] args) 
    {
        SubarraySum arraysum = new SubarraySum();
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 42;
        arraysum.subArraySum(arr, n, sum);
    }

 */
