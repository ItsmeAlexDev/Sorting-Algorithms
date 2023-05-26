package br.com.alexdev.sortingalgs.uses;

import java.util.Random;

public class BinarySearch {
	
	/*
	 * Valores que vão na criação da array para procurar em.
	 */
	private final static int qtdParaOrdenar = 10;
	private final static int numerosTamanho = 100;
	
	/*
	 * Valor que vai ser procurado por na array.
	 */
	private final static int numeroParaAchar = 42;//significado da vida.
	
	/*
	 * Valor que decide se a array vai ser impressa.
	 */
	private final static boolean displayNumberArray = false;
	
	public static void main(String[] args) {
		
		/*
		 * Gerando uma array de números aleatórios para procurar um número especifíco em.**
		 * 
		 * **Também pode ser feito com uma array não aleatória.
		 */
		Random gerador = new Random();
		int[] numeros = new int[qtdParaOrdenar];
	
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = gerador.nextInt(numerosTamanho);
		}
		
		/*
		 * ANTES DA ORDENAÇÂO:
		 * Imprimindo (de maneira opcional) os números da array (com uma ajuda visual para
		 * ajudar achar o número requisitado), para procurar o número manualmente.**
		 * 
		 * **Para imprimir os números, é necessário somente mudar o valor de displayNumberArray
		 * para true.
		 */
		if (displayNumberArray) printArray(numeros);
		
		/*
		 * Tentando fazer uma binary search em uma array que não está ordenada e imprimindo o resultado.
		 */
		System.out.println(utilStr(numeros, binarySearch(numeros, numeroParaAchar)));
		
		/*
		 * Ordenando a array para testar se o método de binary search vai funcionar com uma array ordenada.
		 */
		insertionSort(numeros);

		/* APÓS A ORDENAÇÃO:
		 * Imprimindo (de maneira opcional) a array de números.
		 */
		if (displayNumberArray) printArray(numeros);

		/*
		 * Fazendo a binary searchy em uma array ordenada.
		 */
		System.out.println(utilStr(numeros, binarySearch(numeros, numeroParaAchar)));
		
	}
	
	/*
	 * Método contendo o Algoritmo de Binary Search.
	 * 
	 * Recebendo uma array e um valor para achar na array.
	 * 
	 * O Algoritmo de Binary Search funciona pelo processo de separar a array em duas metades, então
	 * verificando em que metade o valor desejado deveria estar (também, se é o valor logo no meio
	 * da array).
	 * 
	 * O Algoritmo de Binary Search é eficiente, já que o algoritmo consegue descartar lugares onde
	 * o valor desejado não poderia estar. Para isso funcionar a array que o método vai receber deve
	 * estar ordenada, se não estiver poderão haver (e terão a grande maioria das vezes) alguns problemas.
	 */
	private static int binarySearch(int[] numeros, int valorDesejado) {
		
		/*
		 * Ponteiros para o valor mais baixo da array, o primeiro indíce (sendo analisado)
		 * e o valor mais alto da array, o último indíce (sendo analisado).
		 */
		int baixo = 0;
		int alto = numeros.length - 1;
		
		/*
		 * Já que o valor baixo fica maior e o valor alto fica menor na procura pelo valor desejado
		 * eles podem eventualmente se alcançar (e ir além na direção onde o outro deveria estar), se
		 * o valor baixo passar o valor alto, o valor desejado não pôde ser achado em nenhum lugar na
		 * array. Então o Método de Binary Search deveria retornar -1, que significa que o valor não foi
		 * encontrado dentro da array. 
		 */
		while(baixo <= alto) {
			/*
			 * Achando o meio da array e o valor do elemento na posição.
			 */
			int meioPos = (baixo + alto) / 2;
			int meioVal = numeros[meioPos];
			
			/*
			 * Verificando se o valor desejado é o valor do meio, maior que o valor do meio ou 
			 * menor que o valor do meio. Verificando o meio e as duas metades.
			 * 
			 * Se o valor desejado é o valor do meio, o método achou o valor desejado.
			 * Se o valor não está no meio, o método seleciona a array para verificar para
			 * ser menor, dependendo em qual metade o valor desejado deveria estar (assumindo
			 * que está na array).
			 */
			if(valorDesejado == meioVal) return meioPos;
			if(valorDesejado < meioVal) alto = meioPos - 1;
			else baixo = meioPos + 1;
		}
		
		/*
		 * Returnando -1 se o método falhar em achar o valor desejado.
		 */
		return -1;
	}
	
	/*
	 * Simples método para ordenação da array, usando o Algoritmo Insertion Sort.
	 * (que também pode ser encontrado nesse projeto).
	 */
	private static void insertionSort(int[] array) {
		for (int indice = 1; indice < array.length; indice++) {
			int currentValue = array[indice];
			int valorAnterior = indice - 1;
			while (valorAnterior >= 0 && array[valorAnterior] > currentValue) {
				array[valorAnterior + 1] = array[valorAnterior];
				valorAnterior--;
			}
			array[valorAnterior+1] = currentValue;
		}
	
	}
	
	
	/*
	 * Método para organizar o código.
	 * 
	 * Mostra se o Algoritmo de Binary Search funciona com uma arrey fora de ordem.
	 */
	private static String utilStr(int[] numeros, int bSearch) {
		
		String str1 = (estaOrdenada(numeros) ? "Resultado quando a array está ordenada: " : 
											   "Resultado quando a array NÃO está ordenada: ");

		String str2 = (bSearch == -1 ? "Nenhum valor foi achado. \n" : 
									   "Achado o valor (" + numeroParaAchar + ") em: " + bSearch + "\n" +
									   "numeros[" + bSearch +  "] = " + numeros[bSearch]);
		
		return str1 + "\n" + str2;
	}
	
	/*
	 * Método para verificar se a array está ordenada.
	 * 
	 * Recebendo uma array para verificar.
	 */
	private static boolean estaOrdenada(int[] array) {
		if ((array == null) || (array.length <= 1)) return true;
		for (int indice = 0; indice < array.length - 1; indice++) if (array[indice] > array[indice + 1]) return false;
		return true;
	}
	
	/*
	 * Método para imprimir uma array.
	 *
	 * Recebendo uma array para imprimir.
	 * 
	 * Mostra "numeroParaAchar" de uma maneira mais fácil (mesmo em uma grande array).
	 */
	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == numeroParaAchar) System.out.println();
			if (numbers[i] == numeroParaAchar) System.out.println("========");
			System.out.println(numbers[i]);
			if (numbers[i] == numeroParaAchar) System.out.println("========");
			if (numbers[i] == numeroParaAchar) System.out.println();
		}
		System.out.println();
	}
}
