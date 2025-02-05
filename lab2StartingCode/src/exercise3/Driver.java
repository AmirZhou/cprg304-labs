package exercise3;

import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class Driver
{

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 1000;

	public static void main( String[] args )
	{

		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();

		for( int i = 0; i < SIZE; i++ )
		{
			nums[i] = rand.nextInt( UPPER_BOUND );
			System.out.println( nums[i] );
		}
		
		// My code starts here
		
		System.out.println("Here's the result");
		
		List<Integer> result = sortDescendent(Arrays.asList(nums));
		
		for (int e: result) {
			System.out.println(e);
		}
	}
	
	private static <E extends Comparable<? super E>> List<E> sortDescendent(List<E> input) {
		// Is there any problem this static method create an instance?
		SortingAlgorithm sorter = new SelectionSort();
		return sorter.sortDescending(input);
	}
}
