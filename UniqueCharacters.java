import java.util.HashSet;

/*
 * 	Programmer :- Sakshyam Dahal
 * 	Date	:- January 19, 2015
 * 	
 *  An algorithm to determine if a string has all unique characters
 */

public class UniqueCharacters {
	
	/*
	 * Algorithm:
	 * Create a hashSet and add each character of the string to
	 * the hashSet. If the character is already present then the
	 * string doesn't have unique characters else
	 * string has unique character
	 * 
	 * Runtime Complexity : O(n) where n is the length of string
	 * Memory Complexity: O(n)  need to create a hashSet to add all characters of the string
	 */
	
	public static boolean hasUniqChar(String text)
	{
		HashSet<Character> charSet = new HashSet<Character>();
		
		for (int i = 0, j = text.length(); i < j; i++)
		{
			char currentChar = text.charAt(i);
			if (charSet.contains(currentChar))
			{
				return false;
			}
			else
			{
				charSet.add(currentChar);
			}
					
		}
		charSet = null;
		return true;
	}
	
	/*
	 * Alternative solution: Compare each character of string to every other character in the string
	 * Time complexity for this algorithm: O(n^2)
	 * Space complexity O(1)
	 */

}
