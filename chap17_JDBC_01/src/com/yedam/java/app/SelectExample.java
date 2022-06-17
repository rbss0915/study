package com.yedam.java.app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {

	public static void main(String[] args) throws Exception {
		//1.JDBC Driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.DB서버 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		//3.Statement or PreparedStatement 객체 생성
		Statement stmt = con.createStatement();
		
		//4.Query 구성
		String sql = "SELECT * FROM employees WHERE Last_name = 'King'";
		
		//5.Query 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		//6.결과값 출력
		while(rs.next()) {
			String name = rs.getString("first_name") + " " + rs.getString("last_name");
			System.out.println(name);
		}
		
		//7.자원해제		생성순서 반대
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();

	}
}