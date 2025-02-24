package exercise3.IntArrayAlgorithms;


/**
 * @author Yue (Amir) Zhou
 * 
 * An implementation of quick sort using hoare's partition.
 */
public class IntArrQuickSort implements IntArrSortingAlgorithm{
	
	@Override
	public Integer[] sortDescending(Integer[] arr) {
		Integer[] result = arr.clone();
		quickSort(result);
		return result;
	}
	
	public void quickSort(Integer[] arr) {
		quickSort(arr, 0, arr.length -1);
	}
	
	public void quickSort(Integer[] arr, int l, int r) {
		
		if (r > l) {
			int m = hoarePartition(arr, l, r);
			quickSort(arr, l, m);
			quickSort(arr, m + 1, r);
		}
	}
	
	
	private int hoarePartition(Integer[] arr, int l, int r) {
		
		int i = l;
		int j = r;
		
		// select a pivot, it can be anything
		int pivot = arr[(r-l)/2 + l];
		
		
		while (true) {
			
			// find an element that may need to be swapped.
			while (arr[i] > pivot) {
				i ++;
			}
			
			// find another element that may need to be swapped.
			while (arr[j] < pivot) {
				j --;
			}
		
			// swap only if j didn't reach i, other wise return j immediately without swap.
			if (j <= i) {
				return j;
			}
			
			
			// swap
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		
			// after the swap, move both indexer forward by 1.
			i ++;
			j --;
			
		}
	}
}
