public class RotateSquaredMatrixInEfficientWay {

    // CREDITS: Prakriti Gupta
    // PROBLEM: Using an in-place function to rotate an N x N (squared) matrix
    // by 90 degrees in anti-clockwise direction

    static void rotateMatrix(int N, int[][] mat) {
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group of 4 in 
            // current square
            for (int y = x; y < N - x - 1; y++) {
                // store current cell in temp variable
                int temp = mat[x][y];

                // move values from right to top
                mat[x][y] = mat[y][N - 1 - x];

                // move values from bottom to right
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

                // move values from left to bottom
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

                // assign temp to left
                mat[N - 1 - y][x] = temp;
            }
        }
    }

    // Function to print the matrix
    static void displayMatrix(int N, int[][] mat) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    // Driver main program to test above function
    public static void main(String[] args) {

        int N = 6;

        // Test Case 1
        int[][] mat = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36},};

        System.out.println("Before");
        displayMatrix(N, mat);
        rotateMatrix(N, mat);
        System.out.println("After");
        // Print rotated matrix
        displayMatrix(N, mat);

        // Test Case 2
        int[][] mat2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        N = 3;
        System.out.println("Before");
        displayMatrix(N, mat2);
        rotateMatrix(N, mat2);
        System.out.println("After");
        displayMatrix(N, mat2);

        // Test Case 3
        N = 2;
        int[][] mat3 = {{1, 2}, {4, 5}};
        System.out.println("Before");
        displayMatrix(N, mat3);
        rotateMatrix(N, mat3);
        System.out.println("After");
        displayMatrix(N, mat3);
    }

}
