
package proj4;

import java.util.*;

/**
 * Class that represents a reference based implementation (linked-list) of a stack
 * Uses the Node class to represent items in the list
 * @author Megha Madan
 *
 * @param <E> Generic type class
 */

public class MyStack <E> {
	
	private Node head;
	private static int numOfElements;
	
	/**
	 * Default constructor that creates an empty Stack object by setting head to null and numOfElements counter to 0
	 */
	public MyStack ( ) {
		head = null;
		numOfElements = 0;
	}
	
	/**
	 * Method that checks if the stack is empty - uses my numOfElements counter to check this
	 * @return boolean value corresponding to numOfElements being 0 or anything else
	 */
	public boolean empty( ) {
		if(numOfElements == 0) return true;
		else return false;
	}
	
	/**
	 * Checks to see what the element at the top of the stack is
	 * @return the element's data of the generic type
	 */
	public E peek ( ){
		return (E) head.getData();
	}
	
	
	/**
	 * Adds an element to the top of the stack
	 * @param item - input of generic type that will be added to the stack
	 * @return
	 */
	public E push (E item) {
		
		//First create a new node and set its data to the input item and its next reference to head (the first element)
		//Must do this first so we don't lose the rest of the linked list
		Node newNode = new Node ( );
		newNode.setData(item);
		newNode.setNext(head);
	
		//Now we can set the head reference to this new node
		head = newNode;
		
		//adjust numOfElements counter by adding one
		numOfElements++;
		
		return (E) head.getData();
		
	}
	
	/**
	 * Method that removes the element at the top of the stack
	 * @return the item that was at the top of the stack
	 */
	public E pop ( ) {
		
		//keeps track of the soon to be deleted item at the top of the stack
		Node tmp = new Node();
		
		//first check if the list is empty by checking head reference
		if (head!= null){
			//if it is not empty, continue with removing element
			//first need to record the element that will be removed so it can be returned
			tmp = head;
			//then set the head reference to the second node, thus deleting the first node (Java garbage collector)
			head = head.getNext();
			//adjust numOfElements counter
			numOfElements--;
		}
		return (E) tmp.getData();
		
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
