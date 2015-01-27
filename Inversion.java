import java.util.Scanner;

public class Inversion {
	
	private static final int NUM_INT = 100000;
	private static long numInversion = 0;
	
	public static void main(String[] args)
	{
		int[] data = getDataInArray();
//		System.out.println(data[NUM_INT -1]);
		data = countInversionAndSort(data, 0, data.length - 1);
		System.out.println(numInversion);
		
	}
	
	public static int[] countInversionAndSort(int[] array, int leftBound, int rightBound)
	{
		
		if (rightBound <= leftBound)
			return new int[]{array[rightBound]};
		
			int mid = (rightBound + leftBound) / 2;
			int[] left = countInversionAndSort(array, leftBound, mid);
			int[] right = countInversionAndSort(array, mid+1, rightBound);
			
			return countInversionAndMerge(array, left, right, leftBound, mid, rightBound);
			
		
	}
	
	public static int[] countInversionAndMerge(int[] array, int[] leftHalf, int[] rightHalf, int leftBound, int mid, int rightBound)
	{
		int arraySize = ( rightBound - leftBound) + 1;
		int[] tempArray = new int[arraySize];
		
		int i = 0;
		int j = 0;
		int index = 0;
		int leftSize = mid - leftBound + 1;
		int rightSize = rightBound - mid;
		
		while (i < leftSize && j < rightSize)
		{
			if (leftHalf[i] <= rightHalf[j])
			{
				tempArray[index++] = leftHalf[i++];
			}
			else if (leftHalf[i] > rightHalf[j])
			{
				tempArray[index++] = rightHalf[j++];
				numInversion += (mid - (leftBound + i)) + 1;
			}
		}
		
		if (i >= leftSize)
		{
			while (j < rightSize)
			{
				tempArray[index++] = rightHalf[j++];
			}
		}
		else if (j >= rightSize)
		{
			while (i < leftSize)
			{
				tempArray[index++] = leftHalf[i++];
			}
		}
		
//		// copy over to original array
//		index = 0;
//		for (int k = leftBound; k <= rightBound; k++)
//		{
//			array[k] = tempArray[index++];
//		}
		
		return tempArray;
		
	}
	
	
	// get the data return it in an array
	public static int[] getDataInArray()
	{
		Scanner input = new Scanner(System.in);
		int[] data = new int[NUM_INT];
		for (int i = 0; i < NUM_INT; i++)
			data[i] = input.nextInt();
			
		return data;
		
	}

}
