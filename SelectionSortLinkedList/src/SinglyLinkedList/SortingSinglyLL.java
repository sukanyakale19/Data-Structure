package SinglyLinkedList;



public class SortingSinglyLL {
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
		
		public SortingSinglyLL() {
			head=null;
		}
		void display() {
			System.out.println("List :");
			Node trav=head;
			while(trav !=null) {
				System.out.println("->"+trav.data );
				trav=trav.next;
			}
			
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
		public void singlyListAscendingSort() {
			Node i,j;
			for(i=head ;i.next!=null; i=i.next) {
				for( j=i.next; j!=null; j=j.next ) {
					if(i.data>j.data) {
						int temp=i.data;
					    i.data=j.data;
					    j.data=temp;
					}
				}
			}
			display();
			
		}
		public void ReverseSinglyLL() {
			Node oldhead = head;
			head=null;
			while(oldhead !=null) {
				Node temp=oldhead;
				oldhead=oldhead.next;
				temp.next=head;
				head=temp;
				
			}
			display();
			
		}
		
		
		
	}



