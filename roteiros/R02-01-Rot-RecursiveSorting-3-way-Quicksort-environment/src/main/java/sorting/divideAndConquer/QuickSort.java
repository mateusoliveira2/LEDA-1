package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && array != null && leftIndex >= 0){
			int p = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, p - 1);
			sort(array, p + 1, rightIndex);
		}
	}
	
	private int partition(T[] array, int leftIndex, int rightIndex){
		T pivot = array[rightIndex];
		int wall = leftIndex;
		
		for(int i = leftIndex ; i < rightIndex;  i++){
			if(array[i].compareTo(pivot) <= 0){
				Util.swap(array, wall, i);
				wall ++;
			}
		}
		
		Util.swap(array, wall, rightIndex);
		
		return wall;
	}
}
