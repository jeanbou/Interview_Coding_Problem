package aubay_codingame;

/* Adapted solution taken from https://stackoverflow.com/questions/59187020/find-join-point-of-two-sequences
 * You can use it for python https://stackoverflow.com/questions/65977515/how-find-the-join-point-of-two-sequences-in-python
 * REMARKS:
 * 1. In real Codingame test you have 30 minutes to code and submit
 * 2. The recursive solution may face stack overflow issue
 * 3. You can optimize you code because in given example Codingame set upper limit 2000000 or something like that
 * 
 */
public class ComputeJoinedNumber {
    
    public static int getDigitsSum(int x) {
        int sum = 0;
        while (x != 0)
        {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
    
    public static int computeJoinNumber(int seq1, int seq2) {
        while (seq1 != seq2)
        {
            if (seq1 < seq2)
            {
                if (seq1 == 0)
                    return -1; // no chance to join, seq1 is 0

                seq1 += getDigitsSum(seq1);
            }
            else if (seq2 < seq1)
            {
                if (seq2 == 0)
                    return -2; // no chance to join, seq2 is 0

                seq2 += getDigitsSum(seq2);
            }
        }

        return seq1;
    }
    
    public static void main(String[] args) {
        // Debug
        //System.out.println(getDigitsSum(1256));
        // Main call
        System.out.println(computeJoinNumber(471,480));
    }
}
