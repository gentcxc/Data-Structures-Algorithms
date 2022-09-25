/* CS 253 | Homework I | Problem 1
 * Author: Christiano Carta
 * Date: 09/14/2022
 * Implement Selection, Insertion, and Bubble sorting algorithms.
 * Perform analysis.
*/


package homework_i_fix;
import java.io.File;
import java.util.Scanner;


public class sorts 
{

	public static void main(String[] args) 
	{
		/*Initialize data from locally sourced .txt files
		 * Since the paths are local, the pathaways may need
		 * to be changed if the source code is being tested / ran
		 * on another machine.
		 */
		int Porder[] = readFiles("/home/christian/eclipse-workspace/homework_i_fix/dset1.txt");
		int Prev[] = readFiles("/home/christian/eclipse-workspace/homework_i_fix/dset1rev.txt");
		int Prand[] = readFiles("/home/christian/eclipse-workspace/homework_i_fix/dset1rand.txt");
		int twoorder[] = readFiles("/home/christian/eclipse-workspace/homework_i_fix/dset2korder.txt");
		int tworev[] = readFiles("/home/christian/eclipse-workspace/homework_i_fix/dset2kreverse.txt");
		int tworand[] = readFiles("/home/christian/eclipse-workspace/homework_i_fix/dset2krand1.txt");
		
		//Machine printed Input instruction
		System.out.println ("===================================="+
				"====================");
		System.out.println ("\nWhich Sorting Algorithm would you " +
					"like to use? \n\n" +
				"*Bubble Sort    --Enter B  \n*Selection" +
				" Sort --Enter S \n*Insertion Sort --Enter I");
		System.out.println ("===================================="+
				"====================");
		
		//Machine printed input instruction and scanning for 
		//Sorting method as well as dataset choice
		Scanner scanner = new Scanner(System.in);
		String chooseSort = scanner.nextLine();
		
		System.out.println ("===================================="+
				"====================");
		System.out.println("Choose Dataset \n");
		System.out.println("Prototypes (16 Element Integer Arrays)");
		System.out.println("	Ordered --Porder");
		System.out.println("	Reverse --Prev");
		System.out.println("	Random  --Prand\n");
		System.out.println("2000 Element Sets");
		System.out.println("	Ordered --twoorder");
		System.out.println("	Reverse --tworev");
		System.out.println("	Random  --tworand");
		System.out.println ("===================================="+
				"====================");
		
		String chooseSet = scanner.nextLine();
		
		
		/*If statements for output, not the most efficient
		 * or prettiest way to do it. Will improve in future.
		 * Fully aware it is objectively bad, but it does get 
		 * the job done correctly for now.
		 */
		
		if (chooseSort.equals("S"))
		{
			if (chooseSet.equals("Porder")) 
				SelectionSort(Porder);
			if (chooseSet.equals("Porder"))
				SelectionSort(Porder);
			if (chooseSet.equals("Prev"))
				SelectionSort(Prev);
			if (chooseSet.equals("Prand"))
				SelectionSort(Prand);
			if (chooseSet.equals("twoorder"))
				SelectionSort(twoorder);
			if (chooseSet.equals("tworev"))
				SelectionSort(tworev);
			if (chooseSet.equals("tworand"))
				SelectionSort(tworand);
		}
				
		else if (chooseSort.equals("I"))
		{
			if (chooseSet.equals("Porder"))
				InsertionSort(Porder);
			if (chooseSet.equals("Prev"))
				InsertionSort(Prev);
			if (chooseSet.equals("Prand"))
				InsertionSort(Prand);
			if (chooseSet.equals("twoorder"))
				InsertionSort(twoorder);
			if (chooseSet.equals("tworev"))
				InsertionSort(tworev);
			if (chooseSet.equals("tworand"))
				InsertionSort(tworand);
		}
		
		if (chooseSort.equals("B"))
		{
			if (chooseSet .equals("Porder"))
				BubbleSort(Porder);
			if (chooseSet.equals("Prev"))
				BubbleSort(Prev);
			if (chooseSet.equals("Prand"))
				BubbleSort(Prand);
			if (chooseSet.equals("twoorder"))
				BubbleSort(twoorder);
			if (chooseSet.equals("tworev"))
				BubbleSort(tworev);
			if (chooseSet.equals("tworand"))
				BubbleSort(tworand);
		}
	}
		
		
	//Reads file and returns an array
	public static int[] readFiles(String file)
	{
		try
		{
			File f = new File(file);
			Scanner s = new Scanner(f);
			int ctr = 0;
			while (s.hasNextInt()) 
			{
				ctr++;
				s.nextInt();
			}
			int[] arr = new int [ctr];
			Scanner s1 = new Scanner(f);
		
			for (int i = 0; i < arr.length; i++)
				arr[i] = s1.nextInt();
		
			return arr;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	/*
	 * Sorting methods below.
	 */
	public static void SelectionSort(int[] arr)
	{
		int i, length = arr.length, 
				exchanges = 0, comparisons =0;
		
		for(i = 0; i < length-1; i++)
		{
			comparisons++;
			int min = i;
			for(int j = i+1; j < length; j++)
				if (arr[j] < arr[min])
				{
					min = j;
					exchanges++;
				}
					
			
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			
		}
		//Empirical Analysis output
		System.out.println("Selection Sort: Number of exchanges: " +
		 exchanges);
		System.out.println("Selection Sort: Number of Comparisons: " +
		 comparisons);
		System.out.println("Sorted file:");
		for (int index = 0; index < arr.length; index++)
			System.out.println(arr[index]);
		System.out.println();
	}
	
	public static void BubbleSort(int [] arr) //array, arraylength
	{
		int i, j, temp = 0, comparisons = 0, exchanges = 0;
		int length = arr.length;
		for (i = 0; i < length; i++)
		{
			
			for(j = 1; j < (length - i);j++)
			{
				comparisons++; //count comparisons
				if(arr[j-1] > arr[j]) 
				{
					temp = arr[j-1]; 
					arr[j-1] = arr[j]; 
					arr[j] = temp;
					exchanges++; //count swaps
				}
			}
		}
		
		
		System.out.println("Bubble Sort: Number of exchanges: " +
				 exchanges);
		System.out.println("Bubble Sort: Number of Comparisons: " +
				 comparisons);
		System.out.println("Sorted file:");
		for (int index = 0; index < arr.length; index++)
			System.out.println(arr[index]);
		System.out.println();
		
	}
	
	public static void InsertionSort(int [] arr)
	{
		int length = arr.length, i, comparisons = 0, exchanges = 0;
		for (i = 1; i < length; i++)
		{
			int key = arr[i], j = i -1;
			while(j >= 0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j = j-1;
				comparisons++;
				exchanges++;
			}
			arr[j+1] = key;
			comparisons++;
			
		}
			
		System.out.println("Insertion Sort: Number of exchanges: " +
				 exchanges);
		System.out.println("Insertion Sort: Number of Comparisons: " +
				 comparisons);
		System.out.println("Sorted file:");
		for (int index = 0; index < arr.length; index++)
			System.out.println(arr[index]);
		System.out.println();
		
	}

}
