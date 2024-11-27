import java.util.Arrays;

public class FindMinimalAbsoluteDifferenceInArray {

	// PROBLEM
	// Find minimal absolute difference in array
	// NOTE: Code can be optimize

	private static int findAbsMinDiffInArray(int[] array) {

		Arrays.sort(array);

		int min_diff = Math.abs(array[0] - array[1]);

		for (int i = 2; i < array.length && min_diff != 0; i++) {
			min_diff = Math.min( Math.abs(array[i-1] - array[i]),min_diff);			
		}

		return min_diff;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int [] array = {1, 4, 25, 23, 5};

		System.out.println("Min Abs Diff : "+findAbsMinDiffInArray(array));
	}

}
