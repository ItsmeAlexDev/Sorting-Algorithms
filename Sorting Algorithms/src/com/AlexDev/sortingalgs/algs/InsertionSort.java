package com.alexdev.sortingalgs.algs;

import java.util.Random;

public class InsertionSort {

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
		Random randomGen = new Random();
		int[] numbers = new int[amountToSort];
	
		for (int index = 0; index < numbers.length; index++) {
			numbers[index] = randomGen.nextInt(numbersSize);
		}
		
		/*
		 * Displaying the numbers pre-sorting.
		 */
		System.out.println("Before: ");
		printArray(numbers);
		
		/*
		 * Sorting the numbers using the insertion sort method.
		 */
		insertionSort(numbers);
		
		
		/*
		 * Displaying the numbers post-sorting.
		 */
		System.out.println("\nAfter: ");
		printArray(numbers);
	
	}
	
	/*
	 * Method containing the sorting algorithm.
	 * 
	 * Receiving an array of numbers to sort.
	 * 
	 * The array is sorted by putting every element in the order it should be,
	 * one at a time. Example:
	 * -having an array that looks like this: 2, 8, 5, 7, 9.
	 * -you can get the first number and put it in the "new"* (sorted) array,
	 * so now the sorted array looks like this: 2.
	 * -after that you can get the next number, which is 8, that goes after 2,
	 * so now the sorted array looks like this: 2, 8.
	 * -after that you can get the next number, which is 5, that goes between 2 and 8,
	 * so now the sorted array looks like this: 2, 5, 8.
	 * -you can go on and on, and after the last element is put in its right place,
	 * the array is sorted
	 * 
	 * *the "new" array can be the array that is being sorted, it's not an actual
	 * new array, it gets easier to understand later on.
	 * 
	 * TL;DR: put every element in its right place, then it's sorted.
	 * 
	 */
	private static void insertionSort(int[] array) {
		
		
		/*
		 * The way I'm going to do the algorithm is by having the number that is
		 * currently getting to the right place, check if the number before is lower or greater.
		 * 
		 * If it is lower, then, the current number should be in the right place.
		 * If it is higher, then, the current number should go to the place of the number before.
		 * 
		 * By repeating this enough times to every element in an array, the array should be sorted.
		 * 
		 */
		for (int index = 1; index < array.length; index++) {
			/*
			 * Going thru every number, and getting the current value.
			 */
			int currentValue = array[index];
			
			/*
			 * Getting a temporary variable for the number before the current value.
			 */
			int beforeValue = index - 1;
			
			/*
			 * The while loop goes on if "j" has not reached the start of the array (where "j" would be -1
			 * since we are basically only dealing with positive numbers) AND the number on the "j" position
			 * of the array is greater than the current value being put to its right place.
			 * 
			 * If the current value is lower than the one before, then the value before the current value gets
			 * in current value's position, and the value before place gets decreased by 1, so I'm now seeing the
			 * value before than the shifted one.
			 * 
			 * The cycle repeats itself until a number lower than the current one is reached or the start of the array.
			 */
			while (beforeValue >= 0 && array[beforeValue] > currentValue) {
				array[beforeValue + 1] = array[beforeValue];
				beforeValue--;
			}

			/*
			 * When the cycle ends you can put the current value can be put in front of the place before the
			 * current value, which should be its right place.
			 */
			array[beforeValue+1] = currentValue;
		}
	
	}
	
	/*
	 * Simple method to print out a full array.
	 *
	 * Receiving an array to print.
	 */
	private static void printArray(int[] numbers) {
		for (int index = 0; index < numbers.length; index++) {
			System.out.println(numbers[index]);
		}
	}
}
