package proj4;

import java.util.Queue;


/**
  * Class that represents a reference based implementation (linked-list) of a queue
 * Uses the Node class to represent items in the list
 * 
 * @author Megha Madan
 * 
 * @param <E> Generic Type class
 */
public class MyQueue <E> {
	
	private Node head;
	private static int numOfElements;
	
	/**
	 * Default constructor for my queue implementation 
	 * Creates an empty queue made with a Node called head that references null and sets number of elements to 0
	 */
	public MyQueue ( ){
		head = null;
		numOfElements = 0;
	}
	
	/**
	 * Method that checks if the queue is empty - uses my numOfElements counter to check this
	 * @return boolean value corresponding to numOfElements being 0 or anything else
	 */
	boolean empty ( ){
		if (numOfElements == 0) return true;
		else return false;
	}
	
	/**
	 * Checks to see what the element at the front of the queue (the one that has been there the longest)
	 * @return the data of this first element (head) in generic type
	 */
	public E peek ( ){
		return (E) head.getData();
	}
	
	/**
	 * Method that removes the element at front of the queue 
	 * @return the element itself that is removed
	 */
	public E dequeue ( ){ 
		
		//This keeps track of the element that we will get rid of so we can return it
		Node tmp = head;
		
		//first make sure the list is not empty 
		if(head != null){
			//make head point to second node which will remove reference to the first thus deleting it (Java garbage collector)
			head = head.getNext();
			//adjust counter to keep track of the number of elements
			numOfElements--;
		}
		return (E) tmp.getData();
	}
	
	/**
	 * Inserts an element at the back of the queue
	 * @param item - the input item that will be inserted in the queue
	 * @return the item itself that is inserted into the queue
	 */
	public E enqueue (E item ){
		
		//First create a new node and set the data of the node equal to the item
		Node newNode = new Node ( );
		newNode.setData(item);
		
		//special case - if the list is empty, simply point head to the newNode
		if(empty())
			head = newNode;
		
		//otherwise, find the last element in the queue (while loop that continues to next node until it equals null)
		//then point this element to the newNode
		else{
			Node current = head;
			while (current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		
		//adjust counter to keep track of the number of elements
		numOfElements++;
		//also point the newNode to null to make it the last element
		newNode.setNext(null);
		return item;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * While loop to go through each element in the queue and add it to StringBuilder object s
	 */
	public String toString(){
		
		//set current to head and counter to 0
		Node current = head;
		int counter = 0;
		//create StringBuffer object
		StringBuffer s = new StringBuffer();
		
		//as long as the current reference doesn't equal null and the number of elements is not equal to the counter
		//add it to the StringBuilder object with a new line after it 
		//finally, set current to next node
		while(current != null && counter != numOfElements){
			
			s.append(current.toString());
			s.append("\n");
			current = current.getNext();
		}
		return s.toString();
	}
	
}
