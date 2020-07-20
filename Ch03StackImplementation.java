// Implementing Stack and its operations using array

package javaQuestions;

public class Ch03StackImplementation {

}

class Stack {
	private int array[];
	private int top;
	private int capacity;

	Stack(int capacity){
		this.array = new int[capacity];
		this.capacity = capacity;
		this.top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == capacity-1;
	}
	
	public void push(int item) {
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}
		array[++top] = item;
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return array[top--];
	}
	
	public int peek( ) {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return array[top];
	}
	
}

