package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {
	
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && array != null 
				&& min(array, leftIndex, rightIndex) >= 0){
			
			Integer counter[] = createCounterAndSum(array, leftIndex, rightIndex); 
			dicreaseCountAndSort(array, counter, leftIndex, rightIndex);
		}
	}
	
	private Integer[] createCounterAndSum(Integer[] array, int leftIndex, int rightIndex){
		Integer count[] = new Integer[max(array, leftIndex, rightIndex) + 1];
        Arrays.fill(count, 0);
        
		for(int i = leftIndex; i <= rightIndex; i ++)
			count[array[i]] ++;
		
		// accumulative sum
		for(int i = 1; i < count.length; i++)
			count[i] += count[i - 1];
		
		return count;
	}
	
	private void dicreaseCountAndSort(Integer[] array, Integer[] count, int leftIndex, int rightIndex){
		
		Integer output[] = new Integer[(rightIndex - leftIndex) + 1] ;
		for(int i = leftIndex; i <= rightIndex; i++){
			output[count[array[i]]-1] = array[i];
			count[array[i]] --;
		}
		
		// Copy output to array in the specified range
        System.arraycopy(output, 0, array, leftIndex, (rightIndex - leftIndex) + 1);
	}
	
	
	private Integer max(Integer[] array, int leftIndex, int rightIndex) {
		Integer max = array[leftIndex];
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}
	
	private Integer min(Integer[] array, int leftIndex, int rightIndex) {
		Integer min = array[leftIndex];
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i] < min)
				min = array[i];
		}
		return min;
	}
	
}
