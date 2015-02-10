package practice.edu;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) 
	{
//		Scanner input = new Scanner(System.in);
//		
//		System.out.println("How many elements in the array.");
//		int numElements = input.nextInt();
//		
//		int[] array = new int[numElements];
//		
//		for (int i = 0; i < numElements; i++)
//		{
//			System.out.println("Enter array element # " + (i + 1));
//			array[i] = input.nextInt();
//		}
		
		//int[] array = {12, 25, 17, 19, 51, 32, 45, 18, 22, 37, 15};
		int[] array = {5,5,5,5,5};
		
		System.out.println("Array before sort: " + Arrays.toString(array) + "\n");
		quickSort(array, 0, array.length - 1);
		System.out.println("Array after sort: " + Arrays.toString(array) + "\n");
		
		
	}
	
	public static void quickSort(int[] array, int leftIndex, int rightIndex)
	{
		// if len of array is more than one
		if ( leftIndex < rightIndex )
		{
			int splitPosition = hoarePartation(array, leftIndex, rightIndex);
			//System.out.println("Split positon = " + splitPosition + "\n");
			quickSort(array, leftIndex, splitPosition - 1);
			quickSort(array, splitPosition + 1, rightIndex);
		}
	}
	
	// hoarePartation method
	public static int hoarePartation(int[] array, int leftIndex, int rightIndex)
	{
		// System.out.print("Array on which partation is done: [ ");
//		for (int i = leftIndex; i <= rightIndex; i++)
//		{
//			System.out.print(array[i] + " ");
//		}
		// System.out.println(" ]");
		// first element as pivot
		int pivot = array[leftIndex];
		int i = leftIndex ;
		int j = rightIndex;
		
		while (i < j)
		{
			while (array[i] <= pivot & i + 1 <= rightIndex)
			{
				
				i++;
			}
			
			// System.out.println("i = " + i + " j = " + j + "\n");
			while(j - 1 >= leftIndex & array[j] > pivot)
			{
				j--;
			}
			System.out.println("i = " + i + " j = " + j + " before swapping i & j\n");
			swap(array, i, j);
		}
		
		
			swap(array, i , j); // undo last swap when i >= j
		
		swap(array,leftIndex, j);
		System.out.println("Array : " + Arrays.toString(array));
		return j;
	}
	
	public static void swap(int[] array, int index1, int index2)
	{
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
//		System.out.println("After swap: " + Arrays.toString(array) + "\n");
	}
	
	

}
