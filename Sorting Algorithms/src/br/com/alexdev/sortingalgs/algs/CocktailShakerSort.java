package br.com.alexdev.sortingalgs.algs;

import java.util.Random;

public class CocktailShakerSort {
	
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
		cocktailShakerSort(numeros);
		
		
		/*
		 * Exibindo os números, após a ordenação.
		 */
		System.out.println("\nDepois: ");
		imprimeArray(numeros);
	
	}
	
	/*
	 * O Algoritmo CocktailShaker Sort, também conhecido como:
	 * -Bubble Sort Bidirecional;
	 * -Cocktail Sort;
	 * -Ripple Sort;
	 * -Shuttle Sort.
	 * é um algoritmo de ordenação, que funciona similar ao Algoritmo Bubble Sort.
	 * 
	 * A principal diferença é que o Algoritmo CocktailShaker funciona indo e voltando
	 * na array, "bolhando" para cima os maiores números, e "bolhando" para baixo os
	 * menores números.
	 *
	 * Depos de fazer o processo, se houver uma troca, a array pode estar ainda fora de ordem,
	 * então só é seguro parar quando o processo acontecer e não houver nenhuma troca feita (que
	 * deveria indicar que a array está ordenada).
	 */
	private static void cocktailShakerSort(int[] numeros) {
		
		/*
		 * Usando um modo diferente do usado em "BubbleSort" (nesse projeto)
		 * 
		 * Aqui a ordenação só para quando o processo de "bolhar" não consegue mudar (trocar)
		 * nenhum elemento, indicando que a array está ordenada.
		 */
		boolean trocou;
		
		do {
			/*
			 * Aqui, "trocou" é definido como falso, já que não há trocas possíveis que podem acontecer 
			 * até esses ponto.
			 */
			trocou = false;

			/*
			 * Aqui está o pocesso de "bolhar" para cima os maiores números.
			 */
			for (int indice = 0; indice < numeros.length - 1; indice++) {
				if (numeros[indice] > numeros[indice + 1]) {
					troca(numeros, indice, (indice+1));
					/*
					 * Se qualquer troca tem que ser feita, "trocou" é definido como verdadeiro.
					 */
					trocou = true;
				}
			}

			/*
			 * Verificando se houve alguma troca antes, durante o processo de "bolhar" para cima, se
			 * não houve trocas durante o processo, a array deve estar em ordem. Então, não há
			 * rasão para continuar com o processo de ordenação.
			 */
			if (!trocou) break;

			/*
			 * Aqui está o pocesso de "bolhar" para baixo os menores números.
			 */
			for (int indice = numeros.length; indice < 0; indice--) {
				if (numeros[indice] > numeros[indice + 1]) {
					troca(numeros, indice, (indice+1));
					trocou = true;
				}
			}

		/*
		 * Se não houver trocas feitas durante o processo de "bolhar" para baixo, array deveria já 
		 * estar em ordem, então o processo de ordenação para (já que o while loop para de acontecer).
		 */
		} while (trocou);
		
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
