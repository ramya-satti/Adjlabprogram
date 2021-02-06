
package databases;

import java.util.ArrayList;

public class sgrade {
	public static void main(String[] args) {
		ReadFromCSVFile csv = new ReadFromCSVFile();
		ArrayList list = csv.readFromCSV();
		DBop op = new DBop();
		
		
//		int n =op.insertRows(list);
//		System.out.println(n+" row(s) inserted sucessfully");
		
		op.selQuery();
		
	}
}