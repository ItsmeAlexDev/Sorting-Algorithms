package br.com.alexdev.sortingalgs.algs;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BogoSort {
	
	/*
	 * Configurando a quantidade de números para ordenar e o quão grande eles podem ser.
	 */
	private final static int qtdParaOrdenar = 10;//não vá além de ~10, é muito lento. O que você
	private final static int numerosTamanho = 100;//estava esperando? isso é, basicamente, só uma piada

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
		 * 
		 * O algoritmo bogo sort também é conhecido como:
		 * ->random sort;
		 * ->shuffle sort;
		 * ->monkey sort.
		 */
		bogoSort(numeros);

		/*
		 * Exibindo os números, após a ordenação.
		 */
		System.out.println("\nDepois: ");
		imprimeArray(numeros);

	}
	
	/*
	 * Método contendo o bogo sort.
	 * 
	 * O método só embaralha a array, até ficar ordenada.
	 */
	private static void bogoSort(int[] numerosArray) {
		/*
		 * Embaralhando os números, até eles ficarem em ordem.
		 */
		while (!estaOrdenada(numerosArray)) {
			embaralhaArray(numerosArray);
		}
		
	}
	
	/*
	 * Método para embaralhar uma array.
	 * 
	 * Recebendo uma array.
	 */
	private static void embaralhaArray(int[] array) {
		Random gerador = ThreadLocalRandom.current();
		for (int elemento = array.length - 1; elemento > 0; elemento--) {
			int index = gerador.nextInt(elemento + 1);
			int temp = array[index];
			      
			array[index] = array[elemento];
			array[elemento] = temp;
		}
	}
	
	/*
	 * Método para verificar se a array está ordenada.
	 * 
	 * Recebendo uma array para verificar.
	 */
	private static boolean estaOrdenada(int[] array) {
		/*
		 * Se a array tiver nenhum elemento ou só um elemento,
		 * a array vai estar sempre ordenada.
		 */
		if ((array == null) || (array.length <= 1)) return true;
		
		/*
		 * Para arrays com dois ou mais elementos, a array pode estar
		 * em um estado diferente de ordenada.
		 * 
		 * O for loop só verifica se todos os números na array é
		 * maior ou igual o número anterior.
		 */
		for (int indice = 0; indice < array.length - 1; indice++) {
		      if (array[indice] > array[indice + 1]) return false;
		}
		
		/*
		 * Se a array possui dois ou mais elementos e cada elemento é maior ou
		 * igual ao elemento anterior, então a array está ordenada.
		 */
		return true;
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
