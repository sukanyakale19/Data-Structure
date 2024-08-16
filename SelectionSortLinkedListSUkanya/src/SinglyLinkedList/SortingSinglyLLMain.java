package SinglyLinkedList;

import java.util.Scanner;

;

public class SortingSinglyLLMain {

	public static void main(String[] args) {
		int choice,val,pos;
		SortingSinglyLL list=new SortingSinglyLL();
		Scanner sc =new Scanner(System.in);
		
		do {
			System.out.println("\n0. Exit\n1. Display\n2. Add First\n3. Add Last\n4. Add At Position\n5. Del First\n6. Del Last\n7. Del At Position\n8. Del All\n9. Singly Linked List SElection Sort\n10. ReverseSinglyLinkedList\n11. recReverse\n12. reverseDisplay Only\n13. find MId Element\n Enter Chice :");
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
			case 4://Add First
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
			case 9://Ascending 
				list.singlyListAscendingSort();
				break;
			case 10://reversing sigly linked list
				list.ReverseSinglyLL();
				break;
			case 11://reverse list in recurrsive manner
				list.recReverse();
				break;
			case 12://display list in reverse order not sorting
				list.reverseDisplay();
				break;
			case 13://display list in reverse order not sorting
				
				System.out.println("Middle:" +list.findMid());
				break;
				
				
				
				
			}
			
		}while(choice!=0);
			sc.close();

	}
}
