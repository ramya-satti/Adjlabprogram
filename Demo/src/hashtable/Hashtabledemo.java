package hashtable;

import java.util.Hashtable;
import java.util.Map;

public class Hashtabledemo {
	public static void main(String[] args) {
	Hashtable<Integer,String> ht = new Hashtable<Integer,String>();
	ht.put(1,"Ramya");
	ht.put(2,"vyshu");
	ht.put(3,"sowmya");
	System.out.println("Size of hash table = "+ht.size());
	for(Map.Entry m:ht.entrySet()) {
		System.out.println(m.getKey()+" "+m.getValue());
	}
	}
	
}
