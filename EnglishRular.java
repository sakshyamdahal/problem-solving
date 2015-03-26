public class EnglishRular 
{
	public static void printRular(int inches, int marks)
	{
		drawMark(0, marks);

		for (int i = 1; i <= inches; i++)
		{
			drawInterval(marks - 1);
			drawMark(i, marks);
		}
	}

	private static void drawInterval(int marks)
	{
		if (marks >= 1)
		{
			drawInterval(marks - 1);
			drawMarks(marks);
			drawInterval(marks - 1);
		}
	}

	private static void drawMark(int inchesLabel, int marks)
	{
		StringBuilder s = new StringBuilder();
		for (int i = 1; i <= marks; i++)
			s.append("-");

		if (inchesLabel >= 0)
			s.append(" " + inchesLabel);

		System.out.println(s.toString());

	}

	private static void drawMarks(int marks)
	{
		drawMark(-1, marks);
	}

	public static void main(String[] args)
	{
		EnglishRular.printRular(3, 3);
	}
}
