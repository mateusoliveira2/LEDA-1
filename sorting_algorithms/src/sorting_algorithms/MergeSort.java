package sorting_algorithms;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int middle = (rightIndex + leftIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);	
			merge(array, leftIndex, rightIndex);
		}
		
	}
	
	public void merge(T[] array, int leftIndex, int rightIndex){
		T[] aux = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		int middle = (rightIndex - leftIndex) / 2;
		int i = 0, j = middle + 1, current = leftIndex;

		while(i <= middle && j <= (rightIndex - leftIndex)){
			if(aux[i].compareTo(aux[j]) > 0){
				array[current] = aux[j];
				j ++;
			} else {
				array[current] = aux[i];
				i ++;
			}
			
			current ++;
		}
		
		// add any values that's left on auxiliar array
		while (i <= middle){
			array[current] = aux[i];
			i ++;
			current ++;
		}
		
		while (j <= (rightIndex - leftIndex)){
			array[current] = aux[j];
			j ++;
			current ++;
		}
		
		
		
		
	}

}
