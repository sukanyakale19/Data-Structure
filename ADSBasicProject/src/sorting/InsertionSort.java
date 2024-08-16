package sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void insertionSortMain(int [] arr) {
		//n-1 passes in each pass consider ith element as last element of array
		for(int i=1; i<arr.length; i++) {
		//compare temp with all elements before that find apporopriate for the element and insert temp at that position 
			int j,temp=arr[i];
			for(j=i-1; j>=0 && arr[j]> temp; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
		
	}

	public static void main(String[] args) {
		
		int arr[]	= {6,4,2,8,3,1};
		System.out.println("*******Insertion sorting*******");
		System.out.println("Before  Insertion sorting: " +Arrays.toString(arr));
		
		insertionSortMain(arr);
		System.out.println("After  Insertion sorting: " +Arrays.toString(arr));

		

	}

}
