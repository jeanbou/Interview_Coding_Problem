public class FindThePresenceOfAnElementAtRotatedArrayShortVersion {

    // PROBLEM
    // Find a presence of element in the sorted rotated (circular) array
    // Approach : Binary search applied, but written in more laconic way and applied for sorted array

    private static int findElementInRotArr(int[] arr, int l, int r, int key) {

        if (l > r) return -1;

        int mid = (l + r) / 2;
        if (arr[mid] == key) return mid;

        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid]) {
	            /* As this subarray is sorted, we
	               can quickly check if key lies in
	               half or other half */
            if (key >= arr[l] && key <= arr[mid]) return findElementInRotArr(arr, l, mid - 1, key);

            return findElementInRotArr(arr, mid + 1, r, key);
        }
	            	/* If arr[l..mid] is not sorted,
	           	then arr[mid... r] must be sorted*/
        if (key >= arr[mid] && key <= arr[r]) return findElementInRotArr(arr, mid + 1, r, key);

        return findElementInRotArr(arr, l, mid - 1, key);
    }

    // Driver main program to test above function
    public static void main(String[] args) {

        int[] array = {4, 5, 7, 9, 1, 2, 3}; // let's search for 2 & 3
        int[] array2 = {1, 5, 7, 9}; // let's search for 8 & 9

        // TEST CASE 1
        int elm = 2;
        int index = findElementInRotArr(array, 0, array.length - 1, elm);
        if (index < 0) {
            System.out.println("No element " + elm + " in array");
        } else {
            System.out.println("Element " + elm + " assigned to index " + index);
        }

        // TEST CASE 2
        elm = 3;
        index = findElementInRotArr(array, 0, array.length - 1, elm);
        if (index < 0) {
            System.out.println("No element " + elm + " in array");
        } else {
            System.out.println("Element " + elm + " assigned to index " + index);
        }

        // TEST CASE 3
        elm = 8;
        index = findElementInRotArr(array2, 0, array2.length - 1, elm);
        if (index < 0) {
            System.out.println("No element " + elm + " in array2");
        } else {
            System.out.println("Element " + elm + " assigned to index " + index + " at array2");
        }

        // TEST CASE 2
        elm = 9;
		index = findElementInRotArr(array2, 0, array2.length - 1, elm);
        if (index < 0) {
            System.out.println("No element " + elm + " in array2");
        } else {
            System.out.println("Element " + elm + " assigned to index " + index + " at array2");
        }

    }

}
