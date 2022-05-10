package ie.gmit.dip;

import java.util.Arrays;
import java.util.Random;

public class NonComparisonSort { //Counting Sort Ref 06

	public static void main(String[] args) {

		Random n = new Random(); // Random to generate a stream of pseudorandom numbers Ref 01

		int[] input = new int[100]; // int[x] determines the size of the array

		System.out.print("Unsorted Array:");
		for (int i = 0; i < input.length; i++) {
			int RandomN = n.nextInt(input.length) + 1; // nextInt() range must match key k use number.length inside???????????????????????????
			input[i] = RandomN;
			System.out.print(" " + RandomN);
		}
		int j = input.length;

		long startTime = System.nanoTime();

		// sorting array using Counting Sort Algorithm
		countingSort(input, j);
		System.out.println("\n" + "\nSorted Array: " + Arrays.toString(input));

		long endTime = System.nanoTime(); // Benchmarking a single run Ref 01
		long elapsed = endTime - startTime;
		double timeMillis = elapsed / 1000000.0;
		System.out.print("\nSorted In: " + timeMillis + "  ms");

	}

	public static void countingSort(int[] input, int k) {
		int counter[] = new int[k + 1]; // create buckets
		// fill buckets
		for (int i : input) {
			counter[i]++;
		}

		// sort array
		int sorted = 0;
		for (int i = 0; i < counter.length; i++) {
			while (0 < counter[i]) {
				input[sorted++] = i;
				counter[i]--;
			}
		}
	}

}
