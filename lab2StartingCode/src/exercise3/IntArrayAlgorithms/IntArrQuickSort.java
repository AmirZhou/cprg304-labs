package exercise3.IntArrayAlgorithms;

public class IntArrQuickSort implements IntArrSortingAlgorithm{
	
	@Override
	public Integer[] sortDescending(Integer[] arr) {
		Integer[] result = arr.clone();
		
		// a pivot point, to the left all greater than the pivot, to the right everything less than the pivot
		
		// QA1: How did you find the first pivot point?
		// 		Does this involve find the min or max?
		//     
		
		return result;
	}
	
	private int findePivotIndex(int l, int r) {
		return (l - r) / 2;
	}
	
	
	private void quickSortInRange(Integer[] arr, int l, int r) {
		
		// base case here
		if (l == r) return;
		
		// do the calculation and give me back the pivot index.
		int pivotIndex;
		
		// recursive apply the left part
		if (pivotIndex != l) {
			quickSortInRange(arr, l, pivotIndex -1);
		}
		
		// recursively apply to the right part
		if (pivotIndex != r) {
			quickSortInRange(arr, pivotIndex + 1, r);
		}
	}
}
