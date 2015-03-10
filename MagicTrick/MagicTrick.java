import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MagicTrick {
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int numTestCase = Integer.parseInt(reader.readLine());
		
		int firstTime;
		int secondTime;
		String[] arr = {};
		String[] arr2 = {};
		
		int i;
		int j;
		for (i = 0; i < numTestCase; i++)
		{
			firstTime = Integer.parseInt(reader.readLine());
			for (j = 1; j <= 4; j++)
			{
				if (j == firstTime)
				{
					arr = reader.readLine().split(" ");
				}
				else
					reader.readLine();
			}
			
			secondTime =Integer.parseInt(reader.readLine());
			for (j = 1; j <= 4; j++)
			{
				if(j == secondTime)
				{
					arr2 = reader.readLine().split(" ");
				}
				else
					reader.readLine();
			}
			
			String result = giveResult(arr, arr2);
			System.out.println(String.format("Case #%d: %s", (i+1), result));
		}
		
		
	}
	
	public static String giveResult(String[] a, String[] b)
	{
		List<String> a1 = Arrays.asList(a);
		List<String> a2 = Arrays.asList(b);
		
		int found = 0;
		String sol = "";
		for (String val : a1)
		{
			if (a2.contains(val))
			{
				found++;
				sol = val;
			}
		}
		
		if (found == 0)
		{
			return "Volunteer cheated!";
		}
		else if (found > 1)
		{
			return "Bad magician!";
		}
		else
			return sol;
	}
	
}
