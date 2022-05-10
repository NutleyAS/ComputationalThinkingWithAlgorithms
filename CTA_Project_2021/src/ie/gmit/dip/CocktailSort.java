package ie.gmit.dip; 

import java.util.Arrays;
import java.util.Random;

public class CocktailSort { //Ref 03

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

		System.out.println("\nSorted Array:" + (Arrays.toString(cocktailSort(arr)))); // Outputs the sorted array

	}
		
	public static int[] cocktailSort(int arr[]) { 
	
		boolean swapped = true;
		int start = 0;
		int fin = arr.length; 			
		long startTime = System.nanoTime(); // log the start time (in nanoseconds)

		while (swapped == true) {
		
			swapped = false; //reset the swapped flag on entering the loop. This is done because it might be true from a previous iteration
		
			for (int i = start; i< fin -1; i++) { //loop from bottom to top like with bubble sort
			
				if (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
					}
				}
		
			if (swapped == false) //if nothing is moved the array is sorted
				break;
		
			swapped = false; //otherwise reset swapped flag so it can be used for next stage
		
		
			fin = fin - 1; //Move the fin point back by one, because item at the end is in correct place
			
			for (int i = fin - 1; i >= start; i--) { //from top to bottom using same comparison as previous stage
				
				if (arr[i] > arr[i + 1]) {
					
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					swapped = true;
					}
				}
			
			
			start = start + 1; //increase the starting point because the previous stage has moved the smallest number to its correct spot
		}
	
		
		long endTime = System.nanoTime(); //log the end time (in nanseconds) Ref 01
		long elapsed = endTime-startTime; //calculate the run time (in nanoseconds)
		double timeMillis = elapsed/1000000.0; //convert from nanoseconds to miliseconds
		System.out.print("\nSorthing Time: " + timeMillis + "  ms");
		return arr;
	}
		
}
