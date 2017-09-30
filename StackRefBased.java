/*
 * Name: Ben Mazerolle
 * ID: V00868691
 * Date: March 12, 2017
 * Filename: StackRefBased.java
 * Details: CSC 115, Spring 2017 Assignment 3
 */

public class StackRefBased<T> implements Stack<T> {

	private StackNode<T> top; 
	private int count = 0;
	
    public StackRefBased() {
    }

	//The following method returns the number of nodes in the stack
    public int size() {
        return count;
    }

	//The following method determines if the stack is empty using the count variable 
    public boolean isEmpty() {
        return count == 0;
    }

	//The following method places a new node onto the top of the stack
    public void push(T data) {
		StackNode<T> two = top;
		top = new StackNode<T>(data); 
		top.next = two;
		count++;
    }

	//The following method returns and removes the top stack node, if there is one
    public T pop() throws StackEmptyException {
        if(count == 0){
			throw new StackEmptyException();
		} 
			T item = top.data; 
			top = top.next;
			count--;
		return item;
}

	//The following method returns the contents of the top stack node, if there is one
    public T peek() throws StackEmptyException {
		if(count == 0){
			throw new StackEmptyException();
		} 
        return top.data;
    }

	//The following method empties the stack and resets count
    public void makeEmpty() {
		top = null; 
		count = 0;
    }

	//The following method was not implemented to convert the stack into a string
    public String toString() {
    
	return "Sweden!";
    }
}

