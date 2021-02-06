
 package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


public class DBop {
	public Connection getDBcon() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grades","root","");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void closeDBcon(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int insertRows(ArrayList<StudentPOJOClass> list) {
		int rows=0;
		try {
			Connection con = getDBcon();
			String query = "insert into student values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			Iterator<StudentPOJOClass> itr = list.iterator();
			while(itr.hasNext()) {
				StudentPOJOClass ob = itr.next();
				pstmt.setString(1, ob.getRegno());
				pstmt.setString(2,ob.getCoa());
				pstmt.setString(3,ob.getDbms());
				pstmt.setString(4,ob.getFlat());
				pstmt.setString(5,ob.getWad());
				pstmt.setString(6,ob.getOe());
				
				rows=rows+pstmt.executeUpdate();
			}
			closeDBcon(con);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return rows;
	}
	public void selQuery() {
		try {
			Connection con = getDBcon();			
			//SELECT count(*) FROM `student` WHERE coa="F"
			//SELECT count(*) FROM `student` WHERE dbms="F"
			//SELECT count(*) FROM `student` WHERE flat="F"
			//SELECT count(*) FROM `student` WHERE wad="F"
			//SELECT count(*) FROM `student` WHERE oe="F"
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT regno,COUNT('F') FROM student WHERE coa='F' or dbms='F' or flat='F' or wad='F' or oe='F' GROUP BY regno");
			System.out.println("regno\tcount of failed subjects");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}