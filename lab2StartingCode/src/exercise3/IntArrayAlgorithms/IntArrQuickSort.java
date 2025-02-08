package exercise3.IntArrayAlgorithms;

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
		
		int pivot = arr[(r-l)/2 + l];
		
		while (true) {
				
			while (arr[i] > pivot) {
				i ++;
			}
			
			while (arr[j] < pivot) {
				j --;
			}
		
		// swap and i++ j--
			if (j <= i) {
				return j;
			}
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		
			
			i ++;
			j --;
			
		}
	}
}
