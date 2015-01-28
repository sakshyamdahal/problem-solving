public class MatrixRotation {
/*
 * Programmer: Sakshyam Dahal
 * Date: jan 27, 2015
 */
	
	

/*
 * Given an image represented by an NxN matrix, where each pixel in the image
 *	is 4 bytes, write a method to rotate the image by 90 degrees. 
 *	Can you do this in place?
*/
	public static void main(String[] args)
	{
		int[][] mat = {{1,2,3,4}, {9,8,5,6},{6,5,3,7},{9,2,6,8}};
		rotateMatrix(mat);
		
		printMatrix(mat);
		
	}
	
	public static void rotateMatrix(int[][] image)
	{
		int order = image.length;
		rotateMatrix(image, order);
	}
	
	public static void rotateMatrix(int[][] image,int n)
	{
		// matrix of order n*n will have n / 2 layers
		
		// go through each layer
		for (int i = 0; i < n/2; i++)
		{
			int first = i;
			int last = n - i - 1;
			
			for (int j = first; j < last; j++)
			{
				int k = j - first;
				
				
				// temporarily hold the top element
				int top = image[first][j];
				
				// move left --> top
				image[first][j] = image[last - k][first];
				
				// move bottom --> left
				image[last - k][first] = image[last][last - k];
				
				// move right ----> bottom
				image[last][last - k] = image[j][last];
				
				// move top --> right
				image[j][last] = top; 
				
			}
			
		}
	}
	
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
