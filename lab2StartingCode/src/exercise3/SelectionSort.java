package exercise3;
import java.util.List;
import java.util.ArrayList;
// should I make this class generic or should I make the static method generic?
// should I even consider generic? what benefits I got by doing so.
// If I were to implement a number of sorting algorithms, do I need to implement any interface?
public class SelectionSort implements SortingAlgorithm {
	
	@Override()
	public <E extends Comparable<? super E>> List<E> sortDescending(List<E> input) {
		
		// how do I duplicate the initial input? 
			// - One option is addAll()
			// - Or use ArraryLits Constructor.
		ArrayList<E> result = new ArrayList<E>(input);
		
		// i should move the size() call out for the for loop
		for (int i = 0; i < result.size() ; i++) {
			
			int largestIndex = findIndexOfMaxFrom(result, i);
			// swap it with the current first index. start with 0
			swap(result, i, largestIndex);
		}
		
		return result;
	}
	
	private <E> void swap(List<E> input, int a, int b) {
		E temp = input.get(b);
		
		input.set(b, input.get(a));
		input.set(a, temp);
	}
	
	private <E extends Comparable<? super E>> int findIndexOfMaxFrom(List<E> input, int startingIndex) {
		int index = startingIndex;
		
		E largest = input.get(startingIndex);
		for (int i = index; i < input.size() ; i++) {
			if (input.get(i).compareTo(largest) > 0) {
				index = i;
				largest = input.get(i);
			}
		}
		return index;
	}
}

