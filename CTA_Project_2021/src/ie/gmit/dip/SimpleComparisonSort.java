package ie.gmit.dip;

import java.util.Arrays;
import java.util.Random;

public class SimpleComparisonSort { //Bubble Sort Ref 02

	public static void main(String[] args) {

		Random n = new Random(); // Random to generate a stream of pseudorandom numbers Ref 01

		int[] arr = new int[100]; // int[x] determines the size of the array

		System.out.print("Unsorted Array:");

		for (int i = 0; i < arr.length ; i++) { 
			int RandomN = n.nextInt(1000) + 1;  //nextInt(X) Where (X) determines the largest possible value in the array.
			System.out.print(RandomN + " ");
			arr[i] = RandomN;

		}

		System.out.println("\nSorted Array:" + (Arrays.toString(bubbleSort(arr)))); //Outputs the sorted array

	}

	public static int[] bubbleSort(int[] arr) { 
		int temp;
		long startTime = System.nanoTime(); //Start time for benchmark Ref 01

		for (int i = 0; i < arr.length; i++) { //Reverse < to get descending order
			for (int j = 1; j < arr.length- i; j++) {
				if (arr[j - 1] > arr[j]) {		
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}

		}
		long endTime = System.nanoTime(); // Benchmarking a single run Ref 01
		long elapsed = endTime - startTime;
		double timeMillis = elapsed / 1000000.0;
		System.out.print("\nSorthing Time:" + timeMillis + " ms");
		return arr;
	}
}