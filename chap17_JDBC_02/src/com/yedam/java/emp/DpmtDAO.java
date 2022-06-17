package com.yedam.java.emp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DpmtDAO {
	//싱글톤
	private static DpmtDAO dpmtDAO = null;
	private DpmtDAO() {}
	public static DpmtDAO getInstance() {
		if(dpmtDAO == null) {
			dpmtDAO = new DpmtDAO();
		}
		return dpmtDAO;
	}
	
	//Oracle 연결정보
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectedPwd;
	
	//각 메소드에서 공통적으로 사용하는 필드
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void connect() {
		dbConfig();
		try {
		//1.JDBC Driver 로딩
		Class.forName(jdbc_driver);
		//2.DB 서버 접속
		conn = DriverManager.getConnection(oracle_url, connectedId, connectedPwd);
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		}catch(SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}
	
	private void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();
		
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("password");
	}
	
	//4.자원 해제
	public void disconnect() {
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//3.CRUD 실행
	//전체조회
	public List<Department> selectAll(){
		List<Department> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM departments");
			while(rs.next()) {
				Department dpmt = new Department();
				dpmt.setDepartmentId(rs.getInt("department_id"));
				dpmt.setDepartmentName(rs.getString("department_name"));
				dpmt.setManagerId(rs.getInt("manager_id"));
				dpmt.setLocationId(rs.getInt("location_id"));
				
				list.add(dpmt);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	//단건조회
	public Department selectOne(int departmentId) {
		Department dpmt = null;
		try {
			connect();
			String sql = "SELECT * FROM departments WHERE department_id = " + departmentId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dpmt = new Department();
				dpmt.setDepartmentId(rs.getInt("department_id"));
				dpmt.setDepartmentName(rs.getString("department_name"));
				dpmt.setManagerId(rs.getInt("manager_id"));
				dpmt.setLocationId(rs.getInt("location_id"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return dpmt;
	}
	//등록
	public void insert(Department dpmt) {
		try {
			connect();
			String sql = "INSERT INTO employees VALUE (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dpmt.getDepartmentId());
			pstmt.setString(2,dpmt.getDepartmentName());
			pstmt.setInt(3,dpmt.getManagerId());
			pstmt.setInt(4,dpmt.getLocationId());
	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정
	public void update(Department dpmt) {
		try {
			connect();
			String sql = "UPDATE departments SET departmentName = ? WHERE department_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dpmt.getDepartmentName());
			pstmt.setInt(2,dpmt.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정되지않음");
			}
			System.out.println(result + "건이 완료");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(int departmentId) {
		try {
			connect();
			String sql = "DELETE FROM departments WHERE department_id = " + departmentId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result > 0) {
				System.out.println("정상적으로 삭제되었습니다");
			}else {
				System.out.println("정상 삭제 되지 않았습니다.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	
	



}
