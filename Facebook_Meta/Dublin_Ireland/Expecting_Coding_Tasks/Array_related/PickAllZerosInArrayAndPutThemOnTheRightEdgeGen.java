public class PickAllZerosInArrayAndPutThemOnTheRightEdgeGen {

    // PROBLEM: Pick all zeros in given array up and push them all on the right edge of array
    // Algorithm is General (first try) not optimized

    static int[] array = {1, 2, 12, 0, 2, 0, 0, 1, 0};

    private static void movedZeros(int[] arr) {

        int nonZeroCount = 0;
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            if (arr[i] != 0) {
                arr[nonZeroCount++] = arr[i];
            }
        }

        while (nonZeroCount < size) {
            arr[nonZeroCount++] = 0;
        }
    }

    static void printArray(int[] arr) {
        for (int elm : arr) {
            System.out.print(elm + " ");
        }
        System.out.println();
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        System.out.println("Before");
        printArray(array);

        movedZeros(array);

        System.out.println("After");
        printArray(array);
    }

}
