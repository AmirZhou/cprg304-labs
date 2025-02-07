package exercise3;

import java.util.Random;
import java.util.Scanner;

import exercise3.IntArrayAlgorithms.*;
import exercise3.command.*;

public class Driver
{

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 1000;
	private static final Scanner scanner = new Scanner(System.in);
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
		
		System.out.println("Select a sorting method");
		System.out.println("1: Selection Sort \n");
		System.out.println("2: Insertion Sort \n");
		
		int userOption = Integer.parseInt(scanner.nextLine().trim());
		
		switch (userOption) {
			case 1:
				approach = Approach.SelectionSort;
				break;
			case 2:
				approach = Approach.InsertionSort;
				break;
			default :
				approach = Approach.InsertionSort;
		}
		
		Command command = new SortDescCommand(nums, approach);
		command.execute();
		
		System.out.println("Here's the result by " + approach.toString());
		for(int e : nums) {
			System.out.println(e);
		}
	}
	

}
