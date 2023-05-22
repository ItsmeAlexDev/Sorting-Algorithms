package com.alexdev.sortingalgs.algs;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/***
 * us.com.anybs -> eng
 * 
 * br.com.anybs -> port
 * 
 * com.alexdev -> all in lower case
 * @since 1.8
 * @author Alex
 *
 */
public class BogoSort {
	
	/*
	 * Setting up the amount of numbers to sort and how big they can be.
	 */
	private final static int amountToSort = 10;//do not go over ~10, it's just too slow
	private final static int numbersSize = 100;//what were you expecting? this is, basically, just a joke

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
		 * Sorting the numbers using the bogo sort method.
		 * 
		 * the bogo sort algorithm is also know as:
		 * ->random sort;
		 * ->shuffle sort;
		 * ->monkey sort.
		 */
		bogoSort(numbers);

		/*
		 * Displaying the numbers post-sorting.
		 */
		System.out.println("\nAfter: ");
		printArray(numbers);

	}
	
	/*
	 * Method containing the bogo sort.
	 * 
	 * It just shuffles the list, until it is sorted.
	 */
	private static void bogoSort(int[] numberArray) {
		/*
		 * Shuffling the numbers until they are in order (sorted)
		 */
		while (!isArraySorted(numberArray)) {
			shuffleArray(numberArray);
		}
		
	}
	
	/*
	 * Simple method to shuffle an Array.
	 * 
	 * Receiving an array.
	 */
	private static void shuffleArray(int[] array) {
		Random rnd = ThreadLocalRandom.current();
		for (int i = array.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			int a = array[index];
			      
			array[index] = array[i];
			array[i] = a;
		}
	}
	
	/*
	 * Simple method to check if an array is sorted.
	 * 
	 * Receiving an array to check.
	 */
	private static boolean isArraySorted(int[] array) {
		/*
		 * If the array has no elements or only one element,
		 * then the array is always already sorted.
		 */
		if ((array == null) || (array.length <= 1)) return true;
		
		/*
		 * For arrays with two or more elements, the array can be
		 * in a state different than sorted.
		 * 
		 * The for loop just checks if every number in the array is
		 * higher or equal than the number before.
		 */
		for (int i = 0; i < array.length - 1; i++) {
		      if (array[i] > array[i + 1]) return false;
		}
		
		/*
		 * If the array has two or more elements and each element is higher or
		 * equal to the element before it, then the array is sorted.
		 */
		return true;
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
