public class ComplementaryKPairs {
	
	// http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
	
	    static boolean hasArrayTwoCandidates(int A[], int arr_size, int sum)
	    {
	        int l, r;
	      
	        /* Sort the elements */
	        sort(A, 0, arr_size-1);
	      
	        /* Now look for the two candidates 
	           in the sorted array*/
	        l = 0;
	        r = arr_size-1; 
	        while (l < r)
	        {
	             if(A[l] + A[r] == sum)
	                  return true; 
	             else if(A[l] + A[r] < sum)
	                  l++;
	             else // A[i] + A[j] > sum
	                  r--;
	        }    
	        return false;
	    }
	     
	    //main function
	    public static void main(String args[])
	    {
	        int A[] = {1, 4, 45, 6, 10, -8};
	        int n = 16;
	        int arr_size = 6;
	         
	        if( hasArrayTwoCandidates(A, arr_size, n))
	            System.out.println("Array has two "+ 
	                         "elements with sum 16");
	        else
	            System.out.println("Array doesn't have "+
	                      "two elements with sum 16 ");
	      
	    }
	     
	    /* Below functions are only to sort the 
	       array using QuickSort    */
	        
	    /* This function takes last element as pivot,
	       places the pivot element at its correct
	       position in sorted array, and places all
	       smaller (smaller than pivot) to left of
	       pivot and all greater elements to right
	       of pivot */
	    static int partition(int arr[], int low, int high)
	    {
	        int pivot = arr[high]; 
	        
	        // index of smaller element
	        int i = (low-1); 
	        for (int j=low; j<=high-1; j++)
	        {
	            // If current element is smaller than or
	            // equal to pivot
	            if (arr[j] <= pivot)
	            {
	                i++;
	  
	                // swap arr[i] and arr[j]
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	  
	        // swap arr[i+1] and arr[high] (or pivot)
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	  
	        return i+1;
	    }
	  
	  
	    /* The main function that 
	       implements QuickSort()
	       arr[] --> Array to be sorted,
	       low  --> Starting index,
	       high  --> Ending index */
	    static void sort(int arr[], int low, int high)
	    {
	        if (low < high)
	        {
	            /* pi is partitioning index, arr[pi] is 
	              now at right place */
	            int pi = partition(arr, low, high);
	  
	            // Recursively sort elements before
	            // partition and after partition
	            sort(arr, low, pi-1);
	            sort(arr, pi+1, high);
	        }
	    }
	}
