
/*
 * Programmer: Sakshyam Dahal
 * Date: January 25, 2014
 * 
 * Problem: Assume you have a method isSubstring which checks if 
 * 			one word is a substring of another. Given two strings, 
 * 			s1 and s2, write code to check if s2 is a rotation of s1 using 
 * 			only one call to isSubstring (e.g.,"waterbottle"is a rotation of"erbottlewat").
 */

public class StringRotation {
	/*
	 *  Logic: rotation of a string s1 will always be a substring of s1+s1
	 *  Time complexity O(n): n where n is the length of the string
	 *  
	 */
	
	
	public static void main(String[] args)
	{
		System.out.println(isRotation("waterbottle", "erbottlewat"));
	}
	
	// check if s2 is a rotation of s1
	public static boolean isRotation(String s1, String s2)
	{
		return isSubstring(s2, s1 + s1);
	}
	
	// check if s1 is substring of s2
	public static boolean isSubstring(String s1, String s2)
	{
	  
		// since s1 is substring its length cannot exceed s2 length
		if (s1.length() > s2.length())
			return false;
		
		// counter variable
		int i = 0;
		
		while ( i < s2.length() )
		{
			// can be a substring
			if (s2.charAt(i) == s1.charAt(0))
			{
				boolean isSubstr = true;
				
				for (int j = 1; j < s1.length(); j++)
				{
					// in this case can't be substring
					if (s1.charAt(j) != s2.charAt(++i))
					{
						isSubstr = false;
						break;
					}
				}
				
				if (isSubstr)
					return true;
			}
			
			i++;
		}
		
		return false;
		
	}
}
