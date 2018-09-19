package sorting_algorithms;

import java.util.Scanner;
/**
 * http://tst-eda.splab.ufcg.edu.br/#!/app/activity/estatistica_de_ordem
 * @author Thayanne
 *
 */
class EstatiscaDeOrdemTst {
	public static void main(String[] args) throws Exception {
		int array[] = readNumbers();
		System.out.println(particiona(array));
	}
	
	public static int particiona(int[] array){
		int pivot = array[0];
		int wall = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] < pivot){
				swap(array, wall, i);
				wall ++;
			}
		}
		return wall + 1;
	}
	
	private static int[] readNumbers(){
		Scanner in = new Scanner(System.in); 
		String input = in.nextLine();
		String[] numbersStr = input.split(" ");
		int[] numbers = new int[numbersStr.length];

		for(int i = 0; i < numbersStr.length; i++){
			numbers[i] = Integer.parseInt(numbersStr[i]);
		}
		
		return numbers;
	}
	
	public static void swap(int[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
