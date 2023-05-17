package com.AlexDev.sortingalgs.algs;

import java.util.Random;

public class ShellSort {
	
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
		 * Sorting the numbers using the shellsort method.
		 */
		shellSort(numbers);
		
		
		/*
		 * Displaying the numbers post-sorting.
		 */
		System.out.println("\nAfter: ");
		printArray(numbers);
	
	}
	
	/*
	 * Shellsort is a generalization (optimization) of the insertion sort algorithm.
	 * 
	 * By using the insertion sort algorithm and having an array such as:
	 * [3, 4, 10, 6, 7, 2]
	 * As the first three elements of the array (3, 4, 10) are already sorted, the next step
	 * of the process would be to swap 10 and 6, to sort the first four elements of the array, leaving 
	 * the array as:
	 * [3, 4, 6, 10, 7, 2]
	 * The next step is going to be to swap 10 and 7, resulting in:
	 * [3, 4, 6, 7, 10, 2]
	 * Now the sorted sub-array is made out of the first five elements of the array, leaving only one
	 * more to be sorted (2, at the end of the array). It's noticeable that, 2 being the lowest number
	 * should go on the start of the array.
	 * If the insertion sort algorithm was to be applied, five more swaps would need to happen:
	 * 
	 * Starting point -> [3, 4, 6, 7, 10, 2]
	 * 
	 * 1 - swap 2 and 10 -> [3, 4, 6, 7, 2, 10]
	 * 2 - swap 2 and 7  -> [3, 4, 6, 2, 7, 10]
	 * 3 - swap 2 and 6  -> [3, 4, 2, 6, 7, 10]
	 * 4 - swap 2 and 4  -> [3, 2, 4, 6, 7, 10]
	 * 5 - swap 2 and 3  -> [2, 3, 4, 6, 7, 10]
	 * 
	 * Final point (sorted array) -> [2, 3, 4, 6, 7, 10]
	 * 
	 * Making a total of 7 swaps.
	 * 
	 * If in the start there was a swap between 10 and 2:
	 * From [3, 4, 10, 6, 7, 2], to [3, 4, 2, 6, 7, 10]
	 * 
	 * There would be only two more swaps needed:
	 * 
	 * Starting point -> [3, 4, 2, 6, 7, 10]
	 * 
	 * 1 - swap 2 and 4 -> [3, 2, 4, 6, 7, 10]
	 * 2 - swap 2 and 3 -> [2, 3, 4, 6, 7, 10]
	 *
	 * Final point (sorted array) -> [2, 3, 4, 6, 7, 10]
	 * 
	 * Making a total of 3 swaps.
	 * 
	 * The opitimization works by sorting (swapping, in a sorted way) elements at different
	 * gaps (distances between each other), making more effective swaps.
	 * 
	 * TL;DR: Shellsort is basically Insertion Sort, but better.
	 */
	private static void shellSort(int[] numbers) {
		/*
		 * When comparing numbers that should be compared first, it's needed to get the
		 * distance between them (the value of the gap). As every element and the element 
		 * at the distance of gap of it are going to be sorted (*swaped, in a sorted way).
		 * Using the gap of half of the size (length) of the array is the best way to do it.
		 * 
		 * After the sorting of every element with the element at gap distance, the gap can be 
		 * divided by 2, as the gap necessary to make good swaps has been decreased.
		 * 
		 * When the gap reaches 1, the sorting that will happen, will be just a Insertion Sort.
		 */
		for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
			/*
			 * The Insertion Sort Algorithm here has some slight changes to work with the gap system.
			 * Instead of starting in the first element of the array, it's possible to start at the value
			 * of gap (as it is going to decrease and reach 1).
			 * 
			 * And the numbers being compared, are relative to the value of gap (not 1, that happens in the
			 * original version of Insertion Sort).
			 */
			for (int i = gap; i < numbers.length; i++) {
				int j = i;
				while (j >= gap && numbers[j] - numbers[j - gap] < 0) {
					swap(numbers, j, (j-gap));
					j-=gap;
				}
			}
		}
	}
	
	/*
	 * Simple method to swap two elements in an array.
	 *
	 * Receiving an array to print.
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
