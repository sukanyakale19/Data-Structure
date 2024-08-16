package cicularQueue;

	import java.util.Scanner;

	class circularQueue{
		private int[] arr;
		private int front,rear;
		
		public circularQueue(int size) {
			arr = new int[size];
			rear=-1;
			front=-1;
			
		}
		public boolean isFull() {
			return (front==-1 && rear==arr.length-1) ||(front==rear && front!=-1);
			
		}
		public boolean isEmpty() {
			return (front==rear && front==-1);
		}
		public void push(int val) {
			if(isFull())
				throw new RuntimeException("Queue is Full");
			rear=(rear+1)%arr.length;
			arr[rear]=val;
		}
		public void pop() {
			if(isEmpty())
				throw new RuntimeException("Queue is Empty");
			front=(front+1)%arr.length;
			if(front==rear) {
				front=-1;
				rear=-1;
			}
		}
		public int peek() {
			if(isEmpty())
				throw new RuntimeException("Queue is Empty");
			int index = (front + 1) % arr.length;
			return arr[index];
		}
		
	}

	public class CircularQueueMain {
		public static void main(String[] args) {
			
			Scanner sc=new Scanner(System.in);
			circularQueue q=new circularQueue(6);
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



