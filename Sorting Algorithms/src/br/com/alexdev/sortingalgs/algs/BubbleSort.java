package br.com.alexdev.sortingalgs.algs;

import java.util.Random;

public class BubbleSort {
	
	/*
	 * Configurando a quantidade de números para ordenar e o quão grande eles podem ser.
	 */
	private final static int qtdParaOrdenar = 10;
	private final static int numerosTamanho = 100;

	public static void main(String[] args) {
		
		/*
		 * Gerando números aleatoriamente, para ordenar.
		 */
		Random gerador = new Random();
		int[] numeros = new int[qtdParaOrdenar];
	
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = gerador.nextInt(numerosTamanho);
		}
		
		/*
		 * Exibindo os números, antes da ordenação.
		 */
		System.out.println("Antes: ");
		imprimeArray(numeros);
		
		/*
		 * Ordenando os números usando o método bogo sort.
		 */
		bubbleSort(numeros);
		
		
		/*
		 * Exibindo os números, após a ordenação.
		 */
		System.out.println("\nDepois: ");
		imprimeArray(numeros);
	
	}
	
	/*
	 * Bubble sort é um algoritmo de ordenação onde os números ficame em ordem por "bolhar" os
	 * maiores números para cima (mais perto do fim da array). Isso funciona trocando os números
	 * (quando o número na menor posição da comparação é maior), depois selecionando os
	 * números sendo comparados para os atuais + 1, continuando o processo de "bolhar" para cima.
	 * 
	 * Depois de uma vez, o maior número vai estar na maior posição. Repetindo o processo até
	 * não haver mais trocas sendo feitas, deve assegurar que a array esta ordenada. Outro modo de
	 * fazer isso é repetindo o processo de "bolhar" para cima, uma vez para cada elemento na array.
	 */
	private static void bubbleSort(int[] numeros) {
		/*
		 * Fazendo o processo uma vez para cada elemento da array.
		 */
		for (int indiceArray = 0; indiceArray < numeros.length - 1; indiceArray++)
			/*
			 * Processo de "bolhar" para cima, indo todo o caminho para o topo da array (não indo até o final,
			 * já que não a necessidade de "bolhar" para cima se o maior número já estiver em tal posição da
			 * array, e diminuindo por 1, cada vez que o processo é feito, para fazer o processo levemente
			 * mais rápido).
			 */
			for (int indiceSubArray = 0; indiceSubArray < numeros.length - 1 - indiceArray; indiceSubArray++)
				/*
				 * Trocando os números, se estes estiverem fora de ordem.
				 */
				if (numeros[indiceSubArray] > numeros[indiceSubArray + 1]) troca(numeros, indiceSubArray, (indiceSubArray+1));
	}
	
	/*
	 * Método para trocar dois elementos em uma array.
	 * 
	 * Recebendo uma array e dois indices.
	 */
	private static void troca(int[] array, int indice1, int indice2) {
		
		int temp = array[indice1];
		array[indice1] = array[indice2];
		array[indice2] = temp;
		
	}
	
	/*
	 * Método para imprimir uma array.
	 *
	 * Recebendo uma array para imprimir.
	 */
	private static void imprimeArray(int[] numeros) {
		for (int indice = 0; indice < numeros.length; indice++) {
			System.out.println(numeros[indice]);
		}
	}
}
