/*
 * Programmer: Sakshyam Dahal
 * Date: January 29, 2015
 */


import java.util.ArrayList;

public class ZeroElement {
	
/*	Write an algorithm such that if an element in an M*N matrix is 0, its entire row and column are set to 0.

	Example:  	
	Input:	1	4	5
			2	0	9
			4	2	6

	Output:	1	0	5
			0	0	0
			4	0	6


	Algorithm: 	Get the position of elements whose value is 0 and store it.
	Loop through and set the row and column of corresponding element to 0	
	
	Time complexity O(NM).. The best we can do because we have to go through all elements
	Space complexity O(N) ( can be done better )

			{ { 1, 4, 5 }, { 2, 0, 9}, { 4, 2, 6} }
	Element 0 : [1, 1]
*/
	public static void main(String[] args)
	{
		int[][] matrix = { { 0, 4, 5, 7, 9 }, { 2, 0, 9, 1, 2}, {2,3, 4, 2, 6} };
		printMatrix(matrix);
		System.out.println("------------------");
		setRowColumnToZero(matrix);
		printMatrix(matrix);
	}
	
	
	// method to do the desired task
	public static void setRowColumnToZero(int[][] matrix)
	{
		ArrayList<Integer> rowIndex = new ArrayList<Integer>();
		ArrayList<Integer> columnIndex = new ArrayList<Integer>();

		// go through the matrix to record the position of 0’s
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == 0)
				{
					if (!rowIndex.contains(i))
					{
						rowIndex.add(i);
					}

					if (!columnIndex.contains(j))
					{
						columnIndex.add(j);
					}
				}
				
			}
		} // end of outer for loop


		// go through the arraylist again and set the desired elements to 0
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (rowIndex.contains(i) || columnIndex.contains(j))
				{
					matrix[i][j] = 0;
				}
			}
		}

		
	} // end of method
	
	
	// helper method to see the matrix to view results
	public static void printMatrix(int[][] mat)
	{
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[i].length; j++)
			{
				System.out.print(mat[i][j] + "\t");
			}
			
			System.out.println();
		}
	}
			


}
