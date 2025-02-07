package exercise3.IntArrayAlgorithms;

public class IntArrBubbleSort implements IntArrSortingAlgorithm{
	
	@Override
	public Integer[] sortDescending(Integer[] arr) {
		Integer[] result = arr.clone();
	
		for (int i = result.length - 1; i > 0; i-- ) {
			
			for (int j = 0; j < i; j ++) {
				Integer temp = result[j+1];
				if (result[j] < result[j+1]) {
					result[j+1] = result[j];
					result[j] = temp;
				}
			}
		}
		
		return result;
	}
}
