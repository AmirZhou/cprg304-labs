package exercise3;
import java.util.List;
import java.util.ArrayList;
// should I make this class generic or should I make the static method generic?
// should I even consider generic? what benefits I got by doing so.
// If I were to implement a number of sorting algorithms, do I need to implement any interface
public class SelectionSort implements SortingAlgorithm {
	
	@Override()
	public <E extends Comparable<? super E>> List<E> sortDescending(List<E> input) {
		
		// how do I duplicate the initial input? 
			// - One option is addAll()
			// - Or use ArraryLits Constructor.
		ArrayList<E> result = new ArrayList<E>(input);
		
		
		for (int i = 0; i < result.size() ; i++) {
			
			// the following process should be looped, 
			// it should based on the current first index,
			// it should end when the current first index reach (size - 1)
			
			// find the largest index
			int largestIndex = findFirstLargestIndex(result);
			// swap it with the current first index. start with 0
			swap(result, i, largestIndex);
		}
		
		return result;
	}
	
	
	private <E> void swap(List<E> input, int a, int b) {
		// how do I get rid of this temp after I'm done with it? Will I save some space?
		E temp = input.get(b);
		input.set(b, input.get(a));
		input.set(a, temp);
	}
	
	private <E extends Comparable<? super E>> int findFirstLargestIndex(List<E> input) {
		// how to get an items index?
		int index = 0;
		E largest = input.get(0);
		for (int i = 1; i < input.size() - 1; i++) {
			if (input.get(i).compareTo(largest) > 0) {
				index = i;
				largest = input.get(i);
			}
		}
		return index;
	}
}

