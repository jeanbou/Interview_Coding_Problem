// CREDITS: https://www.programcreek.com/2014/06/leetcode-decode-ways-java/

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

Java Solution

This problem can be solved by using dynamic programming. It is similar to the problem of counting ways of climbing stairs. The relation is dp[n]=dp[n-1]+dp[n-2].
 */

// https://stackoverflow.com/questions/20342462/review-an-answer-decode-ways

// http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/

public class NumDecodings {

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (Integer.parseInt(s.substring(0, 2)) > 26) {
            if (s.charAt(1) != '0') {
                dp[1] = 1;
            } else {
                dp[1] = 0;
            }
        } else {
            if (s.charAt(1) != '0') {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }

            int val = Integer.parseInt(s.substring(i - 1, i + 1));
            if (val <= 26 && val >= 10) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length() - 1];
    }


    public static int numDecodings2(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int decodings = 1;
        boolean used = false; // Signifies that the prev was already use as a decimal
        for (int index = s.length() - 1; index > 0; index--) {
            char curr = s.charAt(index);
            char prev = s.charAt(index - 1);
            if (curr == '0') {
                if (prev != '1' && prev != '2') {
                    return 0;
                }
                index--; // Skip prev because it is part of curr
                used = false;
            } else {
                if (prev == '1' || (prev == '2' && curr <= '6')) {
                    decodings = decodings * 2;
                    if (used) {
                        decodings = decodings - 1;
                    }
                    used = true;
                } else {
                    used = false;
                }
            }
        }
        return decodings;
    }

    public static void main(String[] args) {
        String str1 = "123";
        System.out.println(numDecodings(str1));
        System.out.println(numDecodings2(str1));
    }

}
