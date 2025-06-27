public class FindXOR_between1_N_and_Between__M_N {

	// Java program to find XOR of numbers
	// from 1 to n.
	 
	    // Method to calculate xor
	    static int computeXOR(int n)
	    {
	        // If n is a multiple of 4
	        if (n % 4 == 0)
	            return n;
	      
	        // If n%4 gives remainder 1
	        if (n % 4 == 1)
	            return 1;
	      
	        // If n%4 gives remainder 2
	        if (n % 4 == 2)
	            return n + 1;
	      
	        // If n%4 gives remainder 3
	        return 0;
	    }
	     
	    // Driver method
	    public static void main (String[] args)
	    {
	         int n = 5;
	         System.out.println(computeXOR(n));
	    }
	    
	    
	    public int findXORofRange(int m, int n) {
	        int[] patternTracker;

	        if(m % 2 == 0)
	            patternTracker = new int[] {n, 1, n^1, 0};
	        else
	            patternTracker = new int[] {m, m^n, m-1, (m-1)^n};

	        return patternTracker[(n-m) % 4];
	    }
	    
	}
