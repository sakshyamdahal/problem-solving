/*
 * 	Programmer :- Sakshyam Dahal
 * 	Date	:- January 20, 2015
 * 	
 *  An algorithm to find a lonely integer in an array
 */

public class LonelyInteger {

	/*
	 * Algorithm: Using bit manipulation and exclusive or
	 * a^a = 0
	 * a^0 = a
	 * 
	 * Time complexity O(n) where n is the length of the array
	 * Space complexity O(1) using a bit vector to find the lonely element.
	 */
	
	public static int lonelyElement(int[] array)
	{
		int a = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			a ^= array[i];
		}
		
		return a;
	}
}
