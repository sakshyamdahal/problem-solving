package arrays.strings.problems;

import java.util.Scanner;

/**
 * @author sakshyamdahal
 *
 */
public class HyperBinary {
	private static long hyperBinaryCount = 0;
	
	private static void numHyperBinary(long number)
	{
		if (number == 0)
		{
			hyperBinaryCount++;
			return;
		}
		else if (number % 2 == 0)
		{
			numHyperBinary(number/2);
			numHyperBinary(number/2 - 1);
		}
		else
		{
			numHyperBinary(number / 2);
		}
	}
	
	public static long nHyperBinary(long number)
	{
		numHyperBinary(number);
		return hyperBinaryCount;
	}
	
	public static void printHyperBinary(String hyper, long number)
	{
		if (number == 0)
		{
			System.out.println(hyper);
			return;
		}
		else if (number % 2 == 0)
		{
			printHyperBinary( "0" + hyper, number/2);
			printHyperBinary("2" + hyper, number / 2 - 1);
		}
		else
		{
			printHyperBinary("1" + hyper, number/ 2);
		}
	}
	
	public static void printHyperBinary(long number)
	{
		printHyperBinary("" , number);
	}
	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		long num = input.nextLong();
		input.close();
		printHyperBinary(num);
	}
	
}
