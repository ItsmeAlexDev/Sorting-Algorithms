package br.com.alexdev.sortingalgs.algs;

import java.util.Random;

public class QuickSort {
	
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
		quickSort(numeros);
		
		
		/*
		 * Exibindo os números, após a ordenação.
		 */
		System.out.println("\nDepois: ");
		imprimeArray(numeros);
	
	}
	
	/*
	 * Usando overloading para fazer um método mais "limpo"
	 * chamando o método "real", com os parametros necessários.
	 * 
	 * O único uso do método "limpo" é chamar o "verdadeiro" método.
	 */
	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	/*
	 * Método contendo o algoritmo de ordenação.
	 * 
	 * Recebendo uma array para ordenar, um indice baixo e um indice alto.
	 * 
	 * Os indices são usados para decidir qual partição da array "numeros"
	 * ordenar. Permitindo o uso de recursão, pela separação de diferentes 
	 * partições usadas no algoritmo quicksort.
	 */
	
	private static void quickSort(int[] numeros, int indiceBaixo, int indiceAlto) {
		
		/*
		 * Se a array de números à ordenar, possui
		 * somente um elemento, a array já está ordenada.
		 * 
		 * Usado na recursão, já que não há sentido em ordenar
		 * uma array de 1 elemento.
		 */
		if (indiceBaixo >= indiceAlto) return;
		
		/*
		 * Selecionando um ponto para ser usado no método de ordenação.
		 * 
		 * Usando um número aleatório (ao invés de sempre usar o último)
		 * o algoritmo perfome levemente melhor.
		 */
		int indicePivo = new Random().nextInt(indiceAlto - indiceBaixo) + indiceBaixo;
		int pivo = numeros[indicePivo];
		troca(numeros, indicePivo, indiceAlto);
		
		/*
		 * Criando 2 ponteiros para serem usados no algoritmo,
		 * eles "andam" na direção do pivô.
		 */
		int ponteiroA = indiceBaixo;
		int ponteiroB = indiceAlto;
		
		/*
		 * Criando um while loop que prossegue, se os ponteiros ainda não
		 * alcançaram o pivô.
		 */
		while (ponteiroA < ponteiroB) {
			
			/*
			 * Andando o ponteiro da esquerda na direção do pivô, parando caso
			 * o ponteiro encontre um número maior que o pivô.
			 */
			while (numeros[ponteiroA] <= pivo && ponteiroA < ponteiroB) {
				ponteiroA++;
			}
			
			/*
			 * Andando o ponteiro da direita na direção do pivô, parando caso
			 * o ponteiro encontre um número menor que o pivô.
			 */
			while (numeros[ponteiroB] >= pivo && ponteiroA < ponteiroB) {
				ponteiroB--;
			}
			
			/*
			 * Trocando os números nos ponteiros da direita e da esquerda.
			 * 
			 * A troca vai colocar os números maiores que o pivô, após o pivô
			 * e os números menores que o pivô antes dele.
			 */
			troca(numeros, ponteiroA, ponteiroB);
			
		}
		
		/*
		 * Se de algum modo o número a esquerda do ponteiro é maior do que
		 * o último da array (que pode acontecer, causado pelo modo que o
		 * pivô é selecionado) isso pode causar alguns erros, que são
		 * corrigidos aqui.
		 */
		if(numeros[ponteiroA] > numeros[indiceAlto]) {
			/*
			 * Os erros possíveis causados podem ser corrigidos por só trocar o número
			 * no ponteiro esquerdo com o último da array.
			 */
			troca(numeros, ponteiroA, indiceAlto);
		} else {
			/*
			 * Se o erro não acontece o algoritmo pode prosseguir normalmente.
			 * 
			 * A seleção do ponteiro da esquerda com o valor do último número da array
			 * é usada na recursão.
			 */
			ponteiroA = indiceAlto;
		}
		
		
		/*
		 * Usando o método quicksort para ordenar as partições antes e depois do
		 * pivô (que já está ordenado), usando recursão.
		 */
		quickSort(numeros, indiceBaixo, ponteiroA-1);
		quickSort(numeros, ponteiroA+1, indiceAlto);
		
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
