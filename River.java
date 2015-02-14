/*
	Problem Statement
	The Mississippi River runs through the heartland of America. You and your friends are planning a road trip where you will visit several cities in sequence. During the trip, you will want to know how many times you will have to cross this mighty river. For example, if your trip contains four cities, it is possible that you could cross the river up to three times.
	But, you have not yet finalized your itinerary. You are considering several possible trips. A trip consists of a list of cities. Technically, the trip begins with the first city on the list, and ends with the last city listed. In particular, we do not count any travel from your home to the first city, or from the last city on a list back to your home.
	For the purpose of this program, assume the following:
	 All cities in Minnesota (MN), Iowa (IA), Missouri (MO), Arkansas (AR), and Louisiana
	(LA) are located west of the Mississippi River.
	 All cities in Wisconsin (WI), Illinois (IL), Kentucky (KY), Tennessee (TN), and
	Mississippi (MS) are located east of the Mississippi River.
	 Your road trip will only contain cities in these states on either side of the river.
	 Within a trip, the cities must be visited in the order indicated.
	Input
	Thefirstlineoftheinputwillsay<t> trips,wheretisanintegerand2≤t≤200.
	The rest of the input will itemize the individual trips. Each trip will begin with a line of this format:
	Trip <i> has <c> cities.
	where c is an integer and 2 ≤ c ≤ 200. The trip numbers are numbered consecutively from 1.
	The next c lines will each contain the name of a city. The format of a city name is: <city name>, <state abbreviation>
	￼7
	Note that the city name could contain several words, but it will always be followed by a comma, a space and then the 2-letter state abbreviation. Both letters in this abbreviation will be capitalized. Blank space characters could follow the state abbreviation before the end of the line.
	Output
	Your program needs to indicate the number of river crossings on each trip, one trip per line of output. Each line of your output must be formatted like this:
	Trip <i> crosses the Mississippi <n> times.
	Where i is the trip number, and n is the number of river crossings your program has calculated. Note that if the number of river crossings is exactly 1, then the word “times” at the end of the sentence must be in the singular, “time.”

*/


/*
 * @author: Sakshyam Dahal
 * Date: feb 13, 2014
*/

import java.util.Scanner;
import java.util.Arrays;

public class River {

	public static void main(String[] args) 
	{
		String[] west = {"MN", "IA", "MO", "AR","LA"};
		String[] east = {"WI", "IL", "KY", "TN", "MS"};
		
		Scanner input = new Scanner(System.in);
		int numTrips = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i < numTrips; i++)
		{
			String[] tripInfo = input.nextLine().split(" ");
			int numCities = Integer.parseInt(tripInfo[3]);
			String[] cities = new String[numCities];
			
			for (int j = 0; j < numCities; j++)
			{
				String line = input.nextLine();
				String[] lineArr = line.split(",");
				String abbr = lineArr[1].trim();
				cities[j] = abbr;
			}
			
			int numCross = 0;
			for (int k = 0; k < cities.length; k++)
			{
				for (int l = 1; l < cities.length -1; l++)
				{
					// if the two cities in different array
					if (find(west, cities[k]) && find(east, cities[l]))
					{
						numCross++;
					}
					else if (find(east, cities[k]) && find(west, cities[l]))
					{
						numCross++;
					}
				}
			}
			
			System.out.printf("Trip %d crosses the Mississippi %d times.\n", (i+1), numCross);
		} // end of for

	}
	
	public static boolean find(String[] arrays, String value)
	{
		for (String item : arrays)
		{
			if (item.equals(value))
			{
				return true;
			}
		}
		return false;
	}

}
