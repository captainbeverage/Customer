/**
 * Class CustomerQueue
 * 
 * Class file for a Linked Queue of Customer objects. This class provides functionality for
 * adding customers to the queue, removing them, returning the customer at the front of the queue,
 * and it keeps track of the current length of the queue, total customers removed from the queue,
 * and the maximum size of the queue.
 * 
 * @author Jordan Harris
 * @date September 26th, 2014
 */

public class CustomerQueue {

	private static int length = 0;          // Length of the line
	private static int totalCustomers = 0;  // Total number of customers serviced
	private static int maxLength = 0;       // Maximum length of the line
	private Customer first;  				// First customer in line
	private Customer last;   				// Last customer in line
	
	// Queue constructor
	public CustomerQueue() {
		first = null;
		last = null;
	}
	
	// Checks to see if the queue is empty
	public boolean isEmpty() {
		return first == null;
	}
	
	// Returns the first customer in line
	public Customer peek() {
		return first;
	}
	
	// Adds a customer to the end of the line
	public void enqueue(Customer c) {
		
		// Checks to see if the queue is empty
		if(!isEmpty()) {
			// Sets the last object's reference to point to the new object
			last.setNext(c);
		} else {
			// Sets the first reference to the new object
			first = c;
		}
		
		// Sets the last reference to the new object
		last = c;
		
		// Increments the length of the line when a customer is added
		length++;
		
		// Assigns the maximum length of the line
		if(length > maxLength)
			maxLength = length;
		
		System.out.println("New Customer added! Queue length is now " + length);
	}
	
	// Removes a customer from the front of the line
	public Customer dequeue() {
		
		// Checks to ensure queue is not empty
		if(!isEmpty()) {
			
			// Creates a temporary variable to return the first object
			Customer temp = first;
			first = first.getNext();
			
			// Decreases the length of the line
			length--;
			
			// Increases the number of customers serviced
			totalCustomers++;
			
			System.out.println("Customer serviced and removed from the queue. Queue length is now " + length);
			
			// Returns the temporary reference to the original first object
			return temp;
			
		} else {
			// Returns null if the queue is empty
			return null;
		}
		
	}
	
	// Returns the total number of customers serviced
	public int getTotalCustomers() {
		return totalCustomers;
	}
	
	// Returns the maximum length of the line
	public int getMaxLength() {
		return maxLength;
	}
}
