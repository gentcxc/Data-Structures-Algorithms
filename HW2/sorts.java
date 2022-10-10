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
				" Sort --Enter S \n*Insertion Sort --Enter I"
				+ "\n*Quick Sort     --Enter Q "
				+ "\n*Shell Sort     --Enter Shell ");
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
		if (chooseSort.equals("Shell"))
		{
			if (chooseSet.equals("Porder"))
			{
				ShellSort.shellsort(Porder);
				ShellSort.s_output(Porder);
			}
			if (chooseSet.equals("Prev"))
			{
				ShellSort.shellsort(Prev);
				ShellSort.s_output(Prev);
			}
			if (chooseSet.equals("Prand"))
			{
				ShellSort.shellsort(Prand);
				ShellSort.s_output(Prand);
			}
			if (chooseSet.equals("twoorder"))
			{
				ShellSort.shellsort(twoorder);
				ShellSort.s_output(twoorder);
			}
			if (chooseSet.equals("tworev"))
			{
				ShellSort.shellsort(tworev);
				ShellSort.s_output(tworev);
			}
			if (chooseSet.equals("tworand"))
			{
				ShellSort.shellsort(tworand);
				ShellSort.s_output(tworand);
			}
		}
		if (chooseSort.equals("Q"))
		{
			if (chooseSet.equals("Porder"))
			{
				QuickSort.quicksort(Porder, 0, Porder.length-1);
				QuickSort.output(Porder);
			}
			if (chooseSet.equals("Prev"))
			{
				QuickSort.quicksort(Prev, 0, Prev.length-1);
				QuickSort.output(Prev);
			}
			if (chooseSet.equals("Prand"))
			{
				QuickSort.quicksort(Prand, 0, Prand.length-1);
				QuickSort.output(Prand);
			}
			if (chooseSet.equals("twoorder"))
			{
				QuickSort.quicksort(twoorder, 0, twoorder.length-1);
				QuickSort.output(twoorder);
			}
			if (chooseSet.equals("tworev"))
			{
				QuickSort.quicksort(tworev, 0, tworev.length-1);
				QuickSort.output(tworev);
			}
			if (chooseSet.equals("tworand"))
			{
				QuickSort.quicksort(tworand, 0, tworand.length-1);
				QuickSort.output(tworand);
			}
		}
		if (chooseSort.equals("S"))
		{
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
		
		
	
	/*
	 * Sorting methods below.
	 *
	 *
	 *
	 */
	 public class ShellSort
	 {
		 static int s_comparison = 0, s_exchange = 0;
		 
		 public static int[] SegmentedInsertionSort(int[] A, int N, int H)
		 {
			 int current;
			 for (int i = H; i < N; i++)
			 {
				 current = A[i];
				 int j = i;
				 while (j > (H-1) && (A[j-H] > current))
				 {
					 s_comparison++;
					 A[j] = A[j-H];
					 j = j - H;
					 s_exchange++;
				 }
				 A[j] = current;
			 }
			return A;
		 }
		 
		 public static int[] shellsort(int[] A)
		 {
			 Scanner shellscan = new Scanner(System.in);
			 int N = A.length;
			 int H = (N/2);
			 //H=H/2 is a bad incremental sequence, allow
			 //it to be changed.
			 System.out.println("Assign different inc. sequence? Y/N");
			 String shellchoice = shellscan.nextLine();
			 if(shellchoice.equals("Y"))
			 {
				 System.out.println("Enter inc. sequence");
				 int shell_seq = shellscan.nextInt();
				 H = shell_seq;
			 }
			 else
			 {
				 N = A.length;
			 }
			 while (H > 0)
			 {
				 SegmentedInsertionSort(A, N, H);
				 H = (H/2);
			 }
			 return A;
			 
		 }
		 static void s_output(int[] a) 			
		 {
				System.out.println("comparisons: " + s_comparison);
				System.out.println("exchanges: " + s_exchange);
				System.out.println("Ordered File: \n");   //Print Sorted 
				for (int j = 0; j < a.length; j++)
						System.out.println(a[j]);
		 }
	 }	
	public class QuickSort
	{
		public static int comparison = 0, exchange = 0;
	
	    //Take last element in array as pivot, place it in correct
		//permanent position. Partition array into everything less
		//than pivot point, and everything greater than. Solving 
		//recursively.
	 static int partition(int [] arr, int low, int high)
	 {
		 int pivot = arr[high]; //Pivot = last element
	     int i = (low-1); // index of smaller element
	     for (int j = low; j <= (high - 1); j++) //increment through array
	     {
	         // If current element is smaller than or
	         // equal to pivot
	         if (arr[j] < pivot)
	         {
	             i++;
	             comparison++;
	             // swap arr[i] and arr[j]
	             //exchanging elements less than or equal to
	             //pivot value with lower points in array, creating
	             //the smaller partition
	             int temp = arr[i];
	             arr[i] = arr[j];
	             arr[j] = temp;
	             exchange++;
	            }
	     }
	 
	        // swap arr[i+1] and arr[high] (or pivot)
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	        exchange++;
	 
	        return i+1;
	    }
	 
	 static void quicksort(int [] arr, int low, int high)//sort recursively
	 {
	      if (low < high)
	      {
	            int pi = partition(arr, low, high);
	            quicksort(arr, low, pi - 1);
	            quicksort(arr, pi + 1, high);
	      }
	  }
	 
	    /*Printer for output eval etc.*/
	  static void output(int[] a) 			
	  {
			System.out.println("comparisons: " + comparison);
			System.out.println("exchanges: " + exchange);
			System.out.println("Ordered File: \n");   //Print Sorted 
			for (int j = 0; j < a.length; j++)
					System.out.println(a[j]);
	  }
	}
/*====================ELEMENTARY SORTS=============================================*/
	
	
	public static void SelectionSort(int[] arr)
	{
		int i, length = arr.length, 
				temp, exchanges = 0, comparisons = 0, min;
		
		for(i = 0; i != (length - 1); i++)
		{
			min = i;
			for(int j = i+1; j != length; j++)
			{
				comparisons++;
				if (arr[j] < arr[min])
				{
					min = j;
					
				}
			}
			//swaps values
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			exchanges++;
			
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
		int index, j, temp = 0, comparisons = 0, exchanges = 0;
		int length = arr.length;
		
		for (index = 0; index < length-1; index++)
			for(j = 0; j < (length - 1);j++)
			{
				comparisons++; //count comparisons
				if(arr[j] > arr[j+1]) 
				{
					temp = arr[j]; 			//swaps 
					arr[j] = arr[j+1]; 
					arr[j+1] = temp;
					exchanges++; //count swaps
				}
			}
		
		
		System.out.println("Bubble Sort: Number of exchanges: " +
				 exchanges);
		System.out.println("Bubble Sort: Number of Comparisons: " +
				 comparisons);
		System.out.println("Sorted file:");
		for (int printer = 0; printer <= arr.length - 1; printer++)
			System.out.println(arr[printer]);
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

/*==================================================================================
*/
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

}

