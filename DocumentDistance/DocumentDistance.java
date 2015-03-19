import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Arrays;
import java.math.BigInteger;

public class DocumentDistance {

	private static BufferedReader reader;
	private static Hashtable<String, Integer> doc1 = new Hashtable<String, Integer>();
	private static Hashtable<String, Integer> doc2 = new Hashtable<String, Integer>();
	private static BigInteger totalWords = BigInteger.valueOf(100L);

	public static void main(String[] args) throws IOException {

		reader = new BufferedReader(new InputStreamReader(System.in));

		// get file names to open
		System.out.print("File#1: ");
		String file1 = reader.readLine();
		System.out.print("File#2: ");
		String file2 = reader.readLine();

		
		// open files and read
		try {
			readFiles(file1, file2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// find the distance
		double distance = getDistance();
		
		System.out.println(distance);


	}
	
	public static double getDistance()
	{
		BigInteger d1Dotd2 = BigInteger.ZERO;
		Integer doc2Count;
		for (String word : doc1.keySet())
		{
			//System.out.println("here");
			
			doc2Count = doc2.get(word);
			
			if (doc2Count == null)
				doc2Count = 0;
			else
				doc2Count = doc2Count.intValue();
			
			d1Dotd2 = d1Dotd2.add(BigInteger.valueOf((long)doc1.get(word) * doc2Count));
			//System.out.println(doc1.get(word) * doc2Count);
			System.out.println(d1Dotd2.toString());
		}
		
		System.out.println("Total words " + totalWords.toString());
		d1Dotd2 = d1Dotd2.divide(totalWords);
		System.out.println("final " + d1Dotd2.toString());
		double angle = Math.acos(d1Dotd2.longValue()) * (180 / Math.PI);
		
		return angle;
	}

	public static void readFiles(String f1, String f2) throws IOException
	{
		String currentLine;
		String[] line;
		reader = new BufferedReader(new FileReader(new File(f1)));
		while( (currentLine = reader.readLine()) != null)
		{
			line = currentLine.split(" ");
			//System.out.println(Arrays.toString(line));
			
			for(String word: line)
			{
				if (!word.equals(""))
				{
					//System.out.println(word);
					totalWords = totalWords.add(BigInteger.valueOf((long)1));
					if (doc1.containsKey(word))
						doc1.put(word, doc1.get(word) + 1);
					else
						doc1.put(word, 1);
				}
			}
		}

		reader = new BufferedReader(new FileReader(new File(f2)));
		while( (currentLine = reader.readLine()) != null)
		{
			line = currentLine.split(" ");
			//totalWords.add(BigInteger.valueOf((long)line.length));
			for(String word: line)
			{
				if (!word.equals(""))
				{
					totalWords = totalWords.add(BigInteger.valueOf((long)1));
					if (doc2.containsKey(word))
						doc2.put(word, doc2.get(word) + 1);
					else
						doc2.put(word, 1);
				}
			}
		}

		System.out.println(doc1.toString());

	}

}
