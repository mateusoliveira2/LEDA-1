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
		Integer counter[] = countOcorrences(array, leftIndex, rightIndex);
		Integer output[] = Arrays.copyOf(array, array.length);
		
        for (int i = 1; i < counter.length; i++) 
        	counter[i] += counter[i-1];
       
        for (int i = leftIndex; i < rightIndex; ++i) { 
            output[counter[array[i]]-1] = array[i]; 
            counter[array[i]] --; 
        } 
        
        // Copy the output array to arr, so that arr now 
        // contains sorted characters 
        for (int i = leftIndex; i < rightIndex; i++) 
            array[i] = output[i]; 
        
	}
	
	private Integer[] countOcorrences(Integer[] array, int leftIndex, int rightIndex) {
		Integer count[] = new Integer[max(array, leftIndex, rightIndex)];
		initArrayZeros(count);
		
		for(int i = leftIndex; i < rightIndex; i ++) {
			count[array[i]] ++;
		}
		
		return count;
	}
	
	private void initArrayZeros(Integer[] array) {
		for(int i = 0; i < array.length; i++) 
			array[i] = 0;
		
	}
	
	private Integer max(Integer[] array, int leftIndex, int rightIndex) {
		Integer max = array[leftIndex];
		for(int i = leftIndex + 1; i <= rightIndex; i++) {
			if(array[i] > max)
				max = array[i];
		}
		return max;
	}

}
