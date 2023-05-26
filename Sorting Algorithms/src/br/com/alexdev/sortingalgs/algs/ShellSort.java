package br.com.alexdev.sortingalgs.algs;

import java.util.Random;

public class ShellSort {
	
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
		shellSort(numeros);
		
		
		/*
		 * Exibindo os números, após a ordenação.
		 */
		System.out.println("\nDepois: ");
		imprimeArray(numeros);
	
	}
	
	/*
	 * Shellsort é uma generalização (optmização) do algoritmo insertion sort.
	 * 
	 * Usando o algoritmo insertion sort e tendo uma array como:
	 * [3, 4, 10, 6, 7, 2]
	 * Como os três primeiros elementos da array (3, 4, 10) já estão em ordem, o próximo passo
	 * do processo seria trocar 10 e 6, para ordenar os primeiros quatro elementos da array, deixando 
	 * a array como:
	 * the array as:
	 * [3, 4, 6, 10, 7, 2]
	 * O próximo passo vai ser trocar 10 e 7 resultando em:
	 * [3, 4, 6, 7, 10, 2]
	 * Agora a sub-array ordenada é feita dos cinco primeiros elementos da array, deixando somente um
	 * para ser ordenadao (2, no fim da array). É notável que, 2 sendo o menor número deveria ir no
	 * começo da array.
	 * Se o algoritmo insertion sort fosse para ser aplicado, 5 mais trocas teriam de acontecer:
	 * 
	 * Partindo de -> [3, 4, 6, 7, 10, 2]
	 * 
	 * 1 - troca 2 e 10 -> [3, 4, 6, 7, 2, 10]
	 * 2 - troca 2 e 7  -> [3, 4, 6, 2, 7, 10]
	 * 3 - troca 2 e 6  -> [3, 4, 2, 6, 7, 10]
	 * 4 - troca 2 e 4  -> [3, 2, 4, 6, 7, 10]
	 * 5 - troca 2 e 3  -> [2, 3, 4, 6, 7, 10]
	 * 
	 * Ponto final (array ordenada) -> [2, 3, 4, 6, 7, 10]
	 * 
	 * Fazendo um total de 7 trocas.
	 * 
	 * Se no começo houvesse uma troca entre 10 e 2:
	 * De [3, 4, 10, 6, 7, 2], para [3, 4, 2, 6, 7, 10]
	 * 
	 * Só seriam necessárias mais duas trocas:
	 * 
	 * Ponto inicial -> [3, 4, 2, 6, 7, 10]
	 * 
	 * 1 - troca 2 e 4 -> [3, 2, 4, 6, 7, 10]
	 * 2 - troca 2 e 3 -> [2, 3, 4, 6, 7, 10]
	 *
	 * Ponto final (array ordenada) -> [2, 3, 4, 6, 7, 10]
	 * 
	 * Fazendo um total de 3 trocas.
	 * 
	 * A optimização funciona ordenando (trocando, de forma ordenada) elementos em diferentes
	 * distâncias (entre si), fazendo trocas mais efetivas.
	 * 
	 * TL;DR: Shellsort é basicamente Insertion Sort, mas melhor.
	 */
	private static void shellSort(int[] numbers) {
		/*
		 * Quando comparando números que deveriam ser trocados primeiro, é necessário que
		 * se obtenha a distância eles. Já que cada elemento e o elemento na distância entre
		 * ele (com o valor da distância) serão trocados (*ordenadamente). Usando uma distância
		 * inicial de metade do tamanho da array é a melhor forma de o fazer.
		 * 
		 * Depois de ordenar cada elemento com o elemento à uma certa distância, a distância pode
		 * ser dividida por 2, já que a distância necessária para fazer boas trocas diminui.
		 * 
		 * Quando a distância chega à 1, a que ordenação vai acontecer, vai ser somente uma insertion sort.
		 */
		for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
			/*
			 * O algoritmo de insertion sort aqui possui algumas pequenas alterações para funcionar com
			 * o sistema de distâncias. Ao invés de começar no primeiro elemento da array, é possível começar
			 * com o valor da distância (já que o valor vai diminuir e alcançar 1).
			 * 
			 * E os números sendo comparados, são relativos ao valor da distância (e não 1, como é no insertion
			 * sort).
			 */
			for (int index = gap; index < numbers.length; index++) {
				int protectedIndex = index;
				while (protectedIndex >= gap && numbers[protectedIndex] - numbers[protectedIndex - gap] < 0) {
					troca(numbers, protectedIndex, (protectedIndex-gap));
					protectedIndex-=gap;
				}
			}
		}
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
