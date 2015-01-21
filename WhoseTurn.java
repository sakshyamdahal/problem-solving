
/*
 * 	Programmer :- Sakshyam Dahal
 * 	Date	:- January 21, 2015
 * 	
 *  
 */


 
/*QUESTION:
Playing ping-pong can be really fun! Unfortunately after a long and exciting play 
you can forget who's service turn it is. Let's do something about that!
Write a function that takes the current score as a string separated by : 
sign as an only parameter and returns "first" or "second" depending on whose service turn it is.
We're playing old-school, so the rule is that players take turn after every 5 services. 
That is until the score is 20:20 - from that moment each player serves 2 times in his turn.
Examples:
service("0:0") // => "first"
service("3:2") // => "second"
service("21:20") // => "first"
service("21:22") // => "second"
There's no need to check if the passed parameter is valid - the score will be always provided
 in correct syntax and you don't need to check if one of the players has already won - that won't be the case.
P.S. The game ends when one of the players reaches 21 points with minimum 2-point lead.
 If there's a current score of 20:20, the winner will be the first player to reach 2-point lead.
*/

public class WhoseTurn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String whose = service("21:22");
		System.out.println(whose);

	}
	
	public static String service(String score)
	{
		String[] scores = score.split(":");
		int firstScore = Integer.parseInt(scores[0]);
		int secondScore = Integer.parseInt(scores[1]);
		
		int sumOfScores = firstScore + secondScore;
		
		
		if (sumOfScores > 40)
		{
			int remainingServes = sumOfScores - 40;
			int turn = remainingServes / 2;
			
			if (even(turn))
				return "first";
			else
				return "second";
		}
		else
		{
			int turn = sumOfScores / 5;
		if (even(turn))
			return "first";
		else
			return "second";
		}
		
		
		
	}
	
	public static boolean even(int num)
	{
		return num % 2 == 0;
	}

}
