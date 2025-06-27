import java.util.ArrayList;
import java.util.List;

public class BinaryRepresentation_inCPP {

	/*
	Method 1: Iterative
	For any number, we can check whether its ‘i’th bit is 0(OFF) or 1(ON) by bitwise ANDing it with “2^i” (2 raise to i).

	1) Let us take number 'NUM' and we want to check whether it's 0th bit is ON or OFF	
		bit = 2 ^ 0 (0th bit)
		if  NUM & bit == 1 means 0th bit is ON else 0th bit is OFF

	2) Similarly if we want to check whether 5th bit is ON or OFF	
		bit = 2 ^ 5 (5th bit)
		if NUM & bit == 1 means its 5th bit is ON else 5th bit is OFF.
	Let us take unsigned integer (32 bit), which consist of 0-31 bits. To print binary representation of unsigned integer, start from 31th bit, check whether 31th bit is ON or OFF, if it is ON print “1” else print “0”. Now check whether 30th bit is ON or OFF, if it is ON print “1” else print “0”, do this for all bits from 31 to 0, finally we will get binary representation of number.

	void bin(unsigned n)
	{
	    unsigned i;
	    for (i = 1 << 31; i > 0; i = i / 2)
	        (n & i)? printf("1"): printf("0");
	}
	 
	int main(void)
	{
	    bin(7);
	    printf("\n");
	    bin(4);
	}
	Run on IDE


	Method 2: Recursive
	Following is recursive method to print binary representation of ‘NUM’.

	step 1) if NUM > 1
		a) push NUM on stack
		b) recursively call function with 'NUM / 2'
	step 2)
		a) pop NUM from stack, divide it by 2 and print it's remainder.
	void bin(unsigned n)
	{
	    // step 1
	    if (n > 1)
	        bin(n/2);
	 
	    // step 2
	    printf("%d", n % 2);
	}
	 
	int main(void)
	{
	    bin(7);
	    printf("\n");
	    bin(4);
	}
	*/
	
	
	public int solutionOLD(int n) {
        // write your code in Java SE 8
        String binaryRep = Integer.toBinaryString(n);
        System.out.println("Binary Representation of " + n + " = " + binaryRep);
        List<String> strList = new ArrayList<String>();
        int count = 0;
        for (int i = 0; i < binaryRep.length(); i++) { // Loop through the each number 
            String str = binaryRep.charAt(i) + ""; // getting one by one number
            if(str.equals("0")){
                for(int j = i;j<binaryRep.length();j++){ //Get each next element
                    String str1 = binaryRep.charAt(j) + "";
                    if(!str.equals("1") &&  str.equals(str1)){
                        if(!strList.isEmpty() && count >= strList.size()){
                            strList.add(str1);
                        }else if(strList.isEmpty()){
                            strList.add(str1);
                        }
                        count ++; 
                    }else{
                        count = 0;
                        break;
                    }
                }
           }   
        }
        return strList.size();
    }
	

	public static int solution(int num) {
	    int ptr; //Used for bitwise operation.
	    for(ptr=1; ptr>0; ptr<<=1) //Find the lowest bit 1
	        if((num&ptr) != 0)
	            break;
	    int cnt=0; //Count the (possible) gap
	    int ret=0; //Keep the longest gap.
	    for(; ptr>0; ptr<<=1) {
	        if((num&ptr) != 0) { //If it's bit 1
	            ret = cnt < ret ? ret : cnt; //Get the bigger one between cnt and ret
	            cnt=-1; //Exclude this bit
	        }
	        cnt++; //Increment the count. If this bit is 1, then cnt would become 0 beause we set the cnt as -1 instead of 0.
	    }
	    return ret;
	}
	
	// Solution For String
	private static int solutionString(int intValue) {
	    String binaryString = Integer.toBinaryString(intValue);
	    int zeroHit = 0;
	    int longest = 0;
	    for (int i = 0; i < binaryString.length(); i++) {
	        if(binaryString.substring(i, i+1).equals("1")) {
	            if (zeroHit > longest) { longest = zeroHit; }
	            zeroHit = 0;
	        }
	        else { zeroHit++; }
	    }
	    return longest;
	}
	
	public int solution2(int N) {
	    int binaryGap = 0;
	    String binaryString = Integer.toBinaryString(N);
	    char[] characters = binaryString.toCharArray();
	    int j = 0;
	    Character c;
	    for (int i = 0; i < characters.length; i++) {
	         c = characters[i];
	        if (c.equals('0')) {
	            j += 1;
	        }

	        if (c.equals('1')) {
	            if (j > binaryGap ){
	                binaryGap = j;
	            }
	            j = 0;
	        }

	    }
	    //System.out.println(binaryGap);
	    return binaryGap;

	}
	
	// https://stackoverflow.com/questions/35531747/solving-binary-gap-using-recursion
	static int solutionRec(int n, int max, int current) {
	    if (n == 0)
	        return max;
	    else if (n % 2 == 0)
	        return solutionRec(n / 2, max, current + 1);
	    else
	        return solutionRec(n / 2, Math.max(max, current), 0);
	}
	
	static int solutionLoop(int n) {
	    int current = 0;
	    int max = 0;
	    while (n > 0) {
	        if (n % 2 == 0)
	            ++current;
	        else {
	            max = Math.max(max, current);
	            current = 0;
	        }
	        n /= 2;
	    }
	    return max;
	}
	
	// Longest sequences of zeroes
	// https://codereview.stackexchange.com/questions/122410/printing-longest-sequence-of-zeroes
	// and another link : https://codereview.stackexchange.com/questions/155516/biggest-binary-gap-solution
	
	// O(log(N)
	/*
	private int biggestBinaryGap(int n) {
	    while (endsWithZero(n))
	        n >>= 1;
	    return biggestBinaryGapRec(n >> 1);
	}

	private int biggestBinaryGapRec(int n) {
	    if (n == 0)
	        return 0;

	    int gap = 0;
	    for (; endsWithZero(n); n >>= 1, gap++);
	    return Math.max(gap, biggestBinaryGapRec(n >> 1));

	}

	private boolean endsWithZero(int n) {
	    return n > 0 && (n & 1) == 0;
	}
	*/
	
}
