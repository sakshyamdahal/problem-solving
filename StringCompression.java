/*
 * 	Programmer: Sakshyam Dahal
 * 	Date: January 24, 2015
 * 
 * 	Problem: Implement a method to perform basic string compression using the counts
 *  		of repeated characters. For example, the string aabcccccaaa would 
 *  		become a2blc5a3. If the "compressed" string would not become smaller 
 *  		than the original string, your method should return the original string.
 *  
 *  		Also implement a method to convert the compressed string back to original string
 */

public class StringCompression 
{
	/*
	 * Time complexity O(n) where n is the length of the string
	 * Space complexity O(1) creating a new string to hold the compressed string
	 */
		
	public static String getCompressedString(String original)
	{
		if (compressedStringLen(original) > original.length())
		{
			return original;
		}
		else
		{
			// compress the string
			int counter = 0;
			String compressed = "";
			while (counter < original.length())
			{
				char curr = original.charAt(counter++);
				int repeat = 1;
				
				while(counter < original.length() && original.charAt(counter) == curr)
				{
					repeat++;
					counter++;
				}
				
				compressed += curr + "" + repeat;
			}
			
			return compressed;
		}
	}
	
	// helper method to calculate the length of compressed string
	public static int compressedStringLen(String s)
	{
		int counter = 0;
		int lenOfCompressed = 0;
		while(counter < s.length())
		{
			int repeat = 0;
			char curr = s.charAt(counter);
			counter++;
			
			while(counter < s.length() && s.charAt(counter) == curr)
			{
				counter++;
				repeat++;
			}
			
			lenOfCompressed += (repeat < 10) ? 2 : 3;
		}
		
		return lenOfCompressed;
	}
	
	
	// get original string from compressed one
	public static String getOriginalString(String compressed)
	{
		String original = "";
		
		int i = 0;
		while(i < compressed.length())
		{
			char curr = compressed.charAt(i);
			i++;
			
			String numRepeat = "";
			while(i < compressed.length() && isDigit(compressed.charAt(i)))
			{
				numRepeat += "" + compressed.charAt(i);
				i++;
			}
			
			for (int j = 0; j < Integer.parseInt(numRepeat); j++)
				original += curr;
			
		}
		
		return original;
	}
	
	// helper method to check if a character is a digit
	public static boolean isDigit(char c)
	{
		return ( c >= '0' && c <= '9');
	}
		
}
