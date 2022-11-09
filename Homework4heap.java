package hw3;

public class Homework4heap
{
	public static void main(String[] args)
	{
		

	}
	public static int heapexchange = 0;
	public static int heapcompare  = 0;
	
	public void heapsort(int arr[])
	{
		int n = arr.length;
		
		for (int i = ((n/2)-1); i >= 0; i--)
			heapify(arr, n, i);
	}
	 
	void heapify(int arr[], int n, int i)	//arr, SOH, index
	{
		int largest = i;					//initialize largest root,
		int lc 		= ((2*i)+1);					//respective expressions are
		int rc 		= ((2*i)+2);
		
		if (lc < n && arr[lc] > arr[largest])
			largest = lc;
		if (rc < n && arr[rc] > arr[largest])
			largest = rc;
		
		if (largest != i)
		{
			int swap 	 = arr[i];
			arr[i]	 	 = arr[largest];
			arr[largest] = swap;
			
			heapify(arr, n, largest);
		}
		
	}
	static void print(int arr[]);		//All output
	{
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.println(arr[i]);
		System.out.println("Exchanges: " + heapexchange + "\n");
		System.out.println("Comparisons: " + heapcompare + "\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	void swap(int i, int n)
	{
		int temp = arr[0]
	}
}

