/*
 *	Programmer: Sakshyam Dahal
 *	Date: January 30, 2015

 Implementation of class Node to be used by LinkedList class
*/

public class Node {

	private int mData;
	private Node mNext;

	public Node()
	{

	}


	public Node(int data)
	{
		mData = data;
	}	

	// getters and setters
	public int getData()
	{
		return mData;
	}
	public Node getNext()
	{
		return mNext;
	}

	public void setData(int data)	
	{
		mData = data;
	}

	public void setNext(Node next)
	{
		mNext = next;
	}


}
