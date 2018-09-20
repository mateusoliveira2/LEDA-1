package sorting_algorithms;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		InsertionBinarySearch sort = new InsertionBinarySearch();
		
		int[] a = {4,3,1,2,1};
		
		sort.insertionSort(a);
		System.out.println(Arrays.toString(a));
	}

}
