import java.util.Arrays;

// CREDITS http://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/

/*
 * Find all triplets with zero sum
Given an array of distinct elements. The task is to find triplets in array whose sum is zero.

Examples:

Input : arr[] = {0, -1, 2, -3, 1}
Output : 0 -1 1
         2 -3 1

Input : arr[] = {1, -2, 1, 0, 5}
Output : 1 -2  1

 */



/* Solution 2 O(n2)
 * Method 2 (Hashing : O(n2))
We iterate through every element. For every element arr[i], we find a pair with sum “-arr[i]”. This problem reduces to pairs sum and can be solved in O(n) time using hashing.

Run a loop from i=0 to n-2
  Create an empty hash table
  Run inner loop from j=i+1 to n-1
      If -(arr[i] + arr[j]) is present in hash table
         print arr[i], arr[j] and -(arr[i]+arr[j])
      Else
         Insert arr[j] in hash table.
// C++ program to find triplets in a given
// array whose sum is zero
#include<bits/stdc++.h>
using namespace std;
 
// function to print triplets with 0 sum
void findTriplets(int arr[], int n)
{
    bool found = false;
 
    for (int i=0; i<n-1; i++)
    {
        // Find all pairs with sum equals to
        // "-arr[i]"
        unordered_set<int> s;
        for (int j=i+1; j<n; j++)
        {
            int x = -(arr[i] + arr[j]);
            if (s.find(x) != s.end())
            {
                printf("%d %d %d\n", x, arr[i], arr[j]);
                found = true;
            }
            else
                s.insert(arr[j]);
        }
    }
 
    if (found == false)
        cout << " No Triplet Found" << endl;
}
 
// Driver code
int main()
{
    int arr[] = {0, -1, 2, -3, 1};
    int n = sizeof(arr)/sizeof(arr[0]);
    findTriplets(arr, n);
    return 0;
}
 * 
 */

public class FindAllTripletsWithZeroSum {
	
	// function to print triplets with 0 sum
	static void findTriplets(int arr[])
	{
	    boolean found = false;
	    int n = arr.length;
	 
	    // sort array elements
	    Arrays.sort(arr);
	 
	    for (int i=0; i<n-1; i++)
	    {
	        // initialize left and right
	        int l = i + 1;
	        int r = n - 1;
	        int x = arr[i];
	        while (l < r)
	        {
	            if (x + arr[l] + arr[r] == 0)
	            {
	                // print elements if it's sum is zero
	                System.out.println(" : " + x + arr[l] + arr[r]);
	                l++;
	                r--;
	                found = true;
	            }
	 
	            // If sum of three elements is less
	            // than zero then increment in left
	            else if (x + arr[l] + arr[r] < 0)
	                l++;
	 
	            // if sum is greater than zero than
	            // decrement in right side
	            else
	                r--;
	        }
	    }
	 
	    if (found == false)
	    	 System.out.println(" No Triplet Found " );
	}
	 
	// Driven source
	 public static void main(String[] args)
	{
	    int arr[] = {0, -1, 2, -3, 1};
	    findTriplets(arr);

	}

}
