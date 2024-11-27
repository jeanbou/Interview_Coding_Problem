public class FindThePresenceOfAnElementAtRotatedArray {

	// PROBLEM
	// Find a presence of element in the sorted rotated (circular) array
	// Approach : Binary search applied for sorted array

	private static int binSearchInSortRotArr(int[] arr, int lind, int rind, int elm) {

		if (lind > rind) { // KO criterion of exit
			return -1;
		}

		int midind = (lind + rind) / 2; // Take middle index

		if (arr[midind] == elm) {
			return midind;
		}

		// Classic bin search condition in the sorted left part of array
		if (arr[lind] <= arr[midind]) {
			// Classic bin search
			if (elm <= arr[midind] && elm >= arr[lind]) {
				return binSearchInSortRotArr(arr, lind, midind - 1, elm);
			}

			return binSearchInSortRotArr(arr, midind + 1, rind, elm);
		}

		// bin search in the tail
		// Classic bin search
		if (elm <= arr[rind] && elm >= arr[midind]) {
			return binSearchInSortRotArr(arr, midind + 1, rind, elm);
		}

		return binSearchInSortRotArr(arr, lind, midind - 1, elm);
	}

	// Driver main program to test above function
	public static void main(String[] args) {

		int[] arr = {2, 7, 10, 13, 1, 5, 8, 9}; // rot array

		int elm = 10;
		int elm2 = 11;

		// TEST CASE 1
		int foundIndex = binSearchInSortRotArr(arr, 0, arr.length - 1, elm);

		if (foundIndex < 0) {
			System.out.println("No element " + elm + " found");
		} else {
			System.out.println("Element " + elm + " found. Index : " + foundIndex + " array[" + foundIndex + "]=" + arr[foundIndex]);
		}

		// TEST CASE 2
		foundIndex = binSearchInSortRotArr(arr, 0, arr.length - 1, elm2);

		if (foundIndex < 0) {
			System.out.println("No element " + elm2 + " found");
		} else {
			System.out.println("Element " + elm2 + " found. Index : " + foundIndex + " array[" + foundIndex + "]=" + arr[foundIndex]);
		}

	}

}
