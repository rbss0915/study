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

public class EmpDAO {
	//싱글톤
	private static EmpDAO empDAO = null;
	private EmpDAO() {}					//나눈 이유. 어느시점에 인스턴스 생성하느냐. 겟인스턴스 돌면 만들게. 시작동시에 만들어지면 불필요. 불확실.
	public static EmpDAO getInstance() {
		if(empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}
	
	//Oracle 연결 정보
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
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt!= null) pstmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//3.CRUD 실행 - 선택사항
	//전체조회
	public List<Employee> selectAll(){
		List<Employee> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees");
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHirDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommision(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				
				list.add(emp);
			
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	//단건조회
	public Employee selectOne(int employeeId) {
		Employee emp = null;		//단건조회 널로 초기화.
		try {
			connect();
			String sql = "SELECT * FROM employees WHERE employee_id = " + employeeId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHirDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommision(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
			}
				
			
		}catch(SQLException e) {
			e.printStackTrace();  	//catch에 뭐라도 넣어라. 비워두면 걍종료됨	
		}finally {
			disconnect();
		}
		return emp;
	}
	//등록
	public void insert(Employee emp) {
		try {
			connect();
			String sql = "INSERT INTO employees VALUE (?,?,?,?,?,?,?,?,?,?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,emp.getEmployeeId());
			pstmt.setString(2,emp.getFirstName());
			pstmt.setString(3,emp.getLastName());
			pstmt.setString(4,emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHirDate());
			pstmt.setString(7, emp.getJobId());
			pstmt.setDouble(8, emp.getSalary());
			pstmt.setDouble(9,emp.getCommision());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("등록이 완료료되었습니다.");
			}else {
				System.out.println("등록되지 않았습니다.");
				
			}
			System.out.println(result + "건이 완료되었습니다.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//수정
	public void update(Employee emp) {
		try {
			connect();
			String sql = "UPDATE employees SET salary = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,emp.getEmployeeId());
			pstmt.setDouble(2, emp.getSalary());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정이 완료료되었습니다.");
			}else {
				System.out.println("수정되지 않았습니다.");
				
			}
			System.out.println(result + "건이 완료되었습니다.");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//삭제
	public void delete(int employeeId) {
		try {
			connect();
			String sql = "DELETE FROM employees WHERE employee_id = " + employeeId;
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