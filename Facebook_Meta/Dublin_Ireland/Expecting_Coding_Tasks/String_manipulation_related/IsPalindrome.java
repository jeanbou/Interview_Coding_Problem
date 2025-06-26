import java.util.Scanner;

public class IsPalindrome {

	public static String palindromeChecker(String a) 
	 {
		 String b = a.toLowerCase().replaceAll("[^a-z]","");
		 String reverse = new StringBuilder(b).reverse().toString();
	     String c; 
	     if(b.equals(reverse)) { 
	         c = "The word " +b+ "  is a palindrome"; }
	     else {
	         c = "The word " +b+ "  is not a palindrome"; }
	     return c;

	 }
	 
	public static boolean isPalindrome2(String s) {
	    for (int i = 0; i < s.length() / 2; i++) {
	      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
	        return false;
	      }
	    }

	    return true;
	  }

	public static void main(String[] args) 
	{
	     Scanner sentence = new Scanner(System.in);
	     System.out.println("This program will determine if an inputted phrase is a palindrome.");
	     System.out.println(" ");
	     System.out.println("Enter a phrase, word, or sentence:");
	     String a = sentence.nextLine();
	     //String b = a.toLowerCase().replaceAll("[^a-z]"," "); //as long as the words are spelt the same way, the caps don't matter and it ignores spaces and punctuation
	     System.out.println();
	     System.out.println(palindromeChecker(a)); //calls method

	 }

}
