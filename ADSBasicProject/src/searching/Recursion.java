package searching;

import java.util.Scanner;

public class Recursion {
	
	public static int recBinarySearch(int[] arr,int left,int right, int key) {
		
		if(right < left)
				return -1;
		int index, mid= (left+right)/2;
		if(key ==arr[mid])
			return mid;
		if(key< arr[mid])
			index =recBinarySearch(arr,left,mid-1,key);
		else
			index=recBinarySearch(arr,mid+1,right,key);
		return index;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr= {11,22,33,44,55,66,77,88,99};
		System.out.println("Enter key to search:");
		int key=sc.nextInt();
		int index=recBinarySearch(arr,0,arr.length-1,key);
		if(index !=-1)
			System.out.println("key found at index:" +index);
		else
			System.out.println("key not found...");
		
		
	}

}
