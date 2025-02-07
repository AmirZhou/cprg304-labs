package exercise3.command;

import exercise3.IntArrayAlgorithms.*;

public class SortDescCommand implements Command {
	
	private final Integer[] arr;
	private final IntArrSortingAlgorithm sorter;
	
	@Override
	public void execute() {
		Integer[] sortedArray = sorter.sortDescending(arr);
		System.arraycopy(sortedArray, 0, arr, 0, arr.length);
	}
	
	public SortDescCommand(Integer[] arr, Approach approach) {
		switch(approach) {
			case Approach.SelectionSort:
				this.sorter = new IntArrSelectionSort();
				break;
			
			case Approach.InsertionSort:
				this.sorter = new IntArrayInsertionSort();
				break;
			
			case Approach.BubbleSort:
				this.sorter = new IntArrBubbleSort();
				break;
			default :
				this.sorter = null;
		}
		this.arr = arr;
	}
	
}
