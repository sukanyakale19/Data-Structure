package sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSortMain(int [] arr) {
		for(int i=0; i<arr.length-1; i++) {
			//for(int j=0; j<arr.length-1; j++) 
			//improved bubble sort to avoid more comparisions
			for(int j=0; j<arr.length-1-i; j++)
				{
				if(arr[j] > arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}
	public static void ImprovedbubbleSort(int [] arr) {
		for(int i=0; i<arr.length-1; i++) {
			boolean swapFlag =false;
		
			for(int j=0; j<arr.length-1-i; j++)
				{
				if(arr[j] > arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapFlag = true;
				}
			}
			if(! swapFlag)
				break;
		}
		
	}

	public static void main(String[] args) {
		
		int arr[]	= {6,4,2,8,3,1};
		System.out.println("*******Bubble sorting*******");
		System.out.println("Before  Bubble sorting: " +Arrays.toString(arr));
		//bubbleSortMain(arr);
		ImprovedbubbleSort(arr);
		System.out.println("After  Bubble sorting: " +Arrays.toString(arr));

	}

}
