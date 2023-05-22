package com.alexdev.sortingalgs.algs;

import java.util.Random;

public class MergeSort {
	
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
		 * Sorting the numbers using the merge sort method.
		 */
		mergeSort(numbers);
		
		
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
	 * The algorithm works by separating the array in two, then sorting both
	 * of the new arrays if the number of elements is 2 or higher (this is done
	 * using merge sort, which means it's possible use recursion).
	 * 
	 * If the number of elements in an array is 1, it means the array is sorted 
	 * (an array with only 1 element is always sorted, as a number is always 
	 * sorted in relation to itself).
	 * 
	 * Then, it's possible to merge together both of the arrays (the merging is
	 * done in special way that keeps them sorted).
	 * 
	 * When all of the "sub-arrays" are merged together in the end, the array is
	 * fully sorted.
	 * 
	 * Example:
	 * 
	 * [14, 7, 12, 3]
	 * 		/    \  -> divide
	 * [14, 7]  [12, 3]
	 * 	 /  \     /   \ -> divide
	 * [14] [7] [12]  [3]
	 * 	\    /    \    / -> merge
	 * 	[7,14]    [3, 12]
	 * 	    \      / -> merge
	 *    [3, 7, 12, 14]
	 * 
	 * The process of merging works by getting the first elements of each array
	 * comparing, comparing them, adding the lowest one, and repeating (when one 
	 * of the arrays is empty, it is possible to just add the elements of the other
	 * array) until the two arrays are turned into one.
	 * 
	 * Example:
	 * 
	 * (x) -> first element of the array,
	 * 
	 * [(7), 14]   [(3), 12] -> []
	 * 7 > 3, then:
	 * [(7), 14]   [(12)] -> [3]
	 * 7 < 12, then:
	 * [(14)]   [(12)] -> [3, 7]
	 * 14 > 12, then:
	 * [(14)]   [] -> [3, 7, 12]
	 * 14 is being compared with and empty array, then:
	 * [] [] -> [3, 7, 12, 14]
	 * 
	 * TL;DR: separate an array into 2 sub-arrays, repeat the same with the
	 * sub-arrays (and sub-subarrays, and how many more necessary), until there are
	 * a bunch of 1-element arrays. Merge them all in order (arrays that used to be 
	 * same are merged together).
	 */
	private static void mergeSort(int[] numbers) {
		
		/*
		 * Getting the array's length and checking if it only has 1 element.
		 * Used mainly to make the recursion work later on.
		 */
		int inputLength = numbers.length;
		if (inputLength < 2) return;
		
		/*
		 * Separating the array in two.
		 */
		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];
		for (int i = 0; i < midIndex; i++) leftHalf[i] = numbers[i];
		for (int i = midIndex; i < inputLength; i++) rightHalf[i - midIndex] = numbers[i];

		/*
		 * Sorting the two sub-arrays.
		 * Here is where the recursion happens.
		 */
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		/*
		 * Merging the two sorted halfs into one.
		 */
		merge(numbers, leftHalf, rightHalf);
	}
	
	/*
	 * Merging is where all the magic happens, the arrays need to be merged in a
	 * specific way (as stated before). 
	 */
	private static void merge(int[] mergedArray, int[] subArrayA, int[] subArrayB) {

		/*
		*  Getting the length of the two sub-arrays
		*/
		int subArrayASize = subArrayA.length;
		int subArrayBSize = subArrayB.length;
		
		/*
		* Getting 3 ints, to be used to iterate thru the two sub-arrays and the merged array.
		*/
		int i = 0, j = 0, k = 0;
		
		/*
		* Looping thru both of the sub-arrays
		*/
		while (i < subArrayASize && j < subArrayBSize) {
			/*
			 * The elements of the 2 sub-arrays are getting compared,
			 * the lowest one gets added to the merged array.
			 */
			if (subArrayA[i] <= subArrayB[j]) {
				mergedArray[k] = subArrayA[i];
				i++;
			} else {
				mergedArray[k] = subArrayB[j];
				j++;
			}
			k++;
		}
		
		/*
		 * After the elements of the two arrays gets into the merged array, this while loop takes care of
		 * any leftover element in the first sub-array.
		 */
		while (i < subArrayASize) {
			mergedArray[k] = subArrayA[i];
			i++;
			k++;
		}
		
		/*
		 * After the elements of the two arrays gets into the merged array, this while loop takes care of
		 * any leftover element in the second sub-array.
		 */
		while (j < subArrayBSize) {
			mergedArray[k] = subArrayB[j];
			j++;
			k++;
		}
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
