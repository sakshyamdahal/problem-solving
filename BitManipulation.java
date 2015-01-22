/*
	Programmer: Sakshyam Dahal
	Date: January 22, 2015
	Purpose: Learn bit wise operators and identify problems where I can 
	leverage the bitwise operators to solve a problem easily.
*/

public class BitManipulation 
{

	/*
	 * Using bit manipulation to check if two numbers have opposite sign
	 * If two numbers have opposite sign the first bit in both numbers will be 
	 * different. So if we use XOR (1 XOR 0 = 1) and (0 XOR 1 = 1) which makes the resulted
	 * XOR to have first bit as 1 ie makes the number negative. So if (a XOR b) < 0
	 * then the signs of a and b are different.
	 */
	public static boolean oppositeSign(int a, int b)
	{
		return (a ^ b) < 0;
	}
}
