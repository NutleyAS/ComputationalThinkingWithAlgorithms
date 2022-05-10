package ie.gmit.dip; //Ref 05

import java.util.Arrays;
import java.util.Random;

public class GnomeSort {

	public static void main(String[] args) {

		Random n = new Random(); // Random to generate a stream of pseudorandom numbers Ref 01

		int[] arr = new int[100]; // int[x] determines the size of the array

		System.out.print("Unsorted Array:");

		for (int i = 0; i < arr.length; i++) {
			int RandomN = n.nextInt(1000) + 1; // nextInt(X) Where (X) determines the largest possible value in the
												// array.
			System.out.print(RandomN + " ");
			arr[i] = RandomN;

		}

		System.out.println("\nSorted Array:" + (Arrays.toString(gnomeSort(arr)))); // Outputs the sorted array

	}

	public static int[] gnomeSort(int[] arr) {
		int pos = 1;
		long startTime = System.nanoTime(); // log the start time (in nanoseconds)
		while (pos < arr.length) {
			if (arr[pos] >= arr[pos - 1]) {
				pos++;
			} else {
				changeKeys(arr, pos, pos - 1);
				if (pos > 1)
					pos--;
			}
		}
		long endTime = System.nanoTime(); // log the end time (in nanseconds) Ref 01
		long elapsed = endTime - startTime; // calculate the run time (in nanoseconds)
		double timeMillis = elapsed / 1000000.0; // convert from nanoseconds to miliseconds
		System.out.print("\nSorthing Time: " + timeMillis + "  ms");
		return arr;
	}

	public static void changeKeys(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}