// QueueOfVisitorLL.java

/*
** Name: Razan Arif Alamri
** 9-12-2022
*/

package finallab2022_1;

public class QueueOfVisitorLL {
	private Visitor front;
	private Visitor back;

	// CONSTRUCTOR
	public QueueOfVisitorLL() {
		front = null;
		back = null;
	}

	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return front == null;
	}

	//
	// void | PrintQueue()
	//
	public void PrintQueue() {
		PrintQueue(front);
	}

	//
	// void | PrintQueue(QueueNode)
	//
	private void PrintQueue(Visitor front) {
		// We need to traverse...so we need a help ptr
		Visitor helpPtr = front;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print(helpPtr.getFirstName() + " " + helpPtr.getLastName() + "," + helpPtr.getShowName() + ", "
					+ helpPtr.getTN());
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}

	//
	// boolean | search(int)
	//
	public boolean search(String data) {
		return search(front, data);
	}

	//
	// boolean | search(QueueNode, int)
	//
	private boolean search(Visitor p, String data) {
		// To search, we must traverse. Therefore, we need helpPtr.
		Visitor helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getShowName().equals(data))
				return true;
			helpPtr = helpPtr.getNext(); // step one node over
		}
		return false;
	}

	//
	// void | enqueue(int)
	//
	public void enqueue(Visitor data) {
		if (isEmpty()) {
			front = back = enqueue(front, back, data);
		} else {
			back = enqueue(front, back, data);
		}

	}

	//
	// QueueNode | enqueue(QueueNode, QueueNode, int)
	//
	private Visitor enqueue(Visitor front, Visitor back, Visitor data) {
		if (isEmpty()) {
			return data;
		} else {
			back.setNext(data);
			back = back.getNext();
			return back;
		}
	}

	//
	// QueueNode | dequeue()
	//
	public Visitor dequeue() {
		Visitor temp = front;
		front = dequeue(front);
		if (front == null)
			back = null;
		return temp;
	}

	//
	// QueueNode | dequeue(QueueNode)
	//
	private Visitor dequeue(Visitor front) {
		front = front.getNext();
		return front;
	}

	//
	// int | peek()
	//
	public Visitor peek() {
		// Invoke the peek method with front as a parameter
		Visitor frontValue = peek(front);

		// return topValue
		return frontValue;
	}

	//
	// int | peek(QueueNode)
	//
	private Visitor peek(Visitor front) {
		// Return the data value of the front node.
		// You can see that we do NOT dequeue. We are only returning the data value.
		return front;
	}
}
