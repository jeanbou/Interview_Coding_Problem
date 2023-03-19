package talkwalk;

public class Problem04_SubPalindrome_Interview3_TechnicalInteview2_preparation {
    
    // find longest substring palindrome of given string i.e. "ababaza"
    // answer: "ababa"
    
    // Credits: https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
    private static String findLongestPalindromicSubstring(String input) {
        if(input.isEmpty()) {
          return "";
        }
        int n = input.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrom = new boolean[n][n];
      
        for(int j = 0; j < n; j++) {
          palindrom[j][j] = true;
          for(int i = 0; i < j; i++) {
            if(input.charAt(i) == input.charAt(j) && (j-i <= 2 || palindrom[i+1][j-1])) {
              palindrom[i][j] = true;
              if(j-i+1 > longestSoFar) {
                longestSoFar = j-i+1;
                startIndex = i;
                endIndex = j;
              }  
            }
          }
        }
        return input.substring(startIndex, endIndex+1);
    }

    public static void main(String[] args) {
        String input = "ababaza";
        System.out.println(findLongestPalindromicSubstring(input));
    }

}
