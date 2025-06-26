public class IsNumFibonacciUsingLoopForBigNumApproach2 {

    // Credits https://www.geeksforgeeks.org/dsa/check-number-fibonacci-number/
    // Approach

    public static boolean isPerfectSquare(int n) {
        int root = (int) Math.sqrt(n);
        return (root * root == n);
    }

    public static boolean isFibonacci(int n) {
        if (n == 0) {
            return true;
        }
        int a = 0, b = 1, c = 1;
        while (c < n) {
            a = b;
            b = c;
            c = a + b;
        }
        return (c == n || isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4));
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (isFibonacci(i)) {
                System.out.println(i + " is a Fibonacci number.");
            } else {
                System.out.println(i + " is not a Fibonacci number.");
            }
        }
    }

}
