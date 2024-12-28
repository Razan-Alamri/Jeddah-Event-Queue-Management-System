
// QueueOfAuditoriumArr.java

/*
** Name: Razan Arif Alamri
** 9-12-2022
*/

package finallab2022_1;

public class QueueOfAuditoriumArr {
	private Visitor[] queue;
	private int maxSize;
	private int front;
	private int numItems;

	// Constructor
	public QueueOfAuditoriumArr(int size) {
		maxSize = size; // set array size
		queue = new Visitor[maxSize]; // create array for stack
		front = 0;
		numItems = 0; // initialize numItems to zero
	}

	//
	// boolean | isFull()
	//
	public boolean isFull() {
		return (numItems == maxSize);
	}

	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return (numItems == 0);
	}

	//
	// int | size()
	//
	public int size() {
		return numItems;
	}

	//
	// void | enqueue(int)
	//
	public void enqueue(Visitor value) {
		queue[(front + numItems) % maxSize] = value;
		numItems++;
	}

	//
	// int | dequeue()
	//
	public Visitor dequeue() {
		Visitor temp = queue[front];
		// update the location of front
		front = (front + 1) % maxSize;
		// decrement numItems
		numItems--;
		// return the previous front value
		return temp;
	}

	//
	// int | peek()
	//
	public Visitor peek() {
		return queue[front];
	}

}
