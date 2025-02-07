package exercise3.IntArrayAlgorithms;

public class IntArrayInsertionSort implements IntArrSortingAlgorithm{
	
	@Override
	public Integer[] sortDescending(Integer[] arr) {
		Integer[] result = arr.clone();
		
		for (int i = 1; i < result.length; i++ ) {
			Integer temp = result[i];
			
			int j = i -1;
			while( j >= 0 && result[j] < temp) {
				result[j+1] = result[j];
				j--;
			}
			result[j+1] = temp;
		}

		return result;
	}

}
