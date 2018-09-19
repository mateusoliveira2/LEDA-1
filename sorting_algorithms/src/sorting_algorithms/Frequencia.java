package sorting_algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://tst-eda.splab.ufcg.edu.br/#!/app/activity/tabela_de_frequencia
 * @author Thayanne
 *
 */
class Frequencia {

	public static void main(String[] args) {
		int numbers[] = readNumbers();
		int count[] = new int[max(numbers) + 1];
		for(int i = 0; i < count.length; i++)
			count[i] = 0;
		
		for(int i = 0; i < numbers.length; i++)
			count[numbers[i]] ++;
		String output = "";
		for(int i = 0; i < numbers.length; i++){
			if(count[numbers[i]] != 0){
				output += numbers[i] + "," + count[numbers[i]] + " ";
				count[numbers[i]] = 0;
			}
		}
		
		System.out.println(output.substring(0, output.length() - 1));
		
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
	
	private static Integer max(int[] array) {
		Integer max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}
}
