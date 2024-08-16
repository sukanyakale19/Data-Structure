package sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void selectionSortMain(int [] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			 System.out.println(Arrays.toString(arr));//for printing after each pass
		}
	}

	public static void main(String[] args) {
		 
		
		int[] arr= {6,4,2,8,3,1};
		System.out.println("selection sort");
		System.out.println("Before: "+Arrays.toString(arr));
		selectionSortMain(arr);
		System.out.println("After: "+Arrays.toString(arr));

	}

}
