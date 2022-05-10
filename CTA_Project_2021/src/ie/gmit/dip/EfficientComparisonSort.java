package ie.gmit.dip;

import java.util.Random;

public class EfficientComparisonSort { //Merge Sort Ref 04

	public static void main(String[] args) {

		Random n = new Random(); // Random to generate a stream pseudorandom numbers Ref 01
		int[] arr = new int[100]; // int[x] determines the size of the array

		System.out.print("Unsorted Array: \n");
		
		for (int d = 0; d < arr.length; d++) {
			int RandomN = n.nextInt(1000) + 1; //nextInt(X) Where (X) determines the largest possible value in the array.
			arr[d] = RandomN;
			System.out.print(RandomN + " ");
		}

		long startTime = System.nanoTime(); // Start timer for benchmark
		EfficientComparisonSort ms = new EfficientComparisonSort();
		ms.sort(arr, 0, arr.length - 1);

		System.out.println("\n" + "\nSorted Array:");
		sortedArray(arr); // calls on sortedArray() function

		// Benchmarking a single run Ref 01
		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		double timeMillis = elapsed / 1000000.0;
		System.out.print("\nSorting Time: " + timeMillis + "ms");
	}

	void merge(int array[], int low, int mid, int high) { // Merges two subarrays of array[]

		// Find sizes of two subarrays to be merged
		int f1 = mid - low + 1;
		int f2 = high - mid;

		// Creating temporary subarrays
		int leftArray[] = new int[f1];
		int rightArray[] = new int[f2];

		// Copy data into temporaries
		for (int i = 0; i < f1; i++)
			leftArray[i] = array[low + i];
		for (int j = 0; j < f2; j++)
			rightArray[j] = array[mid + 1 + j];

		// Merge the temporary arrays

		// Iterators containing current index of temporary subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray
		int k = low;
		while (i < f1 && j < f2) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// Copies the remaining elements of leftArray[] if there is any
		while (i < f1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		// Copies the remaining elements of rightArray[] if there is any
		while (j < f2) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

	// Main function that sorts the array low to high using the merge() function
	void sort(int number[], int low, int high) {
		if (low < high) {
			int m = (low + high) / 2; // Finds the middle point
			sort(number, low, m); // Sort first and then half
			sort(number, m + 1, high);
			merge(number, low, m, high); // Merge sorted halves
		}
	}

	// A utility function that is called on to print array of size n
	static void sortedArray(int number[]) {
		int n = number.length;
		for (int i = 0; i < n; ++i)
		System.out.print(number[i] + " ");
		System.out.println();
	}

}
