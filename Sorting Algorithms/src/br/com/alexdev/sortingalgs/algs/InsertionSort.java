package br.com.alexdev.sortingalgs.algs;

import java.util.Random;

public class InsertionSort {

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
		insertionSort(numeros);
		
		
		/*
		 * Exibindo os números, após a ordenação.
		 */
		System.out.println("\nDepois: ");
		imprimeArray(numeros);
	
	}
	
	/*
	 * Método contendo o algoritmo de ordenação.
	 * 
	 * Recebendo uma array de números para ordenar.
	 * 
	 * A array é ordenada pelo processo de colocar cada elemento na ordem que
	 * deveriam estar, um de cada vez. Exemplo:
	 * 
	 * -tendo uma array que parece com essa: 2, 8, 5, 7, 9.
	 * -você pode pegar o primeiro número e colocar dentro da "nova"* array (ordenada).
	 * então agora a array ordenada se parece com essa: 2.
	 * -depois disso, você pode pegar o próximo número, que é 8, que vai depois de 2,
	 * então agora a array ordenada se parece com essa: 2, 8.
	 * -depois disso, você pode pegar o próximo número, que é 5, que vai entre 2 e 8,
	 * então agora a array ordenada se parece com essa: 2, 5, 8.
	 * -você pode ir desse modo até o último elemento, e depois do último elemento ser
	 * colocado em seu lugar, a array vai estar ordenada.
	 * 
	 * *a "nova" array pode ser a array que está sendo ordenada, não uma outra nova
	 * array, fica mais fácil de entender mais a frente.
	 * 
	 * TL;DR: coloca cada elemento no seu lugar certo e a array vai estar ordenada.
	 */
	private static void insertionSort(int[] array) {
		
		
		/*
		 * O modo que vou fazer o algoritmo é por tendo o número que está sendo
		 * colocado em seu lugar correto atualmente, verificar se o número anterior é maior ou menor.
		 * 
		 * Se for mener, então, o número atual deve estar no lugar correto.
		 * Se for maior, então, o número atual deve ir pro lugar do número anterior.
		 * 
		 * Repetindo isso vezes o suficiente, para cada elemento em uma array, a array deve ficar ordenada.
		 */
		for (int indice = 1; indice < array.length; indice++) {
			/*
			 * Indo por cada número e pegando o valor atual.
			 */
			int valorAtual = array[indice];
			
			/*
			 * Criando uma variável temporária para o número antes do valor atual.
			 */
			int anteriorAtual = indice - 1;
			
			/*
			 * O while loop prossegue se "anteriorAtual" não atingiu o começo da array (onde "anteriorAtual"
			 * seria -1) E o número na posição "anteriorAtual" da array é maior que o valor atual sendo colocado
			 * no seu lugar.
			 * 
			 * Se o valor atual é menor que o anterior, então o valor anterior ao atual fica na posição do valor atual,
			 * e o valor anterior é diminuido por 1, então o número sendo verificado é o anterior ao que mudou de posição.
			 * 
			 * O ciclo se repete até um número menor que o atual seja alcançado ou que o começo da array seja alcançado.
			 */
			while (anteriorAtual >= 0 && array[anteriorAtual] > valorAtual) {
				array[anteriorAtual + 1] = array[anteriorAtual];
				anteriorAtual--;
			}

			/*
			 * Quando o ciclo termina, você pode colocar o valor atual na frente do valor antes do atual, que
			 * deve ser seu lugar correto.
			 */
			array[anteriorAtual+1] = valorAtual;
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
