package sorting_algorithms;

public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T>  {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int m = this.partition(array, leftIndex, rightIndex);
			this.sort(array, leftIndex, m-1);
			this.sort(array, m+1, rightIndex);
		}
	}

	private int partition(T[] array, int left, int right) {
		T pivot = array[left];
		int m = left;
		for (int i = left+1; i <= right; i++) {
			if (array[i].compareTo(pivot) <= 0) {
				m++;
				this.swap(array, i, m);
			}
		}
		this.swap(array, m, left);
		return m;
	}
	
	public void swap(T[] array, int i, int j) {
		T res = array[i];
		array[i] = array[j];
		array[j] = res;
	}
}