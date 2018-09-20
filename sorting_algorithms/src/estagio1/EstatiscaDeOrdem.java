package estagio1;

import java.util.ArrayList;
import java.util.List;

public class EstatiscaDeOrdem {
	public static void main(String[] args) throws Exception {
		int array[] = {1,5,6,7,8,3};
		System.out.println(orderStatistics(array, 3));
	}
	
	public static int orderStatistics(int[] array, int k){
		int menor = min(array);
		int count = 1;
		while(count < k){
			menor = selecionaMenor(array, menor);
			count ++;
		}
		
		return menor;
	}
	
	public static int selecionaMenor(int[] array, int existente){
		List<Integer> maiores = new ArrayList<>();
		for(int i = 0; i < array.length; i++){
			if(array[i] > existente){
				maiores.add(array[i]);
			}
		}
		
		return min(maiores);
	}
	
	private static int min(List<Integer> maiores) {
		int min = maiores.get(0);
		for(int i = 1; i < maiores.size(); i++) {
			if(maiores.get(i) < min)
				min = maiores.get(i);
		}
		return min;
	}
	
	private static Integer min(int[] array) {
		Integer min = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < min)
				min = array[i];
		}
		return min;
	}
}
