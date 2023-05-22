package com.alexdev.sortingalgs.uses;

import java.util.Random;

public class BinarySearch {
	
	/*
	 * Value that go into generating an array to search in.
	 */
	private final static int numbersLength = 1000;
	private final static int numbersSize = 100;
	
	/*
	 * Value that is going to be searched for.
	 */
	private final static int numberToFind = 42;//the meaning of life.
	
	/*
	 * Value that goes into deciding if the array is gonna be printed.
	 */
	private final static boolean displayNumberArray = false;
	
	public static void main(String[] args) {
		
		/*
		 * Generating a random array of numbers to search a specific number in.
		 * 
		 * **Can also be done with a non-random array
		 */
		Random random = new Random();
		int[] numbers = new int[numbersLength];
	
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(numbersSize);
		}
		
		/*
		 * PRE-SORTING
		 * (optional) Printing of the numbers array (with a visual cue to help find the wanted number),
		 * to do a manual search, if wanted.
		 * 
		 * **To print the numbers just change the value of "displayNumberArray" to true.
		 */
		if (displayNumberArray) printArray(numbers);
		
		/*
		 * Trying to make a binary search in an array that is not sorted and printing the result.
		 */
		System.out.println(utilStr(numbers, binarySearch(numbers, numberToFind)));
		
		/*
		 * Sorting the array to test if the binary search method will work with a sorted array.
		 */
		insertionSort(numbers);

		/*POST-SORTING
		 * (optional) Printing of the numbers array.
		 */
		if (displayNumberArray) printArray(numbers);

		/*
		 * Making a binary search in an array that is sorted.
		 */
		System.out.println(utilStr(numbers, binarySearch(numbers, numberToFind)));
		
	}
	
	/*
	 * Method containing the Binary Search Algorithm.
	 * 
	 * Receiving an array and a value to find in the array.
	 * 
	 * The Binary Search Algorithm works by separating the array in two halves, then checking in
	 * what half the desired value should be in (also, if it is the value just in the middle of the
	 * array).
	 * 
	 * The Binary Search Algorithm is efficient, as it can quickly discard places where the desired
	 * value couldn't be. For this to work the array that the Binary Search Method receive should be
	 * sorted, if it isn't there can (and will the great majority of times) be some problems.
	 */
	private static int binarySearch(int[] numbers, int targetValue) {
		
		/*
		 * Pointers for the low value of the array, the first index (being analysed)
		 * and the high value of the array, the last index (being analysed).
		 */
		int low = 0;
		int high = numbers.length - 1;
		
		/*
		 * As the low value gets higher and high value gets lower in the search for the desired value
		 * they can eventually reach each other (and even go further in the direction where the other 
		 * should be), if the low value surpasses the high value, the desired value couldn't be found
		 * anywhere in the array. So the Binary Search Method should return -1, as it means the value 
		 * isn't inside (or couldn't be found for some reason, in) the array.
		 */
		while(low <= high) {
			/*
			 * Finding the middle of the array, and the value of the element at the position.
			 */
			int midPos = (low + high) / 2;
			int midNum = numbers[midPos];
			
			/*
			 * Checking if the desired value is the middle value, higher than the middle value or 
			 * lower than the middle value. Checking the middle and both halves.
			 * 
			 * if the desired value is the middle value, the method found the desired value.
			 * if the number is not in the middle, the method sets the array to check for to
			 * be smaller, depending on which half the desired value should be (assuming it is
			 * in the array).
			 */
			if(targetValue == midNum) return midPos;
			if(targetValue < midNum) high = midPos - 1;
			else low = midPos + 1;
		}
		
		/*
		 * Returning -1 if the method fails to find the desired value.
		 */
		return -1;
	}
	
	/*
	 * Simple method for sorting an array, using the Insertion Sort algorithm.
	 * (that can also be found in this project).
	 */
	private static void insertionSort(int[] array) {
		
		for (int i = 1; i < array.length; i++) {
			int currentValue = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > currentValue) {
				array[j + 1] = array[j];
				j--;
			}
			array[j+1] = currentValue;
		}
	
	}
	
	
	/*
	 * Method to organize the code.
	 * 
	 * Shows if the Binary Search Algorithm works with an unsorted array.
	 */
	private static String utilStr(int[] numbers, int bSearch) {
		
		String str1 = (isArraySorted(numbers) ? "Result when array is sorted: " : 
												"Result when array is NOT sorted: ");

		String str2 = (bSearch == -1 ? "Haven't found anything. \n" : 
									   "Found the value (" + numberToFind + ") at: " + bSearch + "\n" +
									   "numbers[" + bSearch +  "] = " + numbers[bSearch]);
		
		return str1 + "\n" + str2;
	}
	
	/*
	 * Simple method to check if an array is sorted.
	 * 
	 * Receiving an array to check.
	 */
	private static boolean isArraySorted(int[] array) {
		if ((array == null) || (array.length <= 1)) return true;
		for (int i = 0; i < array.length - 1; i++) if (array[i] > array[i + 1]) return false;
		return true;
	}
	
	/*
	 * Simple method to print out a full array.
	 *
	 * Receiving an array to print.
	 * 
	 * Shows "numberToFind" in a easier way to see in a very large array.
	 */
	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == numberToFind) System.out.println();
			if (numbers[i] == numberToFind) System.out.println("========");
			System.out.println(numbers[i]);
			if (numbers[i] == numberToFind) System.out.println("========");
			if (numbers[i] == numberToFind) System.out.println();
		}
		System.out.println();
	}
}
