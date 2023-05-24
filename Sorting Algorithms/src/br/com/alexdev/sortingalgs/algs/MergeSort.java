package br.com.alexdev.sortingalgs.algs;

import java.util.Random;

public class MergeSort {
	
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
		 * Ordenando os números usando o método cocktail shaker sort.
		 */
		mergeSort(numeros);
		
		
		/*
		 * Exibindo os números, após a ordenação.
		 */
		System.out.println("\nDepois: ");
		imprimeArray(numeros);
	
	}
	
	/*
	 * Método contendo o algoritmo de ordenação.
	 * 
	 * Recevendo uma array de números para ordenar.
	 * 
	 * O algoritmo funciona pelo processo de separar a array em duas, e depois 
	 * ordenando ambas as novas arrays se o número de elementos é de 2 ou maior 
	 * (isso é feito usando diretamente o método, permitindo o uso de recursão).
	 * 
	 * Se o número de elementos em uma array é de 1, isso significa que a array está
	 * ordenada (uma array com só 1 elemento sempre está ordenada, já que o número sempre
	 * está em ordem em relação a si mesmo).
	 * 
	 * Então, é possível unificar junto ambas as arrays (a unificação é feita de modo à
	 * preservar a ordenação das arrays)
	 * 
	 * Quando todas as "sub-arrays" estão ordenadas no final, a array fica completamente
	 * ordenada.
	 * 
	 * Exemplo:
	 * 
	 * [14, 7, 12, 3]
	 * 		/    \  -> divisão
	 * [14, 7]  [12, 3]
	 * 	 /  \     /   \ -> divisão
	 * [14] [7] [12]  [3]
	 * 	\    /    \    / -> unificação
	 * 	[7,14]    [3, 12]
	 * 	    \      / -> unificação
	 *    [3, 7, 12, 14]
	 * 
	 * O processo de unificação funciona pegando o primeiro elemento de cada array na
	 * comparação, comparando eles, adicionando o menor na array principal e repetindo
	 * (quando uma das arrays fica vazia, é possível, adicionar os elementos da outra 
	 * array) até as duas arrays virarem uma só.
	 * 
	 * Exemplo:
	 * 
	 * (x) -> primeiro elemehnto da array,
	 * 
	 * [(7), 14]   [(3), 12] -> []
	 * 7 > 3, então:
	 * [(7), 14]   [(12)] -> [3]
	 * 7 < 12, então:
	 * [(14)]   [(12)] -> [3, 7]
	 * 14 > 12, então:
	 * [(14)]   [] -> [3, 7, 12]
	 * 14 está sendo comparado com uma array vazia, então:
	 * [] [] -> [3, 7, 12, 14]
	 * 
	 * TL;DR: Separa uma array em 2 sub-arrays, repete o processo com as sub-arrays, até
	 * um monte de arrays de 1 elemento. Unifica todas elas em ordem.
	 */
	private static void mergeSort(int[] numeros) {
		
		/*
		 * Pegando o tamanho da array e verificando se a array só possui um elemento.
		 * Usado principalmente para fazer a recursão.
		 */
		int inputTamanho = numeros.length;
		if (inputTamanho < 2) return;
		
		/*
		 * Separando a array em duas.
		 */
		int meioIndice = inputTamanho / 2;
		int[] metade_1 = new int[meioIndice];
		int[] metade_2 = new int[inputTamanho - meioIndice];
		for (int i = 0; i < meioIndice; i++) metade_1[i] = numeros[i];
		for (int i = meioIndice; i < inputTamanho; i++) metade_2[i - meioIndice] = numeros[i];

		/*
		 * Ordenando as duas sub-arrays.
		 * Aqui a recursão acontece.
		 */
		mergeSort(metade_1);
		mergeSort(metade_2);
		
		/*
		 * Unificando as duas metades ordenadas em uma.
		 */
		merge(numeros, metade_1, metade_2);
	}
	
	/*
	 * Unificação é onde toda a magia acontece, as arrays precisam ser unificadas
	 * em um modo específico.
	 */
	private static void merge(int[] arrayUnificada, int[] subArrayA, int[] subArrayB) {

		/*
		 *  Pegando o tamanha das duas sub-arrays.
		 */
		int subArrayATamanho = subArrayA.length;
		int subArrayBTamanho = subArrayB.length;
		
		/*
		 * Estabelecendo 3 variáveis, para ser usadas no processo de unificação.
		 */
		int iteradorA = 0, iteradorB = 0, iteradorArrUnificada = 0;
		
		/*
		 * Passando por ambas a sub-arrays.
		 */
		while (iteradorA < subArrayATamanho && iteradorB < subArrayBTamanho) {
			/*
			 * Os elemendos das 2 sub-arrays estão sendo comparados,
			 * o menor entre eles é adicionado a array unificada.
			 */
			if (subArrayA[iteradorA] <= subArrayB[iteradorB]) {
				arrayUnificada[iteradorArrUnificada] = subArrayA[iteradorA];
				iteradorA++;
			} else {
				arrayUnificada[iteradorArrUnificada] = subArrayB[iteradorB];
				iteradorB++;
			}
			iteradorArrUnificada++;
		}
		
		/*
		 * Depois dos elementos das duas arrays forem adicionados à array unificada, esse loop toma conta
		 * de qualquer elemento deixado para trás, na primeira sub-array.
		 */
		while (iteradorA < subArrayATamanho) {
			arrayUnificada[iteradorArrUnificada] = subArrayA[iteradorA];
			iteradorA++;
			iteradorArrUnificada++;
		}
		
		/*
		 * Depois dos elementos das duas arrays forem adicionados à array unificada, esse loop toma conta
		 * de qualquer elemento deixado para trás, na segunda sub-array.
		 */
		while (iteradorB < subArrayBTamanho) {
			arrayUnificada[iteradorArrUnificada] = subArrayB[iteradorB];
			iteradorB++;
			iteradorArrUnificada++;
		}
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
