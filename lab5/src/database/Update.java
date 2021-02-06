package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class Update {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			String query="update emp set sal=? where empno=?";
			PreparedStatement upsmt=(PreparedStatement) con.prepareStatement(query);
			upsmt.setString(1, "1234");
			upsmt.setString(2, "18");
			
			int rows=upsmt.executeUpdate();
			System.out.println(rows+" row(s) are updated.");
			
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			System.out.println("eno\tename\tsaly\tedept");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				
			} 
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		

	}

}