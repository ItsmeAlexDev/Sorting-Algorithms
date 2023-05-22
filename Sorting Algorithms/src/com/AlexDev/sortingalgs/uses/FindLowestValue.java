package com.alexdev.sortingalgs.uses;

import java.util.Random;

public class FindLowestValue {
	
	/*
	 * Value that go into generating an array to search for the lowest value in.
	 */
	private final static int numbersLength = 10;
	private final static int numbersSize = 100;
	
	/*
	 * Value that goes into deciding if the array is gonna be printed.
	 */
	private final static boolean displayNumberArray = true;
	
	public static void main(String[] args) {
		
		/*
		 * Generating a random array of numbers to search the lowest number in.
		 * 
		 * **Can also be done with a non-random array
		 */
		Random random = new Random();
		int[] numbers = new int[numbersLength];
	
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(numbersSize);
		}
		
		
		/*
		 * Displaying the array, allowing for a manual check of the lowest number.
		 * 
		 * **To print the numbers just change the value of "displayNumberArray" to true.
		 */
		if (displayNumberArray) printArray(numbers);
		
		/*
		 * Sorting the numbers.
		 */
		insertionSort(numbers);
		
		/*
		 * Displaying the array, showing the sorted state of the array.
		 * 
		 * **To print the numbers just change the value of "displayNumberArray" to true.
		 */
		if (displayNumberArray) printArray(numbers);

		/*
		 * Showing the lowest value of the array.
		 * 
		 * Using the first element of an sorted array is the easiest way to find the lowest
		 * number in an array.
		 */
		System.out.println("The lowest value in the array is: " + numbers[0]);
		
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
	 * Simple method to print out a full array.
	 *
	 * Receiving an array to print.
	 */
	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		System.out.println();
	}
}
