package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConTest {

	public static void main(String[] args) {

//		String url = "jdbc:mysql://localhost:3306/jsp";
//		String id = "root";
//		String pwd = "1234";
	
		Connection con;
		try {

//			Class.forName("org.mariadb.jdbc.Driver");
//			con = DriverManager.getConnection(url, id, pwd)

			DBcon db = new DBcon();
			con = db.getCon();
			System.out.println("연결성공");
			String name = "전우치";
			String sql = "select * from user where id=?";
			
			
			//보안상 문제로 이런 방식으로 coding 하지 않음
			//String name = "전우치";
			//String sql = "select * from user";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("id") + ", ");
				System.out.print(rs.getString("pwd") + ", ");
				System.out.println(rs.getString("name"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

