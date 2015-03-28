/*
	In the children’s game “hot potato,” a group of n children sit in a circle 
	passing an object, called the “potato,” around the circle. The potato begins 
	with a starting child in the circle, and the children continue passing the potato 
	until a leader rings a bell, at which point the child holding the potato must leave 
	the game after handing the potato to the next child in the circle. After the selected 
	child leaves, the other children close up the circle. This process is then continued 
	until there is only one child remaining, who is declared the winner. If the leader 
	always uses the strategy of ringing the bell so that every kth person is removed 
	from the circle, for some fixed value k, 
	then determining the winner for a given list of children is known as the Josephus problem
*/

public class JosephusProblem {
	
	public static <E> E josephus(E[] list, int k)
	{
		if (list.length == 0) return null;
		
		CircularQueue<E> items = buildQueue(list);
		
		while (items.size() != 1)
		{
			for (int i = 1; i < k; i++)
			{
				items.rotate();
			}
			
			System.out.printf("%s is out", items.dequeue());
			
		}
		
		return items.dequeue();
	}
	
	public static <E> CircularQueue<E> buildQueue(E[] list)
	{
		CircularQueue<E> q = new CircularQueue<E>();
		for (E items : list)
		{
			q.enqueue(items);
		}
		
		return q;
	}
	
}
