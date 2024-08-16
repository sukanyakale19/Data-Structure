package SinglyLinearLinkedList;

import java.util.Scanner;

class singlyList{
	static class Node{
		private int data;
		private Node next;
		
		public Node() {
			data =0;
			next=null;
			}
		public Node(int val) {
			data=val;
			next=null;
		}
		}
	private Node head;
	
	public singlyList() {
		head=null;
	}
	void display() {
		System.out.println("List :");
		Node trav=head;
		while(trav !=null) {
			System.out.println(trav.data);
			trav=trav.next;
		}
		System.out.println("");
	}
	public void addFirst(int val) {
		Node newNode=new Node (val);
		newNode.next=head;
		head=newNode;	
	}
	public void addLast(int val) {
		Node newNode=new Node (val);
		if(head ==null) {
			head=newNode;
			
		}
		else {
			Node trav=head;
			while(trav.next !=null)
				trav=trav.next;
			trav.next=newNode;
		}
		
		
	}
	public void addAtPos(int val, int pos) {
		
		if(head ==null || pos<=1) {
			addFirst(val);
		}
		else {
		Node newNode=new Node(val);
		Node trav=head;
		for(int i=1; i<pos-1 ;i++) {
			if(trav.next==null)
				break;
			trav=trav.next;
			
		}
		newNode.next=trav.next;
		trav.next=newNode;
		}
		
	}
	public void deleteAll() {
		head=null;	
	}
	public void deleteLast() {
		if(head==null)
			throw new RuntimeException("list is empty");
		
		if(head.next==null) {
			head=null;
		}
		Node temp=null,trav=head;
		while(trav.next!=null) {
			temp=trav;
			trav=trav.next;
		}
		//when last node is deleted the second last node(temp)next should be null
		temp.next=null;
		
	}  
	
	
	
}


public class SinglyLinkedList {
	
	public static void main(String[] args) {
		int choice,val,pos;
		singlyList list=new singlyList();
		Scanner sc =new Scanner(System.in);
		
		do {
			System.out.println("\n0. Exit\n1. Display\n2. Add First\n3. Add Last\n4. Add At Position\n5. Del First\n6. Del Last\n7. Del At Position\n8. Del All\n Enter Chice :");
			choice= sc.nextInt();
			
			switch (choice) {
			case 1://display
				list.display();
				break;
				
			case 2://Add First
				System.out.println("Enter new Element:");
				val=sc.nextInt();
				list.addFirst(val);		
				break;
			case 3://Add First
				System.out.println("Enter new Element:");
				val=sc.nextInt();
				list.addLast(val);		
				break;
			case 4://AddAtpos
				System.out.println("Enter new Element:");
				val=sc.nextInt();
				System.out.println("Enter element position:");
				pos=sc.nextInt();
				list.addAtPos(val,pos);		
				break;
			case 6://Delete Last
				try {
				list.deleteLast();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8://Delete All
				list.deleteAll();		
				break;
				
			}
			
		}while(choice!=0);
			sc.close();

	}

}
