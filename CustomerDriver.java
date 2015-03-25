/**
 * Class CustomerDriver
 * 
 * This is the driver for the Customer program. The program simulates 60 minutes in a grocery store,
 * where every minute, there is a 25% chance a new customer enters the service line. Each customer
 * is randomly given a 1-5 minute wait-time. When a customer is serviced,they are removed from the
 * line. At the end of the program, the total number of customers serviced and the maximum length of
 * the line are provided.
 * 
 * @author Jordan Harris
 * @date September 26, 2014
 */

import java.util.Random;

public class CustomerDriver {

	public static void main(String[] args) {
		
		final int time = 60;  // Represents 60 minutes
		
		// Creates the queue
		CustomerQueue q1 = new CustomerQueue();
		
		// Iterates through 60 minutes in the grocery store, 1 minute at a time
		for(int i = 0; i < time; i++) {
			
			// Creates a 25% chance for adding a new customer to the queue
			if(new Random().nextInt(4) == 0) {
				q1.enqueue(new Customer());
			}
			
			// Checks to see if the queue is not empty
			if(!q1.isEmpty()) {
				
				// Decreases the first customer's service time
				q1.peek().decServiceTime();
				
				// If the first customer's service time reaches 0, they are serviced and removed
				// from the queue
				if(q1.peek().getServiceTime() == 0) {
					q1.dequeue();
				}
			}
			
			// Simulates the passage of time (1 minute)
			System.out.println("---------------------------------------------------");
			
		}
		
		System.out.println("Total customers serviced: " + q1.getTotalCustomers());
		System.out.println("Maximum line length: " + q1.getMaxLength());
		
	}

}
