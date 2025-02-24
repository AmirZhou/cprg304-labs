package exercise3;

import java.util.Random;
import java.util.Scanner;

import exercise3.IntArrayAlgorithms.*;
import exercise3.command.*;

public class Driver
{

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 1000;
	private static Approach approach;

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
		
		// retrieve and parse the args.
		
		String userOption = args[0].toLowerCase().trim();

		switch (userOption) {
			case "s":
				approach = Approach.SelectionSort;
				break;
			case "i":
				approach = Approach.InsertionSort;
				break;
			case "b":
				approach = Approach.BubbleSort;
				break;
			case "q":
				approach = Approach.QuickSort;
				break;
			default :
				approach = Approach.InsertionSort;
		}
		
		// build the command based on the argument.
		Command command = new SortDescCommand(nums, approach);
		
		// execute the command.
		command.execute();
		
		// display the result.
		System.out.println("Here's the result of " + approach.toString());
		for(int e : nums) {
			System.out.println(e);
		}
	}
	

}
