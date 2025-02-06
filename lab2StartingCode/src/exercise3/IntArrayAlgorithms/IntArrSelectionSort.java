package exercise3.IntArrayAlgorithms;

public class IntArrSelectionSort implements IntArrSortingAlgorithm {
	
	@Override
	public Integer[] sortDescending(Integer[] arr) {
		// copy the array for safety.
		int length = arr.length;
		Integer[] result = new Integer[length];
		System.arraycopy(arr, 0, result, 0, length);
		
		//loop over the result array, for each index, execute (findMaxIndex + swap), 
		// no need to do this for the last element
		for (int i = 0; i < length -1; i ++) {
			int maxIndex = findMaxIndexFrom(result, i);
			if (maxIndex != i) {
				swap(result, i, maxIndex);
			}
		}
		
		return result;
	}
	
	
	private int findMaxIndexFrom(Integer[] arr, int startingIndex) {
		// get the starting value as max and index for reference
		int maxIndex = startingIndex;
		
		// loop over and update the index and max if greater than current max
		for (int i = startingIndex; i < arr.length ; i++ ) {
			if (arr[i] > arr[maxIndex]) {
				maxIndex = i;
			}
		}
		
		// return the index 
		return maxIndex;
	}
	
	
	private void swap(Integer[] arr, int a, int b) {
		Integer temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
