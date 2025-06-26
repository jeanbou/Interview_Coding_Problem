import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class LargestSubsetFibonacciNumbers {

    // Credits GFG https://www.geeksforgeeks.org/dsa/largest-subset-whose-all-elements-are-fibonacci-numbers/

    // Function to find the largest Fibonacci subset
    static ArrayList<Integer> findFibSubset(int arr[]) {

        // Find maximum element in arr[]
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Generate all Fibonacci numbers till max and store them in a hash set
        int a = 0, b = 1;
        Set<Integer> st = new HashSet<>();
        st.add(a);
        st.add(b);
        while (b < max) {
            int c = a + b;
            a = b;
            b = c;
            st.add(b);
        }

        // Find all numbers in arr[] that are Fibonacci numbers
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : arr) {
            if (st.contains(num)) {
                res.add(num);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 8, 5, 20, 1, 40, 13, 23};
        ArrayList<Integer> res = findFibSubset(arr);

        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
