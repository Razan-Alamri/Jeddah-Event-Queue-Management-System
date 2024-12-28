// StackOfTN.java

/*
** Name: Razan Arif Alamri
** 9-12-2022
*/
package finallab2022_1;

import java.io.PrintWriter;

public class StackOfTN {
	private int[] ticketNo;
	private int maxSize;
	private int top;

	// Constructor
	public StackOfTN(int size) {
		maxSize = size; // set array size
		ticketNo = new int[maxSize]; // create array for stack
		top = -1; // set top to -1 (no items in stack yet)
	}

	//
	// boolean | isFull()
	//
	public boolean isFull() {
		return (top == maxSize - 1);
	}

	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return top + 1;
	}

	//
	// int | pop()
	//
	public int pop() {
		return ticketNo[top--];
	}

	//
	// int | peek()
	//
	public int peek() {
		return ticketNo[top];
	}

	//
	// void | push(int)
	//
	public void push(int value) {
		ticketNo[++top] = value;
	}

	//
	// boolean | search(int)
	//
	public boolean search(int value) {
		for (int i = 0; i <= top; i++) {
			// if the value is found at stack[i], return true
			if (ticketNo[i] == value)
				return true;
		}
		// If we make it till here, the value was not found in the array.
		return false;
	}

	//
	// void | PrintStack()
	//
	public void PrintStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(ticketNo[i] + ", ");
		}
		// print a newline
		System.out.println();
	}

}
