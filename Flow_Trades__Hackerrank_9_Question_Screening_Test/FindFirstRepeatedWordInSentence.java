import java.util.HashMap;

/**
The credits for the give solution
 https://www.geeksforgeeks.org/find-first-repeated-word-string/
**/

public class FindFirstRepeatedWordInSentence {
    // Java  program to find first repeated word in a string
    public static void solve(String s) {
        HashMap<String, Integer> mp = new HashMap<String, Integer>(); // to store
        // occurrences of word
        String t = "";
        String ans = "";
        // traversing from back makes sure that we get the
        // word which repeats first as ans
        for (int i = s.length() - 1; i >= 0; i--) {
            // if char present , then add that in temp word
            // string t
            if (s.charAt(i) != ' ') {
                t += s.charAt(i);
            }
            // if space is there then this word t needs to
            // stored in map
            else {
                if (!mp.containsKey(t)) {
                    mp.put(t, 1);
                } else {
                    mp.put(t, mp.get(t) + 1);
                }

                // if that string t has occurred previously
                // then it is a possible ans
                if (mp.get(t) > 1) {
                    ans = t;
                }
                // set t as empty for again new word
                t = "";
            }
        }

        // first word like "he" needs to be mapped
        if (!mp.containsKey(t)) {
            mp.put(t, 1);
        } else {
            mp.put(t, mp.get(t) + 1);
        }
        if (mp.get(t) > 1) {
            ans = t;
        }

        if (!ans.equals("")) {
            // reverse ans string as it has characters in
            // reverse order
            StringBuilder input1 = new StringBuilder();

            // append a string into StringBuilder input1
            input1.append(ans);

            // reverse StringBuilder input1
            input1.reverse();

            System.out.println(input1);
        } else {
            System.out.print("No Repetition\n");
        }
    }

    /** TEST YOUR HACKER RANK SOLUTION CLASS **/
    public static void main(String[] args) {
        String u = "Ravi had been saying that he had been there";
        String v = "Ravi had been saying that";
        String w = "he had had he";
        solve(u);
        solve(v);
        solve(w);
    }

} // FindFirstRepeatedWordInSentence
