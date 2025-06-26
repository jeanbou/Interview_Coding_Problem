
/*
 * Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find sum of these two numbers.

Examples:

Input : num1 = 4154  
        num2 = 51454
Output : 213779916 

Input :  num1 = 654154154151454545415415454  
         num2 = 63516561563156316545145146514654 
Output : 41549622603955309777243716069997997007620439937711509062916
 */


public class MultiLargeNumbersAsStr {

	public static String multiply(String num1, String num2) {
	    String n1 = new StringBuilder(num1).reverse().toString();
	    String n2 = new StringBuilder(num2).reverse().toString();
	 
	    int[] d = new int[num1.length()+num2.length()];
	 
	    //multiply each digit and sum at the corresponding positions
	    for(int i=0; i<n1.length(); i++){
	        for(int j=0; j<n2.length(); j++){
	            d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
	        }
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    //calculate each digit
	    for(int i=0; i<d.length; i++){
	        int mod = d[i]%10;
	        int carry = d[i]/10;
	        if(i+1<d.length){
	            d[i+1] += carry;
	        }
	        sb.insert(0, mod);
	    }
	 
	    //remove front 0's
	    while(sb.charAt(0) == '0' && sb.length()> 1){
	        sb.deleteCharAt(0);
	    }
	 
	    return sb.toString();
	}
	 
	public static void main(String args[])
    {
		String str1 = "1235421415454545454545454544";
	    String str2 = "1714546546546545454544548544544545";
	    System.out.println(multiply(str1, str2));
    }
	
}
