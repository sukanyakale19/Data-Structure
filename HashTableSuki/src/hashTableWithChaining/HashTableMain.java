package hashTableWithChaining;

import java.util.LinkedList;
import java.util.Scanner;



class Hashtable{
	static class pair {
		private int key;
		private String value;
		
		public pair() {
			key=0;
			value="";
		}
		public pair(int key,String value) {
			this.key=key;
			this.value=value;
		}
		@Override
		public String toString() {
			return "pair [key=" + key + ", value=" + value + "]";
		}
	}
	
	private final int SLOTS=10;
	private LinkedList<pair> table[];
	
	public int hash(int key) {
		return key %SLOTS;
	}
	
	public Hashtable() {
		table=new LinkedList[SLOTS];
		for (int i=0; i<SLOTS; i++)
			table[i] = new LinkedList<>();
	}
	
	public void put(int key,String value) {
		int slot =hash(key);
		LinkedList<pair> bucket=table[slot];
		for(pair pair:bucket) {
			if(key==pair.key) {
				pair.value=value;
				return;
			}
		}
		pair pair =new pair(key,value);
		bucket.add(pair);
	}
	public String get(int key) {
		int slot =hash(key);
		LinkedList<pair> bucket=table[slot];
		for(pair pair:bucket) {
			if(key==pair.key)
				return pair.value;
		}
		return null;
	}
}



class HashTableMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Hashtable ht = new Hashtable();
		ht.put(1, "Nilesh");
		ht.put(4, "Nitin");
		ht.put(8, "Sandeep");
		ht.put(5, "Amit");
		ht.put(24, "Vishal");
		ht.put(34, "Yogesh");
		ht.put(25, "Aakash");
		//ht.put(1, "Rohan");
		
		System.out.print("Enter roll to find: ");
		int roll = sc.nextInt();
		String name = ht.get(roll);
		System.out.println("Name found: " + name);
		
		sc.close();
	
	}

}
