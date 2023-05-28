package br.com.alexdev.sortingalgs.uses;

import java.util.Random;

public class MaiorValor {
	
	/*
	 * Valores que vão na criação da array para procurar em.
	 */
	private final static int qtdParaOrdenar = 10;
	private final static int numerosTamanho = 100;
	
	/*
	 * Valor que decide se a array vai ser impressa.
	 */
	private final static boolean displayNumberArray = false;
	
	public static void main(String[] args) {
		
		/*
		 * Gerando uma array de números aleatórios para procurar o maior número em.**
		 * 
		 * **Também pode ser feito com uma array não aleatória.
		 */
		Random gerador = new Random();
		int[] numeros = new int[qtdParaOrdenar];
	
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = gerador.nextInt(numerosTamanho);
		}
		
		
		/*
		 * Mostrando a array, permitindo uma verificação manual do maior número.
		 * 
		 * **Para imprimir os números, é necessário somente mudar o valor de displayNumberArray
		 * para true.
		 */
		if (displayNumberArray) imprimeArray(numeros);
		
		/*
		 * Ordenando a array.
		 */
		insertionSort(numeros);
		
		/* 
		 * Imprimindo (de maneira opcional) a array de números.
		 * Mostrando o estado ordenado da array.
		 * 
		 * **Para imprimir os números, é necessário somente mudar o valor de displayNumberArray
		 * para true.
		 */
		if (displayNumberArray) imprimeArray(numeros);

		/*
		 * Mostrando o maior valor da array.
		 * 
		 * Usando o último valor da array (quando ordenada) é maneira mais fácil de achar o
		 * maior valor da array.
		 */
		System.out.println("O valor mais alto da array é: " + numeros[numeros.length - 1]);
		
	}
	
	/*
	 * Simples método para ordenação da array, usando o Algoritmo Insertion Sort.
	 * (que também pode ser encontrado nesse projeto).
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
	 * Método para imprimir uma array.
	 *
	 * Recebendo uma array para imprimir.
	 */
	private static void imprimeArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		System.out.println();
	}
}
