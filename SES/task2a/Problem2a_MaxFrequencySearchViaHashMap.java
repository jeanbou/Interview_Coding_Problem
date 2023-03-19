package ses;
import java.io.IOException;
import java.util.HashMap;

public class Problem2a_MaxFrequencySearchViaHashMap {
    static HashMap <String, Integer> hm = new HashMap<String, Integer>();  
    // The idea is to use a classical solution of frequency counting inside unsorted array by the mean of hash map
    static String maxFrequencyOfFirst(String[] arr) {
    	int array_len = arr.length;
    	// Protective part of code
        if (array_len < 1 ) {
				throw new IllegalArgumentException("Arguments Exception : Input : array_len = "+Integer.toString(array_len)+" !\nOut of expected range");
		}
    	// First two trivial cases
        if (array_len < 3  ) {
        	return arr[0];
        }
        
        // General case array_len >= 3
        int maxFirstFreq = 0;
        int emptyStringFreq = 0;
        String firstFreqStr = "";
        for (String s_key : arr) {
            if ( !s_key.isEmpty() ) { // empty strings in array skept, but counted
            	if ( hm.containsKey(s_key) ) {
            		int newIncrFreq = hm.get(s_key)+1;
            		maxFirstFreq = Math.max(newIncrFreq,maxFirstFreq);
            		firstFreqStr = s_key;
            		hm.put(s_key,newIncrFreq);
            	}
            	else {
            		hm.put(s_key,1);
            	}
            }
            else {
            	emptyStringFreq++;
        	} 
        }        
        if (emptyStringFreq > maxFirstFreq) {
        	return "<Empty String>";
        }        
        return firstFreqStr;

    } // maxFrequencyOfFirst

	public static void main(String[] args) throws IOException {
    	
    	// For quick testing via comment/decomment.
    	//String [] TESTCASE = {"a","bb","a","cc"}; // Expected output 2 (the given example)
    	
    	// For detailed testing, my test-case scenarii
    	//String [] TESTCASE = {"a"};
    	//String [] TESTCASE = {"b","cc"};
    	//String [] TESTCASE = {"cc","cc"};
    	//String [] TESTCASE = {"bb","","bb","","a","a","","c","bb"};
    	String [] TESTCASE = {"bb","","bb","","a","a","","","bb","","",""};
    	//String [] TESTCASE = {}; // arg.exception with my message
    	
    	System.out.println("Result : "+maxFrequencyOfFirst(TESTCASE));
            
    } // the end of main
    
} // the end of class