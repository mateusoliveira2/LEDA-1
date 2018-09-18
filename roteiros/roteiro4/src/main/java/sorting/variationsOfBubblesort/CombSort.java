package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex && array != null && leftIndex >= 0 && rightIndex >= 0 && rightIndex < array.length) {
			int size = (rightIndex - leftIndex) + 1;
			int gap = size;
			boolean sorted = false;
			
			while (gap != 1 || sorted == false) {
				gap = getNextGap(gap);
				sorted = true;
				
				for(int i = leftIndex; i + gap <= rightIndex; i ++){
					if(array[i].compareTo(array[gap + i]) > 0) {
						Util.swap(array, i , gap + i);
						sorted = false;
					}
				}
			}
		}
	}
	
	private int getNextGap(int gap) {
		gap = (gap * 10) / 13;
		
		if(gap < 1)
			gap = 1;
		
		return gap;
	}
}
