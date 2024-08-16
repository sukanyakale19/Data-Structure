package linearQueue;

import java.util.Scanner;

class linearQueue{
	private int[] arr;
	private int front,rear;
	
	public linearQueue(int size) {
		arr = new int[size];
		rear=-1;
		front=-1;
		
	}
	public boolean isFull() {
		return rear==arr.length-1;
		
	}
	public boolean isEmpty() {
		return rear==front;
	}
	public void push(int val) {
		if(isFull())
			throw new RuntimeException("Queue is Full");
		rear++;
		arr[rear]=val;
	}
	public void pop() {
		if(isEmpty())
			throw new RuntimeException("Queue is Empty");
		front++;
	}
	public int peek() {
		if(isEmpty())
			throw new RuntimeException("Queue is Empty");
		return arr[front+1];
	}
	
}

public class LinearQueueMain {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		linearQueue q=new linearQueue(6);
		int choice,val;
		do {
		
			System.out.println("\n0. Exit\n1. push\n2. pop\n3. peek\n Enter your Choice:");
			choice=sc.nextInt();
			switch(choice) 
			{
			case 1: // push
				try {
					System.out.print("Enter value to push: ");
					val = sc.nextInt();
					q.push(val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: // pop
				try {
					val = q.peek();
					q.pop();
					System.out.println("Popped: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: // peek
				try {
					val = q.peek();
					System.out.println("Peek: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			}
			
			
			
			
		}while( choice !=0);
		sc.close();
		

	}

}
