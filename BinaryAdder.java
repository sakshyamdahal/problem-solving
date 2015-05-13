/*
 * Problem from Introduction to Algorithms
 * Exercise: 2.1-4
 * @author: Sakshyam Dahal
*/

import java.util.Arrays;

public class BinaryAdder {
	static boolean T = true;
	static boolean F = false;

	public static int[] binaryAdd(boolean[] a, boolean[] b)
	{
		int[] c = new int[a.length + 1];
		int carry = 0;

		for (int i = c.length -1; i >= 0; i--)
		{
			if (i == 0)
				c[i] = carry;
			else
			{
				c[i] = (boolToNum(a[i-1]) + boolToNum(b[i-1]) + carry) % 2;
				carry =  (boolToNum(a[i-1]) + boolToNum(b[i-1]) + carry) / 2;
			}
		}

		return c;
	}

	public static int boolToNum(boolean a)
	{
		return a ? 0 : 1;
	}

	public static void main(String[] args)
	{
		boolean[] a = {F,T,F,T,F,T,F,T};
		boolean[] b = {F,F,T,T,F,F,T,T};

		System.out.println(Arrays.toString(binaryAdd(a,b)));
	}

}
