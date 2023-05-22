package com.alexdev.sortingalgs.algs;

import java.util.Random;

public class CocktailShakerSort {
	
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
		 * Sorting the numbers using the cocktail shaker sort method.
		 */
		cocktailShakerSort(numbers);
		
		
		/*
		 * Displaying the numbers post-sorting.
		 */
		System.out.println("\nAfter: ");
		printArray(numbers);
	
	}
	
	/*
	 * The CocktailShaker Sort Algorithm, also know as:
	 * -Bidirectional Bubble Sort;
	 * -Cocktail Sort;
	 * -Ripple Sort;
	 * -Shuttle Sort.
	 * is a sorting algorithm, that works similarly to the Bubble Sort Algorithm.
	 * 
	 * The main difference is that the CocktailShaker Algorithm works by going back
	 * and forth the array, "bubbling" up the highest numbers, and "bubbling" down the
	 * lowest numbers.
	 *
	 * After doing the process, if there was a swap, the array could still not be sorted,
	 * so it is only safe to stop when the process happens and there is no swaps done (that
	 * should indicate that the array is sorted).
	 */
	private static void cocktailShakerSort(int[] numbers) {
		
		/*
		 * Using a quite diferent way than used in the "BubbleSort" (in this project).
		 * 
		 * Here the sorting only stops when the process of "bubbling" can not change (swap)
		 * any elements, indicating that the array is sorted.
		 */
		boolean swapped;
		
		do {
			/*
			 * Here, "swapped" is set to false, as there is no possible swapping that can happen 
			 * to this point.
			 */
			swapped = false;

			/*
			 * Here is the process of "bubbling" up the highest numbers.
			 */
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					swap(numbers, j, (j+1));
					/*
					 * If any swap has to be made, "swapped" is set to true.
					 */
					swapped = true;
				}
			}

			/*
			 * Checking if there was a swap before, during the "bubbling" up process, if there
			 * is no swaps during the process, the array should be sorted. Therefore, there is no
			 * reason to continue with the sorting process.
			 */
			if (!swapped) break;

			/*
			 * Here is the process of "bubbling" down the lowest numbers.
			 */
			for (int j = numbers.length; j < 0; j--) {
				if (numbers[j] > numbers[j + 1]) {
					swap(numbers, j, (j+1));
					swapped = true;
				}
			}

		/*
		 * If there is no swaps made during the "bubbling" down process, the array should already be 
		 * sorted, so the process of sorting stops (as the while loop is no longer going to happen).
		 */
		} while (swapped);
		
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
