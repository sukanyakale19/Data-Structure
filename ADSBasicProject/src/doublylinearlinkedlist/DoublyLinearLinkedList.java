package doublylinearlinkedlist;

import java.util.Scanner;



class DoublyList{
	static class Node{
		private int data;
		private Node next;
		private Node prev;
		
		public Node() {
			data=0;
			next=null;
			prev=null;
		}
		public Node(int val) {
			data=val;
			next=null;
			prev=null;
		}
	}
	private Node head;
	
	public DoublyList() {
		head=null;
	}
	
	public void displayForward() {
		System.out.println(" Forward list:");
		Node trav=head;
		while(trav !=null) {
		System.out.println("->" +trav.data);
		trav=trav.next;
		}
	}
	
	public void displayReverse() {
		System.out.println(" Reverse list:");
		if(head == null)
			return;
		Node trav=head;
		while(trav.next !=null) {
		trav=trav.next;
		}
		while(trav !=null) {
			System.out.println("->" +trav.data);
			trav=trav.prev;
		}
	}
	public boolean isEmpty() {
		return head == null;
	}
	
	
	public void addLast( int val) {
		// create new node & init it
				Node newNode = new Node(val);
				// special 1: if list is empty, make new node as first node of list
				if(head == null) {
					head = newNode;
				}
				// general: add node at the end
				else {
					// traverse till last node
					Node trav = head;
					while(trav.next != null)
						trav = trav.next;
					// add new node after trav (trav.next)
					trav.next = newNode;
					//new nodes prev to last node(trav)
					newNode.prev=trav;
				}
			}
	public void addFirst(int val) {
		Node newNode=new Node(val);
		if(isEmpty()) {
			head=newNode;		
		}
		else {
		newNode.next=head;
		head.prev=newNode;
		head=newNode;
		
		}
	}
	
	public void addAtPos(int val,int pos) {
		if(head==null || pos<=1) {
		addFirst(val);
	}
	else 
	{
		Node newNode=new Node(val);
		Node temp, trav=head;
		for(int i=1; i<pos-1; i++) {
			if (trav.next==null)
				break;
			trav=trav.next;
		}
		temp=trav.next;
		newNode.next=temp;
		newNode.prev=trav;
		trav.next=newNode;
		if(temp!=null)
			temp.prev=newNode;
			
		}
		
		
	}
	public void delFirst() {
		if (head==null) {
			throw new RuntimeException("list is empty!!");
			
		}
		else
		{
			head=head.next;
			head.prev=null;
		}
	}
	public void delAtPos(int pos) {
		if(pos == 1) {
			delFirst();
		}
		if(head ==null || pos<1)
			throw new RuntimeException("list is empty");
		Node trav =head;
		for(int i=1;i<pos;i++) {
			if(trav==null)
				System.out.println("Invalid Position");
			trav =trav.next;
		}
		trav.prev.next=trav.next;
		if(trav.next !=null)
			trav.next.prev=trav.prev;
		
	}
	public void delLast() {
		Node trav=head, temp=null;
		if(head== null)
			throw new RuntimeException("List is empty");
		if(head.next ==null)
			head=null;
		while(trav.next !=null) {
			temp=trav;
			trav=trav.next;
		}
			temp.next=null;
			trav=null;
	}
	public void delAll() {
		head=null;
		System.out.println("list is empty");
	}


	
}

public class DoublyLinearLinkedList {
	public static void main(String[] args) {
		int choice, val, pos;
		DoublyList list = new DoublyList();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n0. Exit\n1. Display\n2. Add First\n3.  Add Last\n4. Add At Pos\n5. Del First\n6.  Del Last\n7. Del At Pos\n8. Del All\nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // Display
				list.displayForward();
				list.displayReverse();
				break;
			case 2: // Add First
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				list.addFirst(val);
				break;
			case 3: // Add Last
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				list.addLast(val);
				break;
			case 4: // Add At Pos
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				System.out.print("Enter element position: ");
				pos = sc.nextInt();
				list.addAtPos(val, pos);				
				break;
			case 5: // Del First
				try {
					list.delFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6: // Del Last
				try {
					list.delLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7: // Del At Pos
				System.out.print("Enter element position: ");
				pos = sc.nextInt();
				try {
					list.delAtPos(pos);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8: // Del All
				list.delAll();
				break;
			}
		} while(choice!=0);
		sc.close();
	}
}
