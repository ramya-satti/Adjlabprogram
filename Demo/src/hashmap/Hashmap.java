package hashmap;

import java.util.HashMap;

public class Hashmap {
	public static void main(String[] args) {
	HashMap<Integer,String> hm = new HashMap<Integer,String>();
	hm.put(101,"Ramya");
	hm.put(102,"Vyshu");
	hm.put(103,"sowmya");
	System.out.println("Size of hashmap = "+hm.size()); 
	if(hm.containsKey(101)) {
		String a = hm.get(101);
		System.out.println("value of key \"101\" is "+a);
	 }
	}
		
}