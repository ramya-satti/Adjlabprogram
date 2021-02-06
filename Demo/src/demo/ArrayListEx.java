package demo;
import java.util.ArrayList;
public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> ob = new ArrayList<String>();
		ob.add("Ramya");
		ob.add("vyshu");
		ob.add("Sowmya");
		System.out.println("Currently the arraylist has following elements:"+ob);
		ob.add(1,"vyshu");
		ob.add(2,"Ramya");
		ob.remove("sowmya");
		System.out.println("Currently the arraylist has following elements:"+ob);
		
	}

}
