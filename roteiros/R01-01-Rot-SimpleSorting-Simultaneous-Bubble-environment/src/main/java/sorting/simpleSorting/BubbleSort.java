package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
	/**
	 * 
	 * @param array - The one who starts our pain
	 * @param leftIndex - The starting point
	 * @param rightIndex - The final point
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		// avoiding cases that causes an error on the algorithm
		if (!(array.length == 0 || rightIndex > array.length 
				|| leftIndex < 0 || leftIndex > rightIndex )) {
			
			boolean ordered = false;
			while(!ordered){
				ordered = true;
				for (int j = leftIndex; j < rightIndex; j++) {
					if (array[j].compareTo(array[j + 1]) > 0){
						Util.swap(array, j, j + 1);
						ordered = false;
					}
				}
			}
		}
	}
}
