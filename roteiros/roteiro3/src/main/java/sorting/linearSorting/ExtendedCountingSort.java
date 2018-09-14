package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {
	
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && array != null){
			
			Integer minValue = min(array, leftIndex, rightIndex);
			removeNegatives(array, leftIndex, rightIndex, minValue);
			
			Integer counter[] = createCounterAndSum(array, leftIndex, rightIndex); 
			dicreaseCountAndSort(array, counter, leftIndex, rightIndex);
			
			addNegatives(array, leftIndex, rightIndex, minValue);
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

	private void removeNegatives(Integer[] array, int leftIndex, int rightIndex, Integer min){
		for(int i = leftIndex; i <= rightIndex; i++)
			array[i] -= min;
	}
	
	private void addNegatives(Integer[] array, int leftIndex, int rightIndex, Integer min){
		for (int i = leftIndex; i <= rightIndex; i++) {
            array[i] += min;
        }
	}
}
