package com.AlexDev.sortingalgs.algs;

import java.util.Random;

public class QuickSort {
	
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
		 * Sorting the numbers using the quick sort method.
		 */
		quickSort(numbers);
		
		
		/*
		 * Displaying the numbers post-sorting.
		 */
		System.out.println("\nAfter: ");
		printArray(numbers);
	
	}
	
	/*
	 * Using overloading to make a "clean" method, to call the
	 * "real" quicksort method, with the needed parameters.
	 * 
	 * The only use for the "clean" method is to call the "real"
	 * method.
	 */
	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	/*
	 * Method containing the sorting algorithm.
	 * 
	 * Receiving an array of numbers to sort, a low index and a high index.
	 * 
	 * The indexes are used to decide which partition of the "numbers" array
	 * to sort. Allowing the use of recursion, by separating different partitions
	 * used in the quicksort method.
	 */
	private static void quickSort(int[] numbers, int lowIndex, int highIndex) {
		
		/*
		 * If the array of numbers to sort, contains
		 * only one number, it is already sorted.
		 * 
		 * Used in recursion, as no one in their right mind
		 * would try to sort a length-1 array, I guess.
		 */
		if (lowIndex >= highIndex) return;
		
		/*
		 * Selecting a pivot to be used in the sorting method.
		 * 
		 * By using a random number (instead of always the last one)
		 * the algorithm gets slightly better.
		 */
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = numbers[pivotIndex];
		swap(numbers, pivotIndex, highIndex);
		
		/*
		 * Creating two pointers to be used in the algorithm,
		 * they "walk" towards the pivot.
		 */
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		/*
		 * Setting a while loop to be going, if the left and right pointers
		 * haven't both reached the pivot yet.
		 */
		while (leftPointer < rightPointer) {
			
			/*
			 * Walking the left pointer towards pivot, stopping if the pointer
			 * finds a number higher than the pivot.
			 */
			while (numbers[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			/*
			 * Walking the right pointer towards pivot, stopping if the pointer
			 * finds a number lower than the pivot.
			 */
			while (numbers[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			/*
			 * Swapping the numbers at the left pointer and right pointer.
			 * 
			 * The swap will put numbers higher than the pivot after the pivot
			 * and the numbers lower than the pivot before it.
			 */
			swap(numbers, leftPointer, rightPointer);
			
		}
		
		/*
		 * If somehow the number at the left pointer is higher than the
		 * last on the array (which can happen, caused by the way the pivot
		 * gets choosen) it can cause some errors, which are corrected here.
		 */
		if(numbers[leftPointer] > numbers[highIndex]) {
			/*
			 * The possible errors caused can be fixed by only changing the number at the
			 * left pointer with the last on the array.
			 */
			swap(numbers, leftPointer, highIndex);
		} else {
			/*
			 * If the error doesn't happen the algorithm can go on normally.
			 * 
			 * The setting of the left pointer as the last number on the array is
			 * used for the recursion.
			 */
			leftPointer = highIndex;
		}
		
		
		/*
		 * Using the quicksort method to sort the partitions before and after the
		 * pivot (which is already sorted), by using recursion.
		 */
		quickSort(numbers, lowIndex, leftPointer-1);
		quickSort(numbers, leftPointer+1, highIndex);
		
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
