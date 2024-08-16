package searching;

import java.util.Scanner;

public class BinarySearch {
	
	public static int binarySearchMain(int[] arr,int key) {
		int left =0, right =arr.length -1, mid;
	while(left <=right) {
		mid=(left+right)/2;
		if(key ==arr[mid])
			return mid;
		if(key< arr[mid])
			right= mid-1;//focus on left side of array.
		else
			left=mid+1;//focus on right side of array
	}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr= {11,22,33,44,55,66,77,88,99};
		System.out.println("Enter key to search:");
		int key=sc.nextInt();
		int index=binarySearchMain(arr,key);
		if(index !=-1)
			System.out.println("key found at index:" +index);
		else
			System.out.println("key not found...");
		

	}

}
