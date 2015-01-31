// makes use of Node class

/*
 *	Programmer: Sakshyam Dahal
 *	Date: January 30, 2015
 * LinkedList implementation includes funcitons:
 *	void addToEnd : Adds an element or node at the end of the linked list
 *	boolean hasLoop	: returns true or false based on whether the linked list has
 *						a loop or not
*/

import java.util.ArrayList;

public class LinkedList {

	// testing code
	public static void main(String[] args)
	{
		LinkedList myList = new LinkedList(3);
		Node newNode = new Node(5);
		myList.addToEnd(newNode);
		myList.addToEnd(8);
		myList.addToEnd(80);
		myList.addToEnd(800);
		myList.addToEnd(8000);
		myList.addToEnd(81);
		myList.addToEnd(newNode);

		System.out.println(LinkedList.hasLoop());

	}

	// class variable
	private static Node mHead;

	// constructor
	public LinkedList(int data)
	{
		mHead = new Node(data);
	}

	// add element to the end of the linked list
	public void addToEnd(int num)
	{
		Node newNode = new Node(num);

		Node pointer = mHead;
		while(pointer.getNext() != null)
		{
			pointer = pointer.getNext();
		}
		pointer.setNext(newNode); 
	}

	// add a node to the end of linked list
	public void addToEnd(Node newNode)
	{
		Node pointer = mHead;
		while(pointer.getNext() != null)
		{
			pointer = pointer.getNext();
		}
		pointer.setNext(newNode); 
	}

	// check if linkedList has a loop
	public static boolean hasLoop()
	{
		// go through the linked list and store the pointer in an arrayList 
		// check if the pointer gets repeated 
		// if yes there's a loop if no then no loop

		// time complexity O(n) where n is the length of linked list
		// space complexity O(n) where n is the length of linked list

		ArrayList<Node> nodes = new ArrayList<Node>();

		Node pointer = mHead;

		while(pointer != null)
		{
			// check if the pointer is in the arraylist
			if (nodes.contains(pointer))
				return true;
			else
			{
				nodes.add(pointer);
			}

			pointer = pointer.getNext();
		}

		return false;
	}

	
	public Node getHead()
	{
		return mHead;
	}

}
