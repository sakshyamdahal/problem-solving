import java.util.Arrays;
import java.util.HashMap;

/* 
 *  Programmer: Sakshyam Dahal
 *  Date: January 23, 2015
 *  
 *  Problem: To determine if one string is permutation of another
 */

public class Permutation 
{
	/*
	 *  Algorithm 1: Sort the two strings and check if they are same
	 *  Time complexity: Complexity of sorting algorithm using mergeSort O(nlogn)
	 *  Space complexity: O(n) while sorting
	 */
	
	public static boolean isPermutation1(String s1, String s2)
	{
		return sort(s1).equals(sort(s2));
	}
	
	// helper method to sort string 
	// using java built in sort method in Arrays class
	public static String sort(String s)
	{
		char[] sArray = s.toCharArray();
		Arrays.sort(sArray);
		
		// Note: can't use sArray.toString()
		
		return new String(sArray);
	}
	
	
	/* 
	 *  Algorithm2: for the first string put all characters in a hashTable
	 *  for the second string remove the characters from hash table
	 *  if character can't be found for removing then its not permutation
	 *  if at the end hashSet is empty its permutation of 1st string
	 *  
	 *  Time complexity O(n) where n is the length of string 
	 *  Space complexity O(n) 
	 */
	
	public static boolean isPermutation2(String s1, String s2)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		putInMap(s1, map);
		return removeFromMap(s2, map);
			
		
	}
	
	/*
	 * Helper methods
	 */
	
	public static HashMap<Character, Integer> putInMap(String s1, HashMap<Character, Integer> map)
	{	
		for (int i = 0; i < s1.length(); i++)
		{
			char current = s1.charAt(i);
			
			if (map.containsKey(current))
			{
				// update the value
				map.put(current, map.get(current) + 1);
			}
			else
			{
				map.put(current, 1);
			}
		}
		
		return map;
	}
	
	public static boolean removeFromMap(String s2, HashMap<Character, Integer> map)
	{
		for (int i = 0; i < s2.length(); i++)
		{
			char current = s2.charAt(i);
			
			if (map.containsKey(current))
			{
				int currentValue = map.get(current);
				map.put(current, currentValue - 1);
				
				if (currentValue == 1)
					map.remove(current);
			}
			else
			{
				return false;
			}
		}
		
		return map.isEmpty();
	}
	
}
