package exercise2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 10;

	public static void main( String[] args ) {

		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();
		int randnum = rand.nextInt( UPPER_BOUND );
		nums[0] = randnum;
		System.out.println(nums[0]);
		for( int i = 1; i < SIZE; i++ ) {
			randnum = rand.nextInt( UPPER_BOUND );
			nums[i] = nums[i - 1] + randnum;
			System.out.println( nums[i] );
		}
		
		System.out.println("Numbers generated, type in your target number");
		try (Scanner scanner = new Scanner(System.in)) {
			int userInput = scanner.nextInt();
			System.out.println("Your target is " + userInput);
			int index = Driver.binarySearch(Arrays.asList(nums), userInput);
			if (index == -1) {
				System.out.println(userInput + " doesn't exist in the list");
			} else {				
				System.out.println("the result's index in the list is " + index);
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Incorrect input, type in an number instead");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("Exits the program");
		}
	}
	
	
	/**
	 * @param <E> this method should work for any type, as long as they can be compare? How I address this,because it seems
	 * if E isn't comparable, i may get runtime error.
	 * @param {@code list} the container List to search from
	 * @param {@code target} the target value to search in the list.
	 * @return the index of the target element if it exists. -1 if not exists.
	 * @example {@code int index = Driver.binarySearch(Arrays.asList(nums), userInput);
	 */
	public static <E extends Comparable<? super E>> int binarySearch(List<E> list, E target) {
		// find the index of high.
		int high = list.size() - 1;
		
		// delegate the mission to another overload.
		return binarySearch(list, target, 0, high);
	}
	
	private static <E extends Comparable<? super E>> int binarySearch(List<E> list, E target, int low, int high) {
		
		// How this method reach base case:
		// when (low == high), mid == low == high
		// in this case, if comp == 0, mid as an index will be returned,
		// if not, regardless which side the recursion is currently in, weather it be left side or right, the next recursion call's low and high parameter will make (low > high) == true, which is the base case 
		if (low > high) {
			return -1;
		}
		
		// compute the mid, and compare the value for mid using get(mid), because List<T> interface supports positional access
		int mid = low + (high - low) / 2;
		int comp = target.compareTo(list.get(mid));
		
		if (comp == 0) {
			return mid;
		} else if (comp < 0) {
			// recursively test the mid index in the left side
			return binarySearch(list, target, low, mid - 1);
		} else {
			// recursively search the target in the right side.
			return binarySearch(list, target, mid + 1, high);
		}	
	}
}
