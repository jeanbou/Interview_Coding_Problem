// CREDITS: http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/

// http://www.techiedelight.com/implement-strstr-function-java/

// http://practice.geeksforgeeks.org/problems/implement-strstr/1

public class StrStrInJava {

    public static String strStr2(String haystack, String needle) { // naive
        if (haystack == null || needle == null) return null;
        int hLength = haystack.length();
        int nLength = needle.length();
        if (hLength < nLength) return null;
        if (nLength == 0) return haystack;
        for (int i = 0; i <= hLength - nLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                for (; j < nLength; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == nLength) return haystack.substring(i);
            }
        }
        return null;
    }


    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return 0;

        int h = haystack.length();
        int n = needle.length();

        if (n > h) return -1;
        if (n == 0) return 0;

        int[] next = getNext(needle);
        int i = 0;

        while (i <= h - n) {
            int success = 1;
            for (int j = 0; j < n; j++) {
                if (needle.charAt(0) != haystack.charAt(i)) {
                    success = 0;
                    i++;
                    break;
                } else if (needle.charAt(j) != haystack.charAt(i + j)) {
                    success = 0;
                    i = i + j - next[j - 1];
                    break;
                }
            }
            if (success == 1) return i;
        }

        return -1;
    }

    //calculate KMP array
    public static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;

        for (int i = 1; i < needle.length(); i++) {
            int index = next[i - 1];
            while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
                index = next[index - 1];
            }

            if (needle.charAt(index) == needle.charAt(i)) {
                next[i] = next[i - 1] + 1;
            } else {
                next[i] = 0;
            }
        }

        return next;
    }

    public static void main(String[] args) {
        String haystack = "Techie Delight";
        String needle = "light";
        System.out.println(strStr(haystack, needle));
        System.out.println(strStr2(haystack, needle));

    }

}
