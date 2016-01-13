package proj4;

/**
 * Node class that represents a single item in a reference based implementation of a stack and queue
 * 
 * @author Megha Madan
 *
 */

public class Node <E> {

	private E data;
	private Node next;
	
	/**
	 * getter method for the data held in each node
	 * @return the generic type data that the node holds
	 */
	public E getData ( ) {
		return data;
	}
	
	/**
	 * getter method for the next node the current node references
	 * @return the node that is referenced by the current node
	 */
	public Node getNext ( ) {
		return next;
	}
	
	/**
	 * setter method for the data held in each node
	 * @param data - input of generic type that will be the new data of the node
	 */
	public void setData (E data) {
		this.data = data;
	}
	
	/**
	 * setter method for the next node the current method references
	 * @param next - input of node type that will be the new reference the current node points to
	 */
	public void setNext (Node next) {
		this.next = next;
	}
	
	public String toString( ){
		return data + "";
	}
}
