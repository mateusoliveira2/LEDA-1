package sorting_algorithms;

public class InsertionBinarySearch {
	
	public void insertionSort(int arr[]){
		int loc, j, k;
		int selected;
		for(int i = 1; i < arr.length; i++){
			j = i - 1;
			selected = arr[i];
			loc = binarySearch(arr, 0, j, selected);
			
			while(j >= loc){
				arr[j + 1] = arr[j];
				j --;
			}
			arr[j+1] = selected;
		}
	}
	public int binarySearch(int arr[], int l, int r, int x){
		if(r <= l){
			if(x > arr[l])
				return l + 1;
			else 
				return l;
		}
			
		int mid = l + (r - 1) / 2;
		
		if(arr[mid] == x){
			return x;
		}
		
		if(x < arr[mid])
			return binarySearch(arr, l, mid - 1, x);
		
		return binarySearch(arr, mid + 1, r, x);
		
		
	}
}
