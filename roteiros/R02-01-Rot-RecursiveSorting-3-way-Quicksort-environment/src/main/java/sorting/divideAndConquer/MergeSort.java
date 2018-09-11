package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int middle = (leftIndex + rightIndex) / 2;
			
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, rightIndex);
		}
	}
	
	private void merge(T[] array, int leftIndex, int rightIndex){
		T[] aux = Arrays.copyOfRange(array, leftIndex, rightIndex + 1);
		
		int lenght = rightIndex - leftIndex;
		int middle = lenght / 2;
		
		int i = 0;
		int j = middle + 1;
		int currentIndex = leftIndex;
		
		while(i <= middle && j <= lenght){
			if(aux[i].compareTo(aux[j]) > 0){
				array[currentIndex] = aux[j];
				j ++;
			}
			else{
				array[currentIndex] = aux[i];
				i ++;
			}
			
			currentIndex ++;
		}
		
		// add any values that's left on auxiliar array
		while (i <= middle){
			array[currentIndex] = aux[i];
			i ++;
			currentIndex ++;
		}
		
		while (j <= lenght){
			array[currentIndex] = aux[j];
			j ++;
			currentIndex ++;
		}
	}
}
