/* CS 253 | Homework I | Problem 2
 * Author: Christiano Carta
 * Date: 09/14/2022
 * 
 * Implementation of recursive binary search, recursive factorial, and recursive
 * 		fibonacci.
 * 
 * Note: Using variables of type "int", this will lead to problems in scenarios such
 * 		as large factorial numbers which can and will exceed a 32-bit limit.
 */

package homework_i;

public class recursion
{

	public static int Nfactorial(int n)
	{
		if(n <= 1)
			return 1;

		return (n * (Nfactorial(n-1)));
	}
	
	public static int Nfibonacci(int n)
	{
		if( n < 1)
			return 0;
		if( n == 1)
			return 1;
		
		return ((Nfibonacci(n-1)) + (Nfibonacci(n-2)));
	}
	
	
	public static int binarysearch(int arr[], int find, int low, int high)
	{
		int mid = ((low + high) / 2);
		
		if (find == arr[mid])
			return mid;
		
		else if (find > arr[mid])
			return binarysearch(arr, find, (low + 1), high);
		
		else
			return binarysearch(arr, find, (low - 1), high);
	}
	
	
	
	public static void main(String[] args)
	{
		//Initialize array, and values for binary search.
		
		int arr[] = {0,4,8,16,20,24,28,32,36,40,44,48,52,56,60,64};
		int arrayhigh = arr.length;
		int arraylow = 0;
		int arbitraryfindvalue = 64;
		
		
		//Console Printing results for visuals, and checking.
		
		System.out.println(binarysearch(arr, arbitraryfindvalue, arraylow, arrayhigh));
		System.out.println(Nfactorial(7));
		System.out.println(Nfibonacci(8));	
	}

}

