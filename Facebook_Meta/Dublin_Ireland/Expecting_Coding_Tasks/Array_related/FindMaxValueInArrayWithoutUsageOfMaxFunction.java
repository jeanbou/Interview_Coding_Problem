public class FindMaxValueInArrayWithoutUsageOfMaxFunction {

	// PROBLEM
	// Find a max value in array without usage of max function

	private static int findMaxWOMaxFunUsage(int[] array) {

		int max_val = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] > max_val) {
				max_val = array[i];
			}
		}

		return max_val;
	}

	// Driver main program to test above function
	public static void main(String[] args) {
		int[] array = {1, 5 - 3, 12, 45, 2, 2, 7, -56};

		System.out.println("Max Array Value is : " + findMaxWOMaxFunUsage(array));

	}

}
