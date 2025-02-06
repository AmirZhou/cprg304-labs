package exercise3.IntArrayAlgorithms;

public class IntArrayInsertionSort implements IntArrSortingAlgorithm{
	
	@Override
	public Integer[] sortDescending(Integer[] arr) {
		//  - for i = 0; i< length -1 ; i ++
		//  - temp = arr[t]
		//  - move arr[i..(t-1)] to right one slot
		//		- I can just copy the sub arr to the same array with a different starting index, 
		//		- and the same length (it's calculated as (r -l +1) )

		
		// 1. copy the original arr so that I don't modify it.
		int length = arr.length;
		Integer[] result = new Integer[length];
		
		// 2. loop
		for (int i = 0; i < length -1; i++ ) {
			Integer temp = result[i];
			int indexOfMax = i;
			
			// 2.1 Find the greatest in the remaining array and it's index
			for (int j = i + 1; j < length ; j++) {
				if (result[j] > temp) {
					temp = result[j];
					indexOfMax = j;
				}
			}

			// 2.2 move right one slot for the sub array
			System.arraycopy(result, i, result, i+1, indexOfMax - i);
		}
		
		// 3. return the result
		return result;
	}
	

}
