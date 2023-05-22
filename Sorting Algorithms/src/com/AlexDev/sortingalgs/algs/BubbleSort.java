package com.alexdev.sortingalgs.algs;

import java.util.Random;

public class BubbleSort {
	
	/*
	 * Setting up the amount of numbers to sort and
	 * how big they can be.
	 */ 
	private final static int amountToSort = 10;
	private final static int numbersSize = 100;

	public static void main(String[] args) {
		
		/*
		 * Generating a bunch of random numbers to be sorted.
		 */
		Random random = new Random();
		int[] numbers = new int[amountToSort];
	
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(numbersSize);
		}
		
		/*
		 * Displaying the numbers pre-sorting.
		 */
		System.out.println("Before: ");
		printArray(numbers);
		
		/*
		 * Sorting the numbers using the bubble sort method.
		 */
		bubbleSort(numbers);
		
		
		/*
		 * Displaying the numbers post-sorting.
		 */
		System.out.println("\nAfter: ");
		printArray(numbers);
	
	}
	
	/*
	 * Bubble sort is a sorting algorithm where the numbers get sorted by "bubbling" the
	 * the highest numbers up (closer to the end of the array). This works by swapping numbers
	 * (when the number in the lowest position of the comparison is higher), then setting the
	 * numbers being compared to the current + 1, continuing with "bubbling" up.
	 * 
	 * After one time, the highest number is going to be in the highest position. Repeating the
	 * process until there are no swaps done, should ensure that the array is sorted. Another way to
	 * do that is by repeating the process of "bubbling" up, one time for each element in the array.
	 */
	private static void bubbleSort(int[] numbers) {
		/*
		 * Doing the process once for every element of the array (the process doesn't happen with the
		 * last element, as there is no "bubbling" up from there).
		 */
		for (int i = 0; i < numbers.length - 1; i++)
			/*
			 * Process of "bubbling" up, going all the way up on the array (not going to the very end,
			 * as there is no need to "bubble" up if the highest element is already on the last position
			 * of the array, and decreasing by 1, every time the process is done, to make the process
			 * slitghly faster).
			 */
			for (int j = 0; j < numbers.length - i - 1; j++)
				/*
				 * Swapping the numbers, if they are in the wrong order (not sorted).
				 */
				if (numbers[j] > numbers[j + 1]) swap(numbers, j, (j+1));
	}
	
	/*
	 * Simple method to swap two elements in an array.
	 *
	 * Receiving an array and two indexes.
	 */
	private static void swap(int[] array, int index1, int index2) {
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
	}
	
	/*
	 * Simple method to print out a full array.
	 *
	 * Receiving an array to print.
	 */
	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
